package TestClass;

import java.io.IOException;
import javax.mail.MessagingException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Pomclass.Login;
import Pomclass.NewNoteOFMynote;
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
public class NewNotemynote extends NewBaseTest {
	@Test
	@Description(
		    "Verify 'Nootebook' functionality under 'My note':\n" +
		    "- Ensure user can create a nootebook with title and add discriptions" +
		    "- Verify the Nootebook gets saved and appears in the list of All Notes."
)
		   
	public void verifynewnote() throws InterruptedException, IOException
	
	{
		
		 Login log= new Login(driver);
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
	      NewNoteOFMynote note=new NewNoteOFMynote (driver);
	       note.verifyeditnote(driver);	

	
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
           	    "My Note",
           	    "Please check issue coming in to Create NooteBook in My Note, please find the attached screenshot for details." ,
           	 screenshot , testUrl
           	   
           	);
	
	}
	
}
}
