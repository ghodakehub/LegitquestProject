package TestClass;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pomclass.Footersocialmedia;
import Pomclass.Login;
import Pomclass.SnapShot;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("FooterOptions")
@Feature("Verify socailMedia Options")
public class socialmediallinksoffooter extends NewBaseTest {
	
	@Test
	@Description(
		    "verifies that social media links (Facebook, Twitter, Instagram and youTube) are displayed correctly.") 
	public void verifysocailmedialinks() throws InterruptedException, IOException
	
	{
		Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
		Footersocialmedia media= new Footersocialmedia (driver);
	media.verifysocialmedialinks(driver);
	
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
           	    "LR-Social Media Links",
           	    "Please check issue coming in Social Media Links , please find the attached screenshot for details." ,
           	 screenshot , testUrl
           	   
           	);
	
	}
	
}
}
