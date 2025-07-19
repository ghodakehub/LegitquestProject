package Pomclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.CommonVerification;

public class GalleryPage extends BasePage1 {
	public GalleryPage(WebDriver driver) {
		super(driver);
	}
	public void verifyGallery()
	{
	try {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        
        WebElement galleryLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Gallery")));
        galleryLink.click();
        wait.until(ExpectedConditions.urlContains("/gallery"));
        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Gallery')]")));
        System.out.println("Gallery page opened successfully.");

        CommonVerification.verifyNoCommonErrors(driver, "Gallery page");
        
        WebElement videosTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Videos Gallery']")));
        videosTab.click();
        System.out.println("Clicked on Videos Gallery tab.");
        CommonVerification.verifyNoCommonErrors(driver, "Videos Gallery Page");
        
    } catch (Exception e) {
        e.printStackTrace();
    } 

}
}
