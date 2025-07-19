package TestClass;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Pomclass.Login;
import Pomclass.Notebookofmynote;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("Profile - My Note")
@Feature("Verify Notebook Option")
public class Notebookfind extends NewBaseTest{
	
	@Test
	@Description(
		    "Verify all notebook level actions under the 'My Note':\n" +
		    "- add Note: add NewNote in Added notebook and verify it's listed there."
		)
	public void verifynewnote() throws InterruptedException, IOException
	
	{
		Login log= new Login(driver);
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
		   Notebookofmynote note=new Notebookofmynote (driver);
	   note.verifynotebookfunction(driver);
	  
	}
	@AfterMethod
	public void finish(ITestResult result) throws IOException, MessagingException {
	    if (result.getStatus() == ITestResult.FAILURE && result.getThrowable() != null) {
	        // Only send email if the test failed AND there's an actual throwable (i.e., a real error)
	        String screenshot = UtilityClass.Capaturescreenshot(driver, result.getName());
	        String testUrl = driver.getCurrentUrl();

	        ForMultiplemailReceipent.sendEmail(
	            driver,
	            new String[]{"ghodake6896@gmail.com"},
	            "My Notes",
	            "An issue occurred while adding a New Note in the Added Notebook. " +
	            "Please check the attached screenshot and URL for more details.\n\nURL: " + testUrl,
	            screenshot,
	            testUrl
	        );
	    }
	    Reporter.log("Finished test. Screenshot taken if failure occurred.", true);
	}
}

