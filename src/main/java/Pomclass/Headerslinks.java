package Pomclass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import UtilityClass.UtilityClass;
import generic.AllureListeners;
import generic.CommonVerification;
import generic.ForMultiplemailReceipent;
import generic.SwitchWindow;

public class Headerslinks extends BasePage1 {

	public Headerslinks(WebDriver driver) {
		super(driver);
	}
	
	
	public void verifySelectedHeaderDropdownOptions(WebDriver driver) throws InterruptedException {
	    WebElement clickOnLatestLegalCase = driver.findElement(By.xpath("/html/body/div[3]/main/a[3]/button"));
	    clickOnLatestLegalCase.click();
	    Thread.sleep(3000);
	    SwitchWindow.switchWindowByIndex(driver, 2);
	    Thread.sleep(3000);
	    

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    Actions actions = new Actions(driver);

	   
	    int headerCount = driver.findElements(By.xpath(
	        "//ul[contains(@class,'navbar-nav')]//li[contains(@class,'dropdown')]/a[contains(@class,'nav-link')]"
	    )).size();

	    for (int i = 1; i <= headerCount; i++) {
	       
	        WebElement header = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	            "(//ul[contains(@class,'navbar-nav')]//li[contains(@class,'dropdown')]/a[contains(@class,'nav-link')])[" + i + "]"
	        )));

	        String headerName = header.getText().trim();
	        System.out.println("Checking header: " + headerName);

	        actions.moveToElement(header).click().perform();
	        Thread.sleep(1000); 

	        
	        List<WebElement> dropdownItems = driver.findElements(By.xpath(
	            "(//ul[contains(@class,'navbar-nav')]//li[contains(@class,'dropdown')])[" + i + "]//ul[contains(@class,'dropdown-menu')]//a"
	        ));

	        for (int j = 0; j < dropdownItems.size(); j++) {
	            // Re-fetch fresh dropdown list before each click to avoid staleness
	            dropdownItems = driver.findElements(By.xpath(
	                "(//ul[contains(@class,'navbar-nav')]//li[contains(@class,'dropdown')])[" + i + "]//ul[contains(@class,'dropdown-menu')]//a"
	            ));

	            WebElement option = dropdownItems.get(j);
	            String optionText = option.getText().trim();
	            String optionHref = option.getAttribute("href");

	            System.out.println("Option: " + optionText + " | Link: " + optionHref);

	            try {
	                actions.moveToElement(option).click().perform();
	                Thread.sleep(4000); 

	                boolean errorElementVisible = driver.findElements(By.xpath("//*[contains(text(),'This site can’t be reached') or contains(text(),'PAGE NOT FOUND.')]")).size() > 0;
	                if (errorElementVisible) {
	                  

	                    String screenshot=  UtilityClass.Capaturescreenshot(driver,"error on heradrs");
	            		String testUrl = driver.getCurrentUrl();  
	            		 ForMultiplemailReceipent.sendEmail(
	                       	   driver, new String[]{"ghodake6896@gmail.com"},
	                       	    "HeadersOptions ",
	                       	    "Please check Header options issue coming While click on it , please find the attached screenshot for details." ,
	                       	 screenshot , testUrl
	                       	   
	                       	);
	                   
	                } else {
	                    System.out.println("Clicked. No error. Current URL: " + driver.getCurrentUrl());
	                }
	                driver.navigate().back();
	                Thread.sleep(1000);

	                wait.until(ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//ul[contains(@class,'navbar-nav')]")
	                ));

	                
	                WebElement refreshedHeader = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	                    "(//ul[contains(@class,'navbar-nav')]//li[contains(@class,'dropdown')]/a[contains(@class,'nav-link')])[" + i + "]"
	                )));
	                actions.moveToElement(refreshedHeader).click().perform();
	                Thread.sleep(1000);

	            } catch (Exception e) {
	                System.out.println(" Failed to click option: " + optionText + " | ");
	            }
	        }
	    }
	}
	}

	
	

