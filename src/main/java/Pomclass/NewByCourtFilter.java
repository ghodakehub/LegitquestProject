package Pomclass;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import UtilityClass.UtilityClass;
import generic.AllureListeners;
import generic.ForMultiplemailReceipent;

public class NewByCourtFilter extends BasePage1 {

	public NewByCourtFilter(WebDriver driver) {
		super(driver);
	
	}
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	@FindBy(xpath = "//input[@id='search']") 
	private WebElement searchbox;

	@FindBy(xpath = "//div[@class='search-btn']") 
	private WebElement SearchButton;
	

    public void checkCourtFilter() {
        try {
            searchbox.sendKeys("ram");
            wait.until(ExpectedConditions.elementToBeClickable(SearchButton)).click();
      

            String[] courtOptions = {"SUPREME COURT", "HIGH COURT", "TRIBUNAL", "DISTRICT COURT"};

            for (String court : courtOptions) {
                applyCourtFilter(court);
                verifyResults(court);
            }
        } catch (Exception e) {
            //e.printStackTrace(); 
        }
    }
    public void applyCourtFilter(String courtName) {
        try {
           
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".blockUI.blockOverlay")));

           
            WebElement courtFilter = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//label[contains(.,'" + courtName + "')]")));

            
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", courtFilter);

            
            wait.until(ExpectedConditions.elementToBeClickable(courtFilter));

           
            courtFilter.click();
        } catch (Exception e) {
           // e.printStackTrace(); 
        }
    }

    public void verifyResults(String courtName) {
        try {
            List<WebElement> results = driver.findElements(By.xpath("//div[contains(@class, 'card-body p-0')]"));

            if (results.isEmpty()) {
                System.out.println("No results for " + courtName + " or loading issue detected.");
                AllureListeners.captureScreenshot(driver, courtName.replace(" ", "_"));
                String screenshot=  UtilityClass.Capaturescreenshot(driver,"FilterError" );

        		String testUrl = driver.getCurrentUrl();  
        		 ForMultiplemailReceipent.sendEmail(
                   	   driver, new String[]{"ghodake6896@gmail.com"},
                   	    "LR-Filter by courtwise",
                   	    "Please check issue coming in Search Result when we apply filter for by court no result found , please find the attached screenshot for details." ,
                   	 screenshot , testUrl
                   	   
                   	);
                
            } else {
                System.out.println("Results found for " + courtName);
            }
        } catch (Exception e) {
           // e.printStackTrace(); 
        }
    }

}



