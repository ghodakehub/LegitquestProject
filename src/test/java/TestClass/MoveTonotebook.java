package TestClass;

import java.io.IOException;
import javax.mail.MessagingException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pomclass.Login;
import Pomclass.MoveNoteTonotebook;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("Profile - My Note")
@Feature("Verify My Note Option")
public class MoveTonotebook extends NewBaseTest{

	@Test

	@Description(
		    "Verify all note-level actions under the 'All Notes' section:\n" +
		    "- Rename: Edit the note title and confirm it gets updated.\n" +
		    "- Delete: Remove the note and ensure it is moved to Trash.\n" +
		    "- Print: Click the print icon and confirm the print preview opens.\n" +
		    "- Share: Check that the note can be shared and sharing options appear.\n" +
		    "- Move Note: Move the note to another notebook and verify it's listed there."
		)
	public void verifyMovetonotebook() throws InterruptedException, IOException
	
	{

		 Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
	MoveNoteTonotebook notebook= new MoveNoteTonotebook (driver);
	notebook.noteshare(driver);	
	notebook.verifytbale(driver);	
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
           	    "My_Note ",
           	    "Please check issue coming in My Note, please find the attached screenshot for details." ,
           	 screenshot , testUrl
           	   
           	);
	
	}
	
}


}
