package TestClass;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pomclass.JudgmentPrintPdf;
import Pomclass.Login;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("Jugement")
@Feature("Verify on the Third page- PrintPDF button")
public class JudgmentPrintPdfFeature extends NewBaseTest{

	

	@Test
	@Description(
		    "Validate the 'Print Judgment' functionality ensure that download the pdf successfully with selecting one cloumn and two cloumn options"
		    
		)
	public void verifyJudgmentshare() throws InterruptedException, IOException
	
	{
		
		Login log= new Login(driver);
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
        JudgmentPrintPdf note=new JudgmentPrintPdf(driver);
	       note.verifyjudgmentbyprint(driver);	
	
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
           	    "Judgement Print PDF ",
           	    "Please check issue coming in Jugement while print PDF, please find the attached screenshot for details." ,
           	 screenshot , testUrl
           	   
           	);
	
	}
	
}
}
