package TestClass;

import java.io.IOException;
import javax.mail.MessagingException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pomclass.Login;
import Pomclass.NewByCourtFilter;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;

public class VerifydateOfLatestLegalNews extends NewBaseTest {
	

	
	@Test
	public void verifySearchBarfunction() throws InterruptedException, IOException
	
	{
		Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
		 NewByCourtFilter fileter= new NewByCourtFilter(driver);
		 fileter.checkCourtFilter();
		
	}

}

