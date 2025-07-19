package TestClass;

import java.io.IOException;
import javax.mail.MessagingException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pomclass.Login;
import Pomclass.SelectLaunguage;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("SelectLanguage")
@Feature("Verify select Language Functionality")
public class selectlanguagefeature extends NewBaseTest {

	@Test
	@Description("This test verify Selects language from the language dropdown and its convert or display the judgement selected language")
	public void verifylanguagefunctionality() throws InterruptedException, IOException
	
	{
		Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
		SelectLaunguage select= new SelectLaunguage (driver);
	select.selectlanguage(driver);	
	
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
           	    "LR-Language",
           	    "Please check issue coming in select Language , please find the attached screenshot for details." ,
           	 screenshot , testUrl
           	   
           	);
	
	}
	
}
}
