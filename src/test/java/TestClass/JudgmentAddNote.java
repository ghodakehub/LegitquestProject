package TestClass;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pomclass.JudgmentAddNotefunction;
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
@Feature("Verify on the Third page- Add note button")
public class JudgmentAddNote extends NewBaseTest {


	

	@Test
	@Description(
		    "Validate the 'Add Note' functionality on the judgment page:\n" +
		    "- Ensure that clicking the note icon opens the note input popup or section.\n" +
		    "- Verify that user can enter and save a custom note.\n" 
		)
	public void verifyJudgmentAddnote() throws InterruptedException, IOException
	
	{
		Login log= new Login(driver);
	
 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
		
		JudgmentAddNotefunction note =new JudgmentAddNotefunction(driver);
	note.verifyjudgmentbynote(driver);	
	
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
           	    "Judgement Add Note ",
           	    "Please check issue coming while add note in judgement, please find the attached screenshot for details." ,
           	 screenshot , testUrl
           	   
           	);
	
	}
	
}
}
