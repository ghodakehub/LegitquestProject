package Pomclass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.SwitchWindow;

public class iDrafFeatures extends BasePage1 {

	public iDrafFeatures(WebDriver driver) {
		super(driver);
	}
	

	public void verifyIdrafFeatures() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        
	        WebElement enterKeyword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
	        enterKeyword.sendKeys("Ram Kumar");
	        enterKeyword.sendKeys(Keys.ENTER);

	       
	        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='0']/div/div/a/u")));
	        firstResult.click();
	        Thread.sleep(4000); 
	        SwitchWindow.switchWindowByIndex(driver, 2);
			Thread.sleep(3000);
	        
	        List<WebElement> tabs = driver.findElements(By.xpath("//a[@class='idraf-link jumper']"));
	        for (int i = 0; i < 5; i++) {
	            List<WebElement> currentTabs = driver.findElements(By.xpath("//a[@class='idraf-link jumper']"));
	            WebElement currentTab = currentTabs.get(i);
	            String tabName = currentTab.getText();
	            System.out.println("Clicking tab: " + tabName);
	            currentTab.click();

	            
	            List<WebElement> highlightedSpans = driver.findElements(
	                    By.xpath("//div[@id='detail_page']//span[starts-with(@id, 'selectedissue-')]"));

	                for (WebElement span : highlightedSpans) {
	                    String text = span.getText().trim();
	                    if (!text.isEmpty()) {
	                        System.out.println("Highlighted Text: " + text);
	                    } else {
	                        System.out.println("Span found, but no visible text.");
	                    }
	                }
	            }
	    } catch (Exception e) {
         e.printStackTrace();
     } 
 }
}

