package Pomclass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.CommonVerification;
import generic.PaginationsUtility;
import generic.SwitchWindow;

public class LatestSupremeCourtCases extends BasePage1 {

	public LatestSupremeCourtCases(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "(//button[@class='btn btn-warning latest-case-link btn-sm d-flex align-items-center'])[1]")
	private WebElement clickbtn;
	public List<String> checkSupremeCourtCases(WebDriver driver) throws Exception {
	    clickbtn.click(); 
	    Thread.sleep(2000);

	    List<String> brokenUrls = new ArrayList<>();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	   
	    Select filterSelect = new Select(driver.findElement(By.id("date_filter")));
	    filterSelect.selectByVisibleText("60 Days");
	    Thread.sleep(2000);

	    
	    try {
	        WebElement totalcasecount = driver.findElement(By.xpath("//*[@id=\"court1\"]/small"));
	        System.out.println("Total Supreme Court Cases: " + totalcasecount.getText());
	    } catch (Exception e) {
	        System.out.println("Total case count not found.");
	    }

	    boolean hasNext = true;

	    while (hasNext) {
	        List<WebElement> caseElements = driver.findElements(By.xpath("//*[@id='result']/div/div/a"));

	        for (int i = 0; i < caseElements.size(); i++) {
	            caseElements = driver.findElements(By.xpath("//*[@id='result']/div/div/a"));
	            WebElement element = caseElements.get(i);

	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	            Set<String> handlesBefore = driver.getWindowHandles();
	            ((JavascriptExecutor) driver).executeScript("window.open(arguments[0].href,'_blank');", element);
	            Thread.sleep(2000);

	            
	            wait.until(d -> d.getWindowHandles().size() > handlesBefore.size());
	            SwitchWindow.switchWindowByIndex(driver, 2);

	            Thread.sleep(2000);
	            if (CommonVerification.isErrorPage(driver)) {
	                brokenUrls.add(driver.getCurrentUrl());
	            }

	            
	            driver.close();
	            SwitchWindow.switchWindowByIndex(driver, 1);

	            
	            try {
	                Select reSelect = new Select(driver.findElement(By.id("date_filter")));
	                reSelect.selectByVisibleText("30 Days");
	                Thread.sleep(1500);
	            } catch (Exception ex) {
	                System.out.println("Filter reapplication failed: " + ex.getMessage());
	            }
	        }

	       
	        hasNext = PaginationsUtility.clickNextPagination(driver);
	        Thread.sleep(2000);
	    }

	    return brokenUrls;
	}
}
