package TestClass;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pomclass.Login;
import Pomclass.NotebookActions;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("Profile - My Note")
@Feature("Verify Nootebook Option")
public class NotebookActionsfeature extends NewBaseTest{
	
	

	@Test
	@Description(
		    "Verify all nootbook level actions under the 'My Note':\n" +
		    "- Rename: Edit the note title and confirm it gets updated.\n" +
		    "- Delete: Remove the note and ensure it is moved to Trash.\n" +
		    "- Share: Check that the note can be shared and sharing options appear.\n" +
		    "- add Note: add note in notebook and verify it's listed there."
		)
	public void verifynewnote() throws InterruptedException, IOException
	
	{
		Login log= new Login(driver);
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
	   NotebookActions actnote=new NotebookActions (driver);
	  actnote.verifynotebookfunction(driver);	

	
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
           	    "My Note",
           	    "Please check issue coming in NooteBook Actions Like Add , Share, delete and Rename NooteBook, please find the attached screenshot for details." ,
           	 screenshot , testUrl
           	   
           	);
	
	}
	
}


}
