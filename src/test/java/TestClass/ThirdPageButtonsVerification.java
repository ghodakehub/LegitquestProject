package TestClass;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Pomclass.Login;
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
@Feature("Verify ThirdPageButtons")
public class ThirdPageButtonsVerification extends NewBaseTest{


	
	@Test
	@Description(
		    "Validate all key components of the Judgment page:\n" +
		    	    "- Verify download judgement .\n" +
		    	    "- Ensure shared judgement,checking Nightmode, ReprotProblem"
		    	    
		    	    
		    	)
	public void verifythirdpagesbuttons() throws InterruptedException, IOException
	
	{
		
		Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);

		Third_PageButton btns= new Third_PageButton (driver);
	   btns.thirdpagebuttonsverification(driver);	
	
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

