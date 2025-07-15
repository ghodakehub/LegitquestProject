package generic;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pomclass.BasePage1;
import UtilityClass.UtilityClass;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
public class CommonVerification { 
 
	
	public void verifyImagesInSection(String sectionName,WebDriver driver) {
	    List<WebElement> images =driver.findElements(By.tagName("img"));
	    int brokenImages = 0;

	    for (WebElement img : images) {
	        try {
	            if (!img.isDisplayed()) continue;
	            
	            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", img);
	            Thread.sleep(300); // give time to load

	            new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 ->
	                ((JavascriptExecutor) driver1).executeScript(
	                    "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined'", img
	                )
	            );

	            String naturalWidth = img.getAttribute("naturalWidth");
	            if (naturalWidth == null || naturalWidth.equals("0")) {
	                System.out.println("Broken image in section: " + sectionName);
	                brokenImages++;
	            }

	        } catch (Exception e) {
	            System.out.println("Exception while checking image: " + e.getMessage());
	            brokenImages++;
	        }
	    }

	    Assert.assertEquals(brokenImages, 0, "Broken images found in " + sectionName);
	}
	public static void verifyTextNotPresent(String text, String sectionName, WebDriver driver) {
	    String visibleText = driver.findElement(By.tagName("body")).getText().toLowerCase();

	    if (visibleText.contains(text.toLowerCase())) {
	        System.out.println("Visible error found in " + sectionName + ": " + text);

	    } else {
	       // System.out.println("No visible error text found in section [" + sectionName + "]");
	    }
	
	}

	public static void verifyNoCommonErrors(WebDriver driver, String sectionName) {
	    String[] errorTexts = {
	        "500 internal server error",
	        "Server Error (500)",
	        "stack trace",
	        "something went wrong",
	        "server error",
               "PAGE NOT FOUND",
	        "400"
	    };

	    for (String error : errorTexts) {
	        verifyTextNotPresent(error, sectionName, driver);
	    }
	}
	
	public static void waitForPageLoad(WebDriver driver) {
	    new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete"));
	}
public static void safeClick(WebElement element, WebDriver driver) {
    try {
        // Scroll the element into center view
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element
        );

        // Optional: wait a bit for scroll to complete or UI to stabilize
        Thread.sleep(500);

        // Wait until it's clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        // Click
        element.click();

    } catch (Exception e) {
        System.out.println("❌ Could not click element: " + e.getMessage());
        // Optional: take screenshot or log in Allure
        throw new RuntimeException("Click failed", e);
    }
}

public static void scrollToFooter(WebDriver driver) {
    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
}



public static boolean isErrorPage(WebDriver driver) {
    String pageSource = driver.getPageSource().toLowerCase();
    return pageSource.contains("404") || 
           pageSource.contains("PAGE NOT FOUND.") || 
           pageSource.contains("Server Error (500)") || 
           pageSource.contains("internal server error")||
    pageSource.contains("500 Server");
}



}