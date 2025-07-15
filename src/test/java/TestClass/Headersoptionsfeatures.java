package TestClass;

import java.io.IOException;
import javax.mail.MessagingException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pomclass.HeaderOptions;
import Pomclass.Login;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("HeaderOptions")
@Feature("Verify Headers Options")
public class Headersoptionsfeatures extends NewBaseTest{
	
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	@Description("Verify that the 'Company' and 'Product''Latest case','Profile' dropdown options in the header are displayed correctly upon clicking.")
	public void VerifyHeadersOptions() throws InterruptedException, IOException
	
	{
		Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
        HeaderOptions opt=new HeaderOptions (driver);
		opt.verifyheadersoptions();
		opt.verifySelectedHeaderDropdownOptions(driver);
		
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
           	    "HeaderLinks COMPANY, PRODUCT,LATEST CASES and PRICING ",
           	    "Please check Header options issue coming in HeaderOptions , please find the attached screenshot for details." ,
           	 screenshot , testUrl
           	   
           	);
	
	}

	}

}
