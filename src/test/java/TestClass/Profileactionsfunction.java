package TestClass;

import java.io.IOException;

import javax.mail.MessagingException;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pomclass.Login;
import Pomclass.ProfileActionsfunctionality;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.EmailUtility;
import generic.ForMultiplemailReceipent;
import generic.Library;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("Profile")
@Feature("Verify profile page")
public class Profileactionsfunction extends NewBaseTest{

	@Test

	@Description(
		    "Verify the Profile page loads correctly and displays and  Search history and verify options like rename , share button ,delete, date")
		    		 
		    		    
	public void profileactionsfeatures() throws InterruptedException, IOException, MessagingException
	
	{
		Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
		   ProfileActionsfunctionality profact =new ProfileActionsfunctionality(driver);
		profact.verifyProfileActions(driver);
		 if (!Library.errorUrls.isEmpty()) {
			 String screenshot=  UtilityClass.Capaturescreenshot(driver ,"profile error" );
          	
      		String testUrl = driver.getCurrentUrl();  
      		 ForMultiplemailReceipent.sendEmail(
                 	   driver, new String[]{"ghodake6896@gmail.com"},
                 	    "LR-Profile",
                 	    "Please check Issue coming on profile page , please find the attached screenshot for details." ,
                 	 screenshot , testUrl
                 	   
                 	);
         } else {
             System.out.println("Profilepage open successfully");
         }
		
	
	}

}

