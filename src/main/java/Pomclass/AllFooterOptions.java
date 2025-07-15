package Pomclass;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import javax.mail.MessagingException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import UtilityClass.UtilityClass;
import generic.AllureListeners;
import generic.CommonVerification;
import generic.ForMultiplemailReceipent;



public class AllFooterOptions extends BasePage1 {

	public AllFooterOptions(WebDriver driver) {
		super(driver);
	}


		
		public void verifySelectedFooterLinks() throws IOException, MessagingException {
		    List<String> footerLinksToCheck = Arrays.asList(
		        "Our Team", "Contact Us", "Gallery","Careers","Terms & Conditions","We value your Privacy","Newsletter",
		        "FAQ", "Blog","Download for Punjab and Haryana Judiciary"
		    );

		    SoftAssert softAssert = new SoftAssert();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		    for (String linkText : footerLinksToCheck) {
		        try {
		            CommonVerification.scrollToFooter(driver); 

		            WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)));
		            String originalWindow = driver.getWindowHandle();
		            Set<String> oldWindows = driver.getWindowHandles();

		            link.click();
		            Thread.sleep(3000); 

		            Set<String> newWindows = driver.getWindowHandles();
		            newWindows.removeAll(oldWindows);

		            if (!newWindows.isEmpty()) {
		                String newTab = newWindows.iterator().next();
		                driver.switchTo().window(newTab);
		            }

		            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
		            String pageSource = driver.getPageSource();

		            if (pageSource.contains("Server Error (500)") || 
		                pageSource.contains("This page isn’t working") ||
		                pageSource.contains("404") || 
		                pageSource.contains("Not Found")) {

		                 AllureListeners.captureScreenshot(driver, linkText);
		                 String screenshot=  UtilityClass.Capaturescreenshot(driver ,"Error ondonwlaod btn" );
		             	
		         		
		         		String testUrl = driver.getCurrentUrl();  
		         		 ForMultiplemailReceipent.sendEmail(
		                    	   driver, new String[]{"ghodake6896@gmail.com"},
		                    	    "FooterOptions",
		                    	    "Please check FooterOptions issue coming  on: " +linkText  +" , please find the attached screenshot for details." ,
		                    	 screenshot , testUrl
		                    	   
		                    	);

		                softAssert.fail("Error found in footer link: " + linkText);
		            }

		            if (!newWindows.isEmpty()) {
		                driver.close();
		                driver.switchTo().window(originalWindow);
		            } else {
		                driver.navigate().back();
		            }

		            Thread.sleep(2000); 

		        } catch (Exception e) {
		         AllureListeners.captureScreenshot(driver, linkText);
		            
		        }
		    }

		    softAssert.assertAll();
		}
}

