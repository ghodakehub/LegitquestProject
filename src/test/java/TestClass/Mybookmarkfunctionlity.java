package TestClass;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pomclass.Login;
import Pomclass.MyBookmarks;
import UtilityClass.UtilityClass;
import generic.AllureListeners;
import generic.ConfingData_provider;
import generic.EmailUtility;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("Profile - My BookMarks")
@Feature("Verify My BookMarks Option")
public class Mybookmarkfunctionlity extends NewBaseTest{

	
	@Test

	@Description(
		    "Verify functionality of 'My Bookmarks' section:\n" +
		    "- Ensure all bookmarked judgments are listed correctly by party name.\n" +
		    "- Click on each party name to ensure the judgment page opens without error (404/500)"
		   
		)
	public void verifybookmarks() throws InterruptedException, IOException, MessagingException
	
	{
		 Login log= new Login(driver);
			
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
		MyBookmarks marks= new MyBookmarks (driver);

	List<String> brokenLinks = marks.validateBookmarks(driver);	

    if (!brokenLinks.isEmpty()) {
    	generic.AllureListeners.captureScreenshot(driver, "MYBOOKMARK page error");
  
         String screenshot=  UtilityClass.Capaturescreenshot(driver ,"Error of brokenimages png." );
     	
 		
 		String testUrl = driver.getCurrentUrl();  
 		 ForMultiplemailReceipent.sendEmail(
            	   driver, new String[]{"ghodake6896@gmail.com"},
            	    "LR-My Bookmarks",
            	    "Please check issue of broken page detected in my bookmarks while checking judgments , please find the attached screenshot for details." ,
            	 screenshot , testUrl
            	   
            	);
             System.out.println("All tabs open successfully");
         }
	
	}
	
}

