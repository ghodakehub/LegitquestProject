package TestClass;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pomclass.Login;
import Pomclass.judgmentshare;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("Jugement")
@Feature("Verify on the Third page button - Email share icon")
public class JudgementShareFeature extends NewBaseTest {

	
	@Test()
	@Description(
		    "Ensure that the 'Email' share icon on the judgment page functions correctly:\n" +
		    "- This confirms that users can easily share the judgment via email."
		)
	public void verifyJudgmentshare() throws InterruptedException, IOException
	
	{
		 Login log= new Login(driver);
			
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
        judgmentshare share=new judgmentshare (driver);

	    share.judgementshare(driver);	
	
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
           	    "Share Judgement Feature ",
           	    "Please check issue coming while share judgement, please find the attached screenshot for details." ,
           	 screenshot , testUrl
           	   
           	);
	
	}
	Reporter.log("take screenshot succesfully");
	
		
	}

}


