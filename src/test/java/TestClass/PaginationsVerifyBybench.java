package TestClass;

import java.io.IOException;
import javax.mail.MessagingException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pomclass.Login;
import Pomclass.PaginationbyBench;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;

public class PaginationsVerifyBybench extends NewBaseTest{

	
	@Test
	public void VerifyPaginations() throws InterruptedException, IOException
	
	{
		Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);

		   PaginationbyBench  pages=new PaginationbyBench (driver);
		pages.click(driver);
		
	
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
           	    "LR ",
           	    "Please check issue coming paginations while check cases By-Bench, please find the attached screenshot for details." ,
           	 screenshot , testUrl
           	   
           	);
	
	}

}

}
