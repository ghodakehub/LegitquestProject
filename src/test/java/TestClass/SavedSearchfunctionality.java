package TestClass;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pomclass.Login;
import Pomclass.Savedsearchprofile;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;

public class SavedSearchfunctionality extends NewBaseTest {
	

	
	@Test
	@Description(
		    "Verify the Profile page loads correctly and displays and savesearch button working properly")
		    
	public void savedsearchprofile () throws InterruptedException, IOException
	
	{

		Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
		Savedsearchprofile search =new Savedsearchprofile (driver );
		search.verifyprofileactions(driver);
		search.verifytbale(driver);
	
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
           	    "LR-Profile - SavedSearch",
           	    "Please check Profile issue coming in SavedSearch , please find the attached screenshot for details." ,
           	 screenshot , testUrl
           	   
           	);
	
	}
	
}

}
