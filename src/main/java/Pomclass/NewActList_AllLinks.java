package Pomclass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.CommonVerification;
import generic.PaginationsUtility;

public class NewActList_AllLinks extends BasePage1 {

	public NewActList_AllLinks(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "(//button[@class='btn btn-warning latest-case-link btn-sm d-flex align-items-center'])[2]")
	private WebElement ClickActlistbtn;
	
	
	@FindBy(xpath = "//*[@id=\"court-tabs\"]/li[3]/a")
	private WebElement centralactlist;
	
	
	public List<String> checkAllActLinks() throws InterruptedException {
	    ClickActlistbtn.click(); 
	    Thread.sleep(2000);

	    centralactlist.click();

	    new WebDriverWait(driver, Duration.ofSeconds(10)).until(
	        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'')]"))
	    );

	    
	    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 300);");
	    
	    List<String> brokenUrls = new ArrayList<>();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    String mainWindow = driver.getWindowHandle();
	    boolean hasNext = true;

	    while (hasNext) {
	        List<WebElement> newsLinks = driver.findElements(By.cssSelector("a.act-link")); 

	        for (int i = 0; i < newsLinks.size(); i++) {
	            try {
	                newsLinks = driver.findElements(By.cssSelector("a.act-link")); 
	                WebElement newsLink = newsLinks.get(i);

	                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newsLink);
	                Thread.sleep(1000);
	                newsLink.click(); 
	                Thread.sleep(1000);
	                wait.until(driver -> driver.getWindowHandles().size() > 1);
	                Set<String> allWindows = driver.getWindowHandles();

	                for (String win : allWindows) {
	                    if (!win.equals(mainWindow)) {
	                        driver.switchTo().window(win);
	                        break;
	                    }
	                }

	                Thread.sleep(4000);

	                boolean isErrorPage = CommonVerification.isErrorPage(driver);
	                boolean isContentMissing = false;
	                String currentUrl = driver.getCurrentUrl(); 
	                try {
	                    WebElement actTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//div[@id='actHead']/h1")
	                        
	                    ));
	                    Thread.sleep(3000);
	                    String pageHeading = actTitle.getText().trim();
	                    Thread.sleep(1000);
	                    System.out.println("Page heading found: " + pageHeading);

	                    if (pageHeading.isEmpty() || pageHeading.contains("Page Not Found") || pageHeading.contains("Error")) {
	                        System.out.println("Error detected based on heading content!");
	                        isContentMissing = true;
	                    } else {
	                        System.out.println(" Act page opened successfully.");
	                    }

	                } catch (TimeoutException e) {
	                    System.out.println(" Heading not found - Possible Error page."+currentUrl);
	                    isContentMissing = true;
	                }

	                if (isErrorPage || isContentMissing) {
	                    brokenUrls.add(currentUrl);  
	                }

	                driver.close();
	                Thread.sleep(2000);
	                driver.switchTo().window(mainWindow);
	                Thread.sleep(2000);
	            } catch (StaleElementReferenceException e) {
	               
	                continue;
	            } catch (Exception e) {
	                System.out.println("Unexpected error: " + e.getMessage());
	            }
	        }

	
	    }

	    return brokenUrls;
	}
}



