package TestClass;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pomclass.Login;

import Pomclass.Profilesavedhistory;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;


public class ProfileSavedSearch  extends NewBaseTest{

	
	@Test
	public void VerifyPaginations() throws InterruptedException, IOException, MessagingException
	
	{
		Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);

		 Profilesavedhistory profile = new Profilesavedhistory(driver);
		
		  List<String> brokenUrls =  profile.verifyProfileActions(driver);

		 if (!brokenUrls.isEmpty()) {
		        StringBuilder emailBody = new StringBuilder();
		        emailBody.append("Issue detected on profile's Saved Search history page. Please check the broken URLs and attached screenshot");

		        for (String url : brokenUrls) {
		            emailBody.append("• ").append(url).append("\n");
		        }

		        
		        String screenshotPath = UtilityClass.Capaturescreenshot(driver, "error.png");

		    
		        String currentUrl = driver.getCurrentUrl();
		        emailBody.append("Test Page URL: ").append(currentUrl);

		       
		        ForMultiplemailReceipent.sendEmail(
		            driver,
		            new String[]{"ghodake6896@gmail.com"},
		            "LR : Profile SavedSearch history",
		            emailBody.toString(),
		            screenshotPath,
		         ""
		        );
		        Assert.fail("Search History main page failed:");
		    } 
		     else {
		        System.out.println("No broken footer links found.");
		    }
		}
	}


