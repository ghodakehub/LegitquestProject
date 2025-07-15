package TestClass;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Pomclass.LatestNewsTabVerification;
import Pomclass.Login;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("Latest cases")
@Feature("Verify Tabs")
public class LatestLegalTabsverificationstest extends NewBaseTest {
	
	  @Test(retryAnalyzer = RetryAnalyzer.class)
	  @Description("Validate 'Latest Cases' across all court tabs (Supreme Court, High Court, Tribunal Court")
			    
	    public void verifySupremeTab() throws InterruptedException {
		  Login log = new Login(driver);
	        log.login(ConfingData_provider.Email, ConfingData_provider.Password);
	        LatestNewsTabVerification courtPage = new LatestNewsTabVerification(driver);
	        courtPage.clickonactlistbtn();
	        Thread.sleep(2000); // 
	        courtPage.clickSupremeTab();
	        Thread.sleep(3000); 
	        Assert.assertTrue(courtPage.isSupremeHeadingDisplayed());
	        courtPage.clickHighCourtTab();
	        Thread. sleep(4000);
	        Assert.assertTrue(courtPage.isHighCourtHeadingDisplayed());
	        courtPage.clickTribunalTab();
	        Thread. sleep(5000);
	        Assert.assertTrue(courtPage.isTribunalHeadingDisplayed());
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
	           	    "LatestLegalNews :Tab verification",
	           	 "Please check Latest legal news while check latest sc, hc and tc judgement  " + testUrl + "\n\nPlease find the attached screenshot.",
	           	 screenshot , testUrl
	           	   
	           	);
		
		}
		}

	}



