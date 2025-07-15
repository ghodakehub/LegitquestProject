package TestClass;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pomclass.Login;
import Pomclass.SecondryMaterialFilter;
import UtilityClass.UtilityClass;

import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("Secondary Materails")
@Feature("Verify secondary materials button")
public class secondaryMaterials extends NewBaseTest {

	@Test()
	@Description("This test verify the all secondary materails buttons and apply by year filter within options and check its display results")
	public void verifysecondarymaterials() throws InterruptedException, IOException
	
	{
		Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
		SecondryMaterialFilter filter= new 	SecondryMaterialFilter(driver);
	    filter.click();	
	
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
           	    "LR-SecondartyMaterials",
           	    "Please check issue coming in SecondaryMetarials  , please find the attached screenshot for details." ,
           	 screenshot , testUrl
           	   
           	);
	
	}

}

}
