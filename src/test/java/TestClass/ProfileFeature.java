package TestClass;

import java.io.IOException;
import javax.mail.MessagingException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pomclass.Login;
import Pomclass.Profile;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("Profile")
@Feature("Verify profile page")
public class ProfileFeature extends NewBaseTest{

	

	@Test(retryAnalyzer = RetryAnalyzer.class)
	@Description(
		    "Verify the Profile page loads correctly and displays:\n" +
		    "- User's full name, mobile number, and email ID\n" +
		    "- User type (Individual/Corporate) and subscription amount")
	public void VerifyProfileFeature() throws InterruptedException, IOException
	
	{
		Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
		Profile prof= new Profile (driver);
		prof.verifyprofile(driver);
		prof.verifytbale(driver);
		
	
	}
	@AfterMethod
	public void finish(ITestResult result) throws IOException, MessagingException
	{

		if (result.getStatus() == ITestResult.FAILURE && result.getThrowable() != null)
	
	{
		String screenshot=  UtilityClass.Capaturescreenshot(driver,result.getName() );
	
		String testUrl = driver.getCurrentUrl();  
		 ForMultiplemailReceipent.sendEmail(
           	   driver, new String[]{"ghodake6896@gmail.com"},
           	    "LR- Profile",
           	    "Please check issue coming in Profile, please find the attached screenshot for details." ,
           	 screenshot , testUrl
           	   
           	);
	
	}

}
}
