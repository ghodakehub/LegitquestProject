package Pomclass;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.SwitchWindow;

public class LatestLegalPageBrokenLink2 extends BasePage1 {

	public LatestLegalPageBrokenLink2(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "(//button[@type='button'])[4]") // LoginButton
	private WebElement loginbtn;

	@FindBy(xpath = "/html/body/div[3]/main/a[3]/button")
	private WebElement clickbtn;

	
	public WebElement getloginbtn() {
		return loginbtn;
	}

	public WebElement getclickbtn() {
		return clickbtn;
	}

	        public List<String> checkAllArticleImages() throws InterruptedException {
	        	clickbtn.click();
	  		  Thread.sleep(2000);
	        
	  		List<String> brokenPageUrls = new ArrayList<>();

	  	
	  		driver.get("https://www.legitquest.com/latest-legal-news-roundup");
	  	String baseTab = driver.getWindowHandle();

	  	
	  	List<WebElement> articleLinks = driver.findElements(By.xpath("//a[contains(@class,'card-title')]"));

	  	for (WebElement article : articleLinks) {
	  	    String url = article.getAttribute("href");

	  	    // Open article in new tab
	  	    ((JavascriptExecutor) driver).executeScript("window.open(arguments[0]);", url);
	  	    Thread.sleep(2000);

	  	    // Switch to new tab
	  	    Set<String> allTabs = driver.getWindowHandles();
	  	    allTabs.remove(baseTab);
	  	    String newTab = allTabs.stream().filter(tab -> !tab.equals(baseTab)).reduce((first, second) -> second).orElseThrow();
	  	    driver.switchTo().window(newTab);
	  	    Thread.sleep(2000);

	  	    // Check for broken images
	  	    boolean pageHasBrokenImage = false;
	  	    List<WebElement> imgs = driver.findElements(By.tagName("img"));
	  	    for (WebElement img : imgs) {
	  	        String src = img.getAttribute("src");
	  	        boolean isBroken = !(Boolean) ((JavascriptExecutor) driver)
	  	                .executeScript("return arguments[0].complete && arguments[0].naturalWidth > 0;", img);

	  	        if (src == null || src.isEmpty() || isBroken) {
	  	            pageHasBrokenImage = true;
	  	            break; // No need to check further, we log the page once
	  	        }
	  	    }

	  	    if (pageHasBrokenImage) {
	  	        System.out.println("❌ Broken images found on page: " + url);
	  	        brokenPageUrls.add(url);
	  	    }

	  	    // Close the current tab and switch back to base
	  	    driver.close();
	  	    driver.switchTo().window(baseTab);
	  	    Thread.sleep(1000);
	  	}
	  	

	    return brokenPageUrls;
	}
}

