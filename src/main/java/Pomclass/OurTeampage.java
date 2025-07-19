package Pomclass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import generic.AllureListeners;
import generic.CommonVerification;

public class OurTeampage extends BasePage1 {

	public OurTeampage(WebDriver driver) {
		super(driver);
	}

	
	 public void verifyOurTeamSection() {
		 try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		        // Scroll and click "Our Team"
		        WebElement footerLink = driver.findElement(By.linkText("Our Team"));
		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footerLink);
		        wait.until(ExpectedConditions.elementToBeClickable(footerLink)).click();
		        System.out.println("Clicked 'Our Team' link.");

		        // Wait for page to load
		        wait.until(ExpectedConditions.titleContains("Team"));
		        // Verify Management Team title
	            WebElement managementHeading = driver.findElement(By.xpath("//h3[contains(text(),'Management Team')]"));
	            Assert.assertTrue(managementHeading.isDisplayed(), "Management Team heading not visible");

		 
		        clickTabAndVerify("National Advisory");

		        
		        clickTabAndVerify("Founding Advisor");

		        System.out.println("All footer tabs verified successfully.");

		    } catch (Exception e) {
		        System.out.println("Error in verifyOurTeamSection: " + e.getMessage());
		        AllureListeners.captureScreenshot(driver, "Our_Team_Section_Failed");
		        Assert.fail("Footer section verification failed.");
		    }
		}
	 public void clickTabAndVerify(String tabText) {
		    try {
		    	CommonVerification verify= new CommonVerification();
		    	WebElement tabElement = driver.findElement(By.xpath("//button[contains(text(),'" + tabText + "')]"));
		    	verify.safeClick(tabElement, driver) ;
		        Thread.sleep(2000); // Use dynamic waits if you know the image container
                   
                   verify.  verifyImagesInSection(tabText,driver);
                   verify. verifyTextNotPresent("Stack trace", tabText,driver);
                   verify. verifyTextNotPresent("404", tabText,driver);

		    } catch (Exception e) {
		        System.out.println("Error in tab: " + tabText + " -> " + e.getMessage());
		        AllureListeners.captureScreenshot(driver, tabText + "_Failed");
		        Assert.fail("Tab verification failed: " + tabText);
		    }
		}

	}

