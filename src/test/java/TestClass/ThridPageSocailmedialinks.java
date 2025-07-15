package TestClass;

import java.io.IOException;
import java.time.Duration;

import javax.mail.MessagingException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Pomclass.Login;
import Pomclass.ThirdPageSocialMedialLinks;
import Pomclass.Third_PageButton;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("ThirdPageButtons")
@Feature("Verify socail media links")
public class ThridPageSocailmedialinks extends NewBaseTest{


	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	@Description("- Check functionality of all social media share icons (WhatsApp, Facebook, Twitter, LinkedIn, Email) present on page and Confirm that clicking each icon opens in a new tab or window")
	public void verifythirdpagesbuttons() throws InterruptedException, IOException
	
	{
		
		Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
		 ThirdPageSocialMedialLinks links =new ThirdPageSocialMedialLinks(driver);
		 links.click();
		 
	
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
           	    "LR-ThirdPagesButtons",
           	    "Please check issue coming in ThirdPageButtons , please find the attached screenshot for details." ,
           	 screenshot , testUrl
           	   
           	);
	
	}
	Reporter.log("take screenshot succesfully");
	
	
}

}
