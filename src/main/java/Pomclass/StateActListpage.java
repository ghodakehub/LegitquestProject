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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class StateActListpage extends BasePage1 {

	public StateActListpage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "(//button[@class='btn btn-warning latest-case-link btn-sm d-flex align-items-center'])[2]")
	private WebElement ClickActlistbtn;
	
	
	@FindBy(xpath = "(//button[@class='btn btn-warning latest-case-link btn-sm d-flex align-items-center'])[2]")
	private WebElement stateactlist;
	
	@FindBy(xpath = "//*[@id=\"recordType\"]")
	private WebElement filtertype;
	
	public List<String> validateAllStateActs() throws Exception {
		 ClickActlistbtn.click();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		    driver.get("https://www.legitquest.com/actlist");
		    Thread.sleep(3000);

		    String mainWindow = driver.getWindowHandle();
		    List<String> failedUrls = new ArrayList<>();

		    
		    List<WebElement> pageButtons = driver.findElements(By.xpath("//li[contains(@class,'page-item')]//button"));
		    int totalPages = pageButtons.size();

		    for (int page = 1; page < totalPages; page++) {
		       
		        List<WebElement> refreshedPageButtons = driver.findElements(By.xpath("//li[contains(@class,'page-item')]//button"));
		        WebElement currentPageBtn = refreshedPageButtons.get(page);

		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", currentPageBtn);
		        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", currentPageBtn);
		        Thread.sleep(3000); 
		        
		        List<WebElement> actElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
		            By.xpath("//table[@class='table table-padded border-0']//a[@class='act-link']")));

		        for (int i = 0; i < actElements.size(); i++) {
		            try {
		                actElements = driver.findElements(By.xpath("//table[@class='table table-padded border-0']//a[@class='act-link']"));
		                WebElement el = actElements.get(i);
		                String expectedTitle = el.getText().trim();
		                Set<String> oldWindows = driver.getWindowHandles();

		                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
		                Thread.sleep(3000);

		                Set<String> newWindows = driver.getWindowHandles();
		                newWindows.removeAll(oldWindows);

		                if (newWindows.isEmpty()) {
		                    System.out.println(" No new tab opened for: " + expectedTitle);
		                    failedUrls.add(driver.getCurrentUrl());
		                    continue;
		                }

		                String newTab = newWindows.iterator().next();
		                driver.switchTo().window(newTab);
		                String currentUrl = driver.getCurrentUrl();
		                boolean hasError = false;

		                try {
		                    WebElement h1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h1")));
		                    String actualTitle = h1.getText().trim();

		                    if (!actualTitle.toLowerCase().contains(expectedTitle.toLowerCase())) {
		                        System.out.println("Title mismatch:\nExpected: " + expectedTitle + "\nFound: " + actualTitle);
		                        hasError = true;
		                    }

		                    WebElement contentDiv = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("actDescription")));
		                    String contentText = contentDiv.getText().trim();
		                    if (contentText.isEmpty()) {
		                        System.out.println("Blank content: " + currentUrl);
		                        hasError = true;
		                    }
		                } catch (Exception e) {
		                    System.out.println("Exception on: " + currentUrl + " → " + e.getMessage());
		                    hasError = true;
		                }

		                if (hasError) {
		                    failedUrls.add(currentUrl);
		                }

		                driver.close();
		                driver.switchTo().window(mainWindow);

		            } catch (StaleElementReferenceException e) {
		                System.out.println("Stale element at index " + i + ", skipping.");
		                continue;
		            }
		        }
		    }

		    return failedUrls;
		}
}
