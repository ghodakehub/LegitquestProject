package TestClass;

import java.io.IOException;
import javax.mail.MessagingException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pomclass.Login;
import Pomclass.ShareMynote;
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
public class NoteShare extends NewBaseTest{
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	@Description("Verify sharedNotebook options under the 'My Note'Ensure that can user share notebook")
		    
	public void verifynewnote() throws InterruptedException, IOException
	
	{
		Login log= new Login(driver);
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
		   ShareMynote  note=new ShareMynote (driver);
	         note.noteshare(driver);	

	
	}
	@AfterMethod
	public void finish(ITestResult result) throws IOException, MessagingException
	{
		if (result.getStatus() == ITestResult.FAILURE && result.getThrowable() != null)
	{
		String screenshot=  UtilityClass.Capaturescreenshot(driver,result.getName() );
	
		String testUrl =driver.getCurrentUrl();  
		 ForMultiplemailReceipent.sendEmail(
           	   driver, new String[]{"ghodake6896@gmail.com"},
           	    "My Notes",
           	    "Please check issue coming in My Notes While sharing Note, please find the attached screenshot for details." ,
           	 screenshot , testUrl
           	   
           	);
	
	}
	
}

}
