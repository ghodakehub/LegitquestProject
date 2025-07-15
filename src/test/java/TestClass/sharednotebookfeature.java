package TestClass;

import java.io.IOException;

import javax.mail.MessagingException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pomclass.Login;
import Pomclass.SharedNotebook;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("Profile - My Note")
@Feature("Verify Nootebook Option")
public class sharednotebookfeature extends NewBaseTest{
	

	@Test(retryAnalyzer = RetryAnalyzer.class)
	@Description(
		    "Verify 'Nootebook' functionality under 'My note' Ensure user can share a nootebook") 
		    
	public void verifysharedNotebook() throws InterruptedException, IOException
	
	{
		Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
		 Thread.sleep(1000);
		SharedNotebook share= new SharedNotebook (driver);
	share.verifynotebookfunction(driver);
	

	
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
           	    "LR- My_Notes",
           	    "Please check issue coming in My Notes while share nootebook , please find the attached screenshot for details." ,
           	 screenshot , testUrl
           	   
           	);
	
	}
	
}

}
