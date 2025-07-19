package Pomclass;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import UtilityClass.UtilityClass;
import generic.ForMultiplemailReceipent;


public class Contact_Footer extends BasePage1 {

	public Contact_Footer(WebDriver driver) {
		super(driver);

	}
	
	public void verifyRequestDemoForm() throws Exception {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	  
	    WebElement requestDemoBtn = driver.findElement(By.xpath("//a[contains(text(),'Request Demo')]"));
	    requestDemoBtn.click();

	    // Fill the form
	    driver.findElement(By.xpath("//*[@id=\"dname\"]")).sendKeys("PratikshaShinde");
	    driver.findElement(By.xpath("//*[@id=\"demail\"]")).sendKeys("pratiksha.damodar@legitquest.com");
	    driver.findElement(By.xpath("//*[@id=\"dphone\"]")).sendKeys("9999999999");

	    Select position = new Select(driver.findElement(By.xpath("//*[@id=\"dposition\"]")));
	    position.selectByVisibleText("Other");

	    driver.findElement(By.xpath("//*[@id=\"dcompany\"]")).sendKeys("TestAutomation University");

	    Select state = new Select(driver.findElement(By.xpath("//*[@id=\"state\"]")));
	    state.selectByVisibleText("Delhi");

	    Select city = new Select(driver.findElement(By.xpath("//*[@id=\"city\"]")));
	    city.selectByVisibleText("New Delhi");

	    
	    WebElement submitBtn = driver.findElement(By.xpath("//button[text()='Submit']"));
	    submitBtn.click();

	    try {
	        
	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	        String alertText = alert.getText();
	        System.out.println("Alert appeared: " + alertText);
	        alert.accept();
	    } catch (TimeoutException e) {
	        // No alert, consider as failure
	        String screenshot = UtilityClass.Capaturescreenshot(driver, "RequestDemoFailure");
	        ForMultiplemailReceipent.sendEmail(
	            driver,
	            new String[]{"ghodake6896@gmail.com"},
	            "LR-Request Demo Form Submission Failed",
	            "The Request Demo form failed to submit properly. Please check the attached screenshot.",
	            screenshot,
	            driver.getCurrentUrl()
	        );
	    }
	}
	}


