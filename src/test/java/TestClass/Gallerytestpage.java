package TestClass;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Pomclass.GalleryPage;
import Pomclass.Login;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("FooterOption")
@Feature("Verify GalleryPage")
public class Gallerytestpage extends NewBaseTest{
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	@Description("Verify that the Gallery page is accessible from the website footer and loads all expected images/content.")
	public void Actlistverify() throws InterruptedException, IOException
	
	{
	 Login log= new Login(driver);
		
	 log.login(ConfingData_provider.Email,ConfingData_provider.Password);

   GalleryPage page= new GalleryPage(driver);
   page.verifyGallery();
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
           	    "Gallery ",
           	 "Gallery functionality encountered an error.\n\nURL: " + testUrl + "\n\nPlease find the attached screenshot.",
           	 screenshot , testUrl
           	   
           	);
	
	}
	}

}
