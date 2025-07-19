package TestClass;

import java.io.IOException;
import javax.mail.MessagingException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pomclass.Login;
import Pomclass.MyNoteNewNote;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("Profile - My Note")
@Feature("Verify New Note Option")
public class Mynewnotefunctionality extends NewBaseTest{


	

	@Test
	@Description(
		    "Verify 'Add Note' functionality under 'New Notes':\n" +
		    "- Ensure user can create a new note with title and add discriptions" +
		    "- Verify the note gets saved and appears in the list of All Notes.\n" +
		    "- Check for successful save confirmation message"
	
		)
	public void verifynewnote() throws InterruptedException, IOException
	
	{
		 Login log= new Login(driver);
			
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
		MyNoteNewNote note=new MyNoteNewNote (driver);
	     note.verifynewnote(driver);	

	
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
           	    "My Note",
           	    "Please check issue coming in My Note to create New Note, please find the attached screenshot for details." ,
           	 screenshot , testUrl
           	   
           	);
	
	}

}

}
