package TestClass;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pomclass.LatestLegalNews;
import Pomclass.Login;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;

public class LatestslegalNews extends NewBaseTest {


	

	@Test
	public void verifyLatestLegalNews() throws InterruptedException, IOException
	
	{
		Login log = new Login(driver);
        log.login(ConfingData_provider.Email, ConfingData_provider.Password);
		LatestLegalNews link =new LatestLegalNews (driver);
		link.latestlegalnewsfeature(driver);
		
	
	}


}
	

	

