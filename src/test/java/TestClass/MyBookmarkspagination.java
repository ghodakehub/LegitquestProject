package TestClass;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pomclass.Login;
import Pomclass.PaginationAtmyBookmarks;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("Profile - My BookMarks")
@Feature("Verify My BookMarks Option")
public class MyBookmarkspagination extends NewBaseTest {
	
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void verifyMyBookmarkspaginations() throws InterruptedException, IOException
	
	{
		 Login log= new Login(driver);
			
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
		PaginationAtmyBookmarks marks= new PaginationAtmyBookmarks (driver);
	marks.paginationverification(driver);	

	
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
           	    "My BookMark ",
           	    "Please check issue coming in My BookMark Paginations and search Functionaltiy, please find the attached screenshot for details." ,
           	 screenshot , testUrl
           	   
           	);
	
	}

}
}
