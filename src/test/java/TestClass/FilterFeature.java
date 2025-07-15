package TestClass;

import java.io.IOException;
import javax.mail.MessagingException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pomclass.Filter;
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
@Feature("Verify SearchFilter By Courts")
public class FilterFeature extends NewBaseTest{

	
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	@Description("Verify the functionality of filter options on the search results page using By courts options Supremecourt ,highcourt ,Tribunal court and verifies the results")
	public void verifyfilterbycourts() throws InterruptedException, IOException
	
	{
		Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
        Filter filt=new Filter (driver);
	filt.searchfilter(driver);	
	
	}
	@AfterMethod
	public void finish(ITestResult result) throws IOException, MessagingException
	{
	if(ITestResult.FAILURE==result.getStatus())
	{
		String screenshot=  UtilityClass.Capaturescreenshot(driver,result.getName() );
		
		String testUrl =driver.getCurrentUrl();  
		 ForMultiplemailReceipent.sendEmail(
           	   driver, new String[]{"ghodake6896@gmail.com"},
           	    "Filter Search By Courts ",
           	    "Please check filter search by courts issue coming to search case, please find the attached screenshot for details." ,
           	 screenshot , testUrl
           	   
           	);
	
	}
	
	}
}
