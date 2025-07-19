package TestClass;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pomclass.LatestLegalPageBrokenLink2;
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
@Epic("Latest Legal News")
@Feature("Verify Broken link of cases")
public class Latestpagelinksverify extends NewBaseTest{
	

	@Test
	@Description("Verify 'LatestLegal News'cases check broken links")
	public void verifyLatestLegalNewsbrokenlinks() throws InterruptedException, IOException, MessagingException
	
	{
		 Login log = new Login(driver);
	        log.login(ConfingData_provider.Email, ConfingData_provider.Password);
		LatestLegalPageBrokenLink2 link=new LatestLegalPageBrokenLink2 (driver);
		 List<String> brokenLinks = link.checkAllArticleImages();

		    if (!brokenLinks.isEmpty()) {
		    	generic.AllureListeners.captureScreenshot(driver, "tribunalcases error");
		    	 String screenshot=  UtilityClass.Capaturescreenshot(driver ,"supremecourtcases error" );
	             	
	         		String testUrl = driver.getCurrentUrl();  
	         		 ForMultiplemailReceipent.sendEmail(
	                    	   driver, new String[]{"ghodake6896@gmail.com"},
	                    	    "LatestLegal News- BrokenImages",
	                    	    "Please check Issue of broken Images detected while checkig Latestlegal News cases  , please find the attached screenshot for details." ,
	                    	 screenshot , testUrl
	                    	   
	                    	);
		
		         } else {
		             System.out.println("All tabs open successfully");
		         }
	
	
	}

}
