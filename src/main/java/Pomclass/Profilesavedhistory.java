package Pomclass;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import generic.AllureListeners;
import generic.Errordetectionemethod;

public class Profilesavedhistory extends BasePage1 {

	public Profilesavedhistory(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id=\"navbarsExampleDefault\"]/ul/li/a")
	private WebElement profilename;                 
	
	@FindBy(xpath = "//a[text()='Profile']")        
	private WebElement profile;
	
	public List<String> verifyProfileActions(WebDriver driver) throws InterruptedException {
		  
        Actions act = new Actions(driver);
        act.moveToElement(profilename).perform();
        act.click().perform();
        profile.click();
        Thread.sleep(2000);
        
        List<String> brokenUrls = new ArrayList<>();

 
     driver.findElement(By.xpath("//button[contains(text(),'Saved Search')]")).click();
     Thread.sleep(2000);

     if (Errordetectionemethod.isErrorPage(driver)) {
        AllureListeners. captureScreenshot(driver, "SearchHistoryMainError.png");
         brokenUrls.add(driver.getCurrentUrl() + " - Search History main page failed");
     } else {
         
         while (true) {
             
             if (Errordetectionemethod.isErrorPage(driver)) {
            	 AllureListeners. captureScreenshot(driver, "PaginationError.png");
                 brokenUrls.add(driver.getCurrentUrl() + " - Pagination error");
                 break;  
             }

             
             List<WebElement> keywordLinks = driver.findElements(By.xpath("//*[@id=\"datatable\"]/tbody/tr/td/a"));
             for (WebElement link : keywordLinks) {
                 String openTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
                 link.sendKeys(openTab);
                 Thread.sleep(1500);

                 
                 ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(tabs.get(1));
                 Thread.sleep(2000);

                 if (Errordetectionemethod.isErrorPage(driver)) {
                     brokenUrls.add(driver.getCurrentUrl() + " - Keyword link failed");
                     AllureListeners. captureScreenshot(driver, "KeywordError_" + System.currentTimeMillis() + ".png");
                 }

                 driver.close();  
                 driver.switchTo().window(tabs.get(0));
             }

            
             List<WebElement> nextBtns = driver.findElements(By.xpath("//a[@class='page-link' and @aria-label='Next']"));
             if (nextBtns.isEmpty() || nextBtns.get(0).getAttribute("class").contains("disabled")) {
                 break;
             }

             
             nextBtns.get(0).click();
             Thread.sleep(2000);
         }
     }
	return brokenUrls;

	}

}
