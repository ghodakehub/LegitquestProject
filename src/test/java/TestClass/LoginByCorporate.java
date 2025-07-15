package TestClass;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Pomclass.LoginPageByCoperate;
import UtilityClass.UtilityClass;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("Login Page")
@Feature("Verify LoginByCorporate")
public class LoginByCorporate extends NewBaseTest{
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	@Description(
		    "Verify that a user can successfully log in using a valid Corporate ID:\n" +
		    "- Enter a valid Corporate ID, username, and password.\n" +
		    "- Click the login button.\n" +
		    "- Confirm that the user lands on the dashboard or home page.\n" 
		    
		)
	public void verifyLoginpagebyCorporate() throws InterruptedException, IOException
	
	{
		
		LoginPageByCoperate login=new LoginPageByCoperate (driver);
				login.VerifyLoginpage(driver);
	
	}
	@AfterMethod
	public void finish(ITestResult result) throws IOException, MessagingException
	{
	if(ITestResult.FAILURE==result.getStatus())
	{
		String screenshot=  UtilityClass.Capaturescreenshot(driver,result.getName() );
		
		String testUrl = driver.getCurrentUrl();  
		 ForMultiplemailReceipent.sendEmail(
           	   driver, new String[]{"ghodake6896@gmail.com"},
           	    "Login By CorporateId ",
           	    "Please check issue coming in LoginPage by corporateID , please find the attached screenshot for details." ,
           	 screenshot , testUrl
           	   
           	);
	
	}
	
}
	
}
