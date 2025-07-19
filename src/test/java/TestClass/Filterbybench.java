package TestClass;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pomclass.Filterwithbyyear;
import Pomclass.Login;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("SearchFilter")
@Feature("Verify SearchFilter By bench")
public class Filterbybench extends NewBaseTest {

	
	
   @Test
	@Description("Verify the functionality of filter options on the search results page using By Bench,By Year, and By Decision and verifies the results")
	public void verifyfilter() throws InterruptedException, IOException
	
	{
		Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
		Filterwithbyyear filt =new Filterwithbyyear (driver);
	filt.searchfilterbybench(driver);	
	
	}
	@AfterMethod
	public void finish(ITestResult result) throws IOException, MessagingException
	{
		 if (ITestResult.FAILURE == result.getStatus()) {
		        Throwable cause = result.getThrowable();
		        if (cause != null && cause.getMessage() != null &&
		            cause.getMessage().contains("verification failed due to error content")) {

		String screenshot=  UtilityClass.Capaturescreenshot(driver,result.getName() );
		
		String testUrl = driver.getCurrentUrl();  
		 ForMultiplemailReceipent.sendEmail(
           	   driver, new String[]{"ghodake6896@gmail.com"},
           	    "Filter search by bench ",
           	    "Please check filter serach by bench not working , please find the attached screenshot for details." ,
           	 screenshot , testUrl
           	   
           	);
	
	}
	Reporter.log("take screenshot succesfully");
	
	
	}
}
}

