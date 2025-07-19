package Pomclass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.AllureListeners;
import generic.Errordetectionemethod;

public class LatestLegalNewsfooteroptions extends BasePage1 {

	public LatestLegalNewsfooteroptions(WebDriver driver) {
		super(driver);
	}

	
		public List<String> validateFooterLinks() throws Exception {
		    driver.get("https://www.legitquest.com/latest-legal-news-roundup");
		    Thread.sleep(2000);

		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		    Thread.sleep(1000);

		    List<WebElement> footerElements = driver.findElements(By.cssSelector("footer a"));
		    List<String> footerHrefs = new ArrayList<>();
		    for (WebElement el : footerElements) {
		        String href = el.getAttribute("href");
		        if (href != null && !href.isEmpty()) {
		            footerHrefs.add(href);
		        }
		    }

		    List<String> brokenUrls = new ArrayList<>();
		    String mainTab = driver.getWindowHandle();

		    for (String href : footerHrefs) {
		        System.out.println("Checking: " + href);
		        js.executeScript("window.open(arguments[0], '_blank');", href);
		        Thread.sleep(2000);

		        Set<String> allTabs = driver.getWindowHandles();
		        allTabs.remove(mainTab);
		        String newTab = allTabs.stream().findFirst().get();
		        driver.switchTo().window(newTab);

		        try {
		            new WebDriverWait(driver, Duration.ofSeconds(10))
		                .until(webDriver -> js.executeScript("return document.readyState").equals("complete"));

		            if (Errordetectionemethod.isHttpStatusError(href)) {
		                System.out.println(" Broken footer link: " + href);
		                brokenUrls.add(href);
		                AllureListeners.captureScreenshot(driver, "error_" + System.currentTimeMillis() + ".png");
		            } else {
		                System.out.println(" Valid footer link: " + href);
		            }

		        } catch (Exception e) {
		            System.out.println(" Exception on link: " + href + " → " + e.getMessage());
		            brokenUrls.add(href);
		            AllureListeners.captureScreenshot(driver, "timeout_" + System.currentTimeMillis() + ".png");
		        }

		        driver.close();
		        driver.switchTo().window(mainTab);
		    }

		    return brokenUrls;
		}
}

