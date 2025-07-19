package TestClass;

import java.io.IOException;
import javax.mail.MessagingException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pomclass.Forgetpassword;
import Pomclass.Login;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("ForgetPassword")
@Feature("Verify ForgetPassword")
public class Forgetpass_feature extends NewBaseTest{

	
	
	
	@Test
	@Description("Verify the 'Forgot Password' functionality with a valid registered email and check if the reset link is sent successfully.")
	public void verifyForgetpassLink() throws InterruptedException, IOException
	
	{

		Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
        Forgetpassword pass= new Forgetpassword (driver);
	     pass.validforgetpass("pratiksha.damodar@legitquest.com");
		
		
	
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
           	    "ForgetPassword functionality ",
           	    "Please check ForgetPassword Functionality , please find the attached screenshot for details." ,
           	 screenshot , testUrl
           	   
           	);
	
	}

	}
}
