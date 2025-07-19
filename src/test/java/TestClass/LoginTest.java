package TestClass;
import java.io.IOException;
import java.time.Duration;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pomclass.Login;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("Login Page")
@Feature("Verify Login by Individual")
public class LoginTest extends NewBaseTest {
	

	@Test()
    @Description("Verify login with valid credentials for Individual user.")
    public void verifyLoginAsIndividual() throws MessagingException, IOException {
		 try {
		        Login loginPage = new Login(driver);
		        loginPage.login(ConfingData_provider.Email, ConfingData_provider.Password);

		       
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		        WebElement profileIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(
		            By.xpath("(//*[@id=\"firstname\"])[2]")
		        ));

		        
		        String currentUrl = driver.getCurrentUrl();
		        Assert.assertTrue(currentUrl.contains("/home") || profileIcon.isDisplayed(),
		            "Login successful but home page not loaded correctly.");

		        System.out.println("Login and home page verification passed");

		    } catch (Exception e) {
		        String screenshot = UtilityClass.Capaturescreenshot(driver, "Login_HomePage_Error");
		        ForMultiplemailReceipent.sendEmail(
		            driver,
		            new String[]{"ghodake6896@gmail.com"},
		            " LegitQuest Login Failed",
		            "Login failed or Home page did not load. Please check attached screenshot.\nURL: " + driver.getCurrentUrl(),
		            screenshot,
		            driver.getCurrentUrl()
		        );
		        Assert.fail(" Test failed due to exception: " + e.getMessage());
		    }
}
}

