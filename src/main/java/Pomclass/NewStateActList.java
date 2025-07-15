package Pomclass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.CommonVerification;
import generic.PaginationsUtility;

public class NewStateActList extends BasePage1 {
	
		public NewStateActList(WebDriver driver) {
			super(driver);
			
		}
		@FindBy(xpath = "(//button[@class='btn btn-warning latest-case-link btn-sm d-flex align-items-center'])[2]")
		private WebElement ClickActlistbtn;
		
    WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    public List<String> checkAllActsInStateList() throws InterruptedException {
    	ClickActlistbtn.click();
    	Thread.sleep(2000);
        List<String> brokenUrls = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.legitquest.com/actlist");
        String mainWindow = driver.getWindowHandle();
        boolean hasNext = true;

        while (hasNext) {
            List<WebElement> actLinks = driver.findElements(By.cssSelector("a.act-link"));

            for (int i = 0; i < actLinks.size(); i++) {
                actLinks = driver.findElements(By.cssSelector("a.act-link")); // Refresh list
                WebElement actLink = actLinks.get(i);

                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", actLink);
                Thread.sleep(1500);
                actLink.click();

                wait.until(driver -> driver.getWindowHandles().size() > 1);

                Set<String> allWindows = driver.getWindowHandles();
                for (String win : allWindows) {
                    if (!win.equals(mainWindow)) {
                        driver.switchTo().window(win);
                        break;
                    }
                }

                Thread.sleep(2000);

                boolean isErrorPage = CommonVerification.isErrorPage(driver);
                boolean isContentMissing = false;
                String currentUrl = driver.getCurrentUrl(); // Capture URL of opened act page

                try {
                    WebElement actTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@class='text-md-center']/h1")
                    ));

                    String pageHeading = actTitle.getText().trim();
                    System.out.println("Page heading found: " + pageHeading);

                    if (pageHeading.isEmpty() || pageHeading.contains("Page Not Found") || pageHeading.contains("Error")) {
                        System.out.println("Error detected based on heading content!");
                        isContentMissing = true;
                    } else {
                        System.out.println(" Act page opened successfully.");
                    }

                } catch (TimeoutException e) {
                    System.out.println(" Heading not found - Possible Error page.");
                    isContentMissing = true;
                }

                if (isErrorPage || isContentMissing) {
                    brokenUrls.add(currentUrl);  
                }

                driver.close();
                driver.switchTo().window(mainWindow);
                Thread.sleep(1500);
            }

            hasNext = PaginationsUtility.clickNextPagination(driver);
        }

        return brokenUrls;
    }
}



