package TestClass;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pomclass.LatestCasesPage;
import Pomclass.Login;
import Pomclass.VerifyLatestCasespage;
import UtilityClass.UtilityClass;
import generic.AllureListeners;
import generic.ConfingData_provider;
import generic.EmailUtility;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;

public class LatestCasesVerifyPage extends NewBaseTest{
	
	
	@Test
	@Description(
		   "Verifying each tabs provide resutls and filter is working")
	public void VerifyLatesCasePage() throws InterruptedException, IOException, MessagingException
	
	{
		  Login log = new Login(driver);
		    log.login(ConfingData_provider.Email, ConfingData_provider.Password);

		   
		    VerifyLatestCasespage page = new VerifyLatestCasespage(driver);
	        page.clickLatestJudgmentMenu();

	        Thread.sleep(5000); 

	        if (page.isCaseListBlank()) {
	            
	            String screenshot = UtilityClass.Capaturescreenshot(driver , "_NoResults");
                ForMultiplemailReceipent.sendEmail(
                    driver,
                    new String[]{"ghodake6896@gmail.com"},
                    " Latest Cases - Blank Case Listings Detected",
                    "No latest judgments are being displayed. Please check attached url and screenshot",
                    screenshot,
                    driver.getCurrentUrl()
                );
	            
	            Assert.fail("Judgment list is blank on latest page.");
	        } else {
	            System.out.println("Judgment list is visible.");
	        }
	}
	}


