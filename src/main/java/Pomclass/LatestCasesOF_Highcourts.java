package Pomclass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.CommonVerification;
import generic.Library;
import generic.PaginationsUtility;
import generic.SwitchWindow;

public class LatestCasesOF_Highcourts  extends BasePage1 {

	public LatestCasesOF_Highcourts(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath="/html/body/div[3]/main/a[1]/button") private WebElement latestcasebtn;
	@FindBy (xpath="//select[@id='date_filter']") private WebElement datefilterdropdown;
	@FindBy (xpath="//select[@id='sortBy']") private WebElement sortbydropdown;
	@FindBy(xpath="//*[@id=\"court-tabs\"]/li[2]/a") private WebElement highcourtbtn;
	@FindBy (xpath="//*[@id=\"select_court\"]") private WebElement selectcourtbtn;
	@FindBy (xpath="//*[@id=\"subCourtValue\"]/div/label/span")private List<WebElement> selectsubcourtoption;
	@FindBy(xpath="//*[@id=\"result\"]/div[2]/div[1]/a") private WebElement subcourtcases;
	
		
	public List<String> CheckAllcaesLinksofHighcourtCases(WebDriver driver) throws InterruptedException
	{
		
     Library.click(driver,latestcasebtn , "Clicked on ClickActlistbtn");
 		
		Library.threadSleep(2000);
               Library.click(driver,highcourtbtn , "Clicked on highcourt");
               List<String> brokenUrls = new ArrayList<>();
       	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
               WebElement filter = driver.findElement(By.xpath("//*[@id='date_filter']"));
               new Select(filter).selectByVisibleText("7 Days");
               Thread.sleep(2000);
              WebElement totalcasecount = driver.findElement(By.xpath("//*[@id=\"court2\"]/small"));
              String total1= totalcasecount.getText();
              System.out.println("Totatl Cases:"+total1);
       	    boolean hasNext = true;
       	    while (hasNext) {
       	        List<WebElement> caseElements = driver.findElements(By.xpath("//*[@id='result']/div/div/a"));
       	        int total = caseElements.size();
       	        for (int i = 0; i < total; i++) {
       	            caseElements = driver.findElements(By.xpath("//*[@id='result']/div/div/a"));
       	            WebElement element = caseElements.get(i);

       	            // Save handles before click
       	            Set<String> handlesBefore = driver.getWindowHandles();

       	            try {
       	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
       	                // Wait until new tab opens
       	                wait.until(d -> d.getWindowHandles().size() > handlesBefore.size());

       	                
       	                SwitchWindow.switchWindowByIndex(driver, 2);
       	                Thread.sleep(2000);

       	               
       	                if (CommonVerification.isErrorPage(driver)) {
       	                    brokenUrls.add(driver.getCurrentUrl());
       	                }
       	            } catch (Exception e) {
       	                System.out.println("Error in case " + i + ": " + e.getMessage());
       	            } finally {
       	                
       	                if (driver.getWindowHandles().size() > 1) {
       	                    driver.close(); 
       	                    SwitchWindow.switchWindowByIndex(driver, 1);
       	                    Thread.sleep(1000);
       	                }
       	            }
       	        }

       	        hasNext = PaginationsUtility.clickNextPagination(driver);
       	    }

       	    return brokenUrls;
       	}
}
