package TestClass;

import java.io.IOException;
import javax.mail.MessagingException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pomclass.JudgementCitedinFuturereference;
import Pomclass.Login;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("Thrid pages button")
@Feature("Verify Socail media links on judgement page")
public class JudgementCitedinfeatures extends NewBaseTest{
	
	

	@Test
	@Description(
		    "Validate all tabs on the Judgment page and check futureRefernce ,CitedIn, AdvocateDetails and HeadNotes after click on that display the content")
		    	   
	public void FuturecitedinheadnotFunctionality() throws InterruptedException, IOException
	
	{
		
		Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
        JudgementCitedinFuturereference feature =new JudgementCitedinFuturereference (driver);
		feature.verifycitedinfuturebench(driver);
		
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
           	    "Judgement FutureRefrence ",
           	    "Please judgement citated In , FutureRefrence , please find the attached screenshot for details." ,
           	 screenshot , testUrl
           	   
           	);
	
	}
	}

}
