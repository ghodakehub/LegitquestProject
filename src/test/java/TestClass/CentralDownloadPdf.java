package TestClass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import Pomclass.DownloadPdfForCentral;
import Pomclass.Login;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import io.qameta.allure.Allure;

public class CentralDownloadPdf extends NewBaseTest{
	

	
	
	  @Test()
	    public void verifyFirstDownloadForEachType() throws Exception {
		 
		 Allure.step("Login with by Valid credentails");
			Login log= new Login(driver);
			
			 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
	      
			 DownloadPdfForCentral  actList = new DownloadPdfForCentral(driver);
			    actList.openActListPage();
			    Thread.sleep(3000); 

			    
			    List<String> failedTypes = new ArrayList<>();
			    List<String> failedUrls = new ArrayList<>();

			    String actListUrl = "https://www.legitquest.com/actlist";
			    String[] allTypes = {"Main Act","amendment","circular","form","manual","notification", 
			                         "order","ordinance","policy","pressrelease","regulation","rule",
			                         "schemesguideline","stateamendment"};

			    for (String typeValue : allTypes) {
			        try {
			            System.out.println("Checking type: " + typeValue);
			            actList.selectActType(typeValue);
			            Thread.sleep(3000);

			            List<WebElement> downloadButtons = actList.getDownloadButtons();
			            if (downloadButtons.isEmpty()) {
			                System.out.println("No download button found for type: " + typeValue);
			                continue;
			            }

			           
			            WebElement firstBtn = downloadButtons.get(0);
			            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstBtn);
			            Thread.sleep(4000); 

			            
			            String pageSource = driver.getPageSource();
			            String title = driver.getTitle();
			            String currentUrl = driver.getCurrentUrl();

			            if (pageSource.contains("404") ||
			                pageSource.contains("API request failed") ||
			                currentUrl.contains("file_url=undefined") ||
			                title.toLowerCase().contains("error") ||
			                pageSource.toLowerCase().contains("client error")) {

			                System.out.println("PDF failed for type: " + typeValue);
			                

			                failedTypes.add(typeValue);
			                failedUrls.add(currentUrl);

			                // Navigate back to Act List
			                driver.navigate().to(actListUrl);

			                
			                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			                WebElement centralTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'CENTRAL LIST')]")));
			                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", centralTab);
			                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='recordType']")));
			                Thread.sleep(1500);

			            } else {
			                System.out.println("PDF downloaded successfully for type: " + typeValue);
			               
			            }

			        } catch (Exception e) {
			            System.out.println("Exception for type: " + typeValue + " - " + e.getMessage());
			            driver.navigate().to(actListUrl);
			        }
			    }

			   
			    if (!failedTypes.isEmpty()) {
			        StringBuilder errorReport = new StringBuilder();
			        errorReport.append("PDF Download failed for the following types:\n\n");

			        for (int i = 0; i < failedTypes.size(); i++) {
			            errorReport.append((i + 1)).append(". Type: ").append(failedTypes.get(i))
			                       .append("\nURL: ").append(failedUrls.get(i)).append("\n\n");
			        }
			        String screenshot = UtilityClass.Capaturescreenshot(driver, "pdf_error_");
			        ForMultiplemailReceipent.sendEmail(
			                driver,
			                new String[]{"ghodake6896@gmail.com"},
			                "PDF Download Error Report - Central List",
			                errorReport.toString(),
			                screenshot,
			                null
			        );
			    }
			    }
}

