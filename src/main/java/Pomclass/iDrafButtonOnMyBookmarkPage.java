package Pomclass;

import java.io.IOException;
import java.time.Duration;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import UtilityClass.UtilityClass;
import generic.ForMultiplemailReceipent;

public class iDrafButtonOnMyBookmarkPage extends BasePage1 {

	public iDrafButtonOnMyBookmarkPage(WebDriver driver) {
		super(driver);
	}

	public void verifyidrafbutton() throws InterruptedException, MessagingException, IOException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		 WebElement profileDropdown = driver.findElement(By.xpath("//*[@id=\"navbarsExampleDefault\"]/ul/li/a"));
	        profileDropdown.click();

		WebElement myBookmarks = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='My Bookmarks']")));
		myBookmarks.click();

		// Click on Idraf Bookmark button
		WebElement idrafBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/section/div/div/div/div/div/section/div/div/div[1]/div[2]/a/button")));
		idrafBtn.click();

		// Wait and check for server error
		Thread.sleep(3000);
		String pageSource = driver.getPageSource().toLowerCase();
        if (pageSource.contains("http 500") || pageSource.contains("this page isn’t working") || pageSource.contains("server error")) {

			
			String screenshot=  UtilityClass.Capaturescreenshot(driver,"error on heradrs");
    		String testUrl = driver.getCurrentUrl();  
    		 ForMultiplemailReceipent.sendEmail(
               	   driver, new String[]{"ghodake6896@gmail.com"},
               	    "LR - iDrafBookMarks ",
               	    "Please check iDrafBookMark button issue coming While click on it , please find the attached screenshot for details." ,
               	 screenshot , testUrl
               	   
		    );
		}
	}
}
