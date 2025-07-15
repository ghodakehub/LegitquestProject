package TestClass;

import java.io.IOException;
import java.util.List;
import javax.mail.MessagingException;
import org.testng.annotations.Test;
import Pomclass.LatestCasesOF_TribunalCourt;
import Pomclass.Login;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.EmailUtility;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("Latest cases")
@Feature("Verify the latest cases of Tribunal court")
public class LatestcasesofTribunalcourt extends NewBaseTest{
	
	
	@Test
	@Description(
		    "Validate the Tribunal Court ON latest cases page:\n" +
		    "- Apply the date filter for the past 60 days.\n" +
		    "- Iterate through each listed case.\n" +
		    "- Open each case in a new tab and check if it lands on a valid judgment page.\n" +
		    "- Detect and report 404 or error pages if found, capturing screenshots for failed cases."
		)
	public void verifyLatestCasesofTribunal() throws InterruptedException, IOException, MessagingException
	
	{
		Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
		 LatestCasesOF_TribunalCourt courts= new LatestCasesOF_TribunalCourt(driver);
		 
		 List<String> brokenLinks = courts.CheckAllcaesLinksofTribynalcourtCases(driver);

		    if (!brokenLinks.isEmpty()) {
		    	 String screenshot=  UtilityClass.Capaturescreenshot(driver ,"Tribunalcourt error" );
		    	
	         		String testUrl = driver.getCurrentUrl();  
	         		 ForMultiplemailReceipent.sendEmail(
	                    	   driver, new String[]{"ghodake6896@gmail.com"},
	                    	    "Latest cases- Tribunal courtcases",
	                    	    "Please check Issue of broken pages detected while checkig Tribunal court cases  , please find the attached screenshot for details." ,
	                    	 screenshot , testUrl
	                    	   
	                    	);
		
		         } else {
		             System.out.println("All cases open successfully");
		         }
	
	
	}
	
}


