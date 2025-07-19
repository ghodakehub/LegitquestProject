package TestClass;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pomclass.Login;
import Pomclass.searchwithinresult;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;

public class SearchwithResult extends NewBaseTest{

	

	@Test
	public void verifySearchrwithinResult() throws InterruptedException, IOException
	
	{
		Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
		searchwithinresult search= new searchwithinresult (driver);
	search.SearhResult(driver);	
	
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
           	    "LR-SearchFilter Within Case",
           	    "Please check issue coming in SearchFilter with case , please find the attached screenshot for details." ,
           	 screenshot , testUrl
           	   
           	);
	
	}
	
}

}
