package TestClass;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pomclass.LatestSupremeCourtCases;
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
@Feature("Verify the latest cases of Supreme court")
public class LatestCasesForSupremeCourt extends NewBaseTest{
	
	
	
	@Test()
	@Description("Validate Supreme Court latest cases: Apply filters, open each case, detect 404s, and email broken links.")
	public void verifyLatestSupremeCourtCases() throws Exception {
	    Login log = new Login(driver);
	    log.login(ConfingData_provider.Email, ConfingData_provider.Password);

	    LatestSupremeCourtCases cases = new LatestSupremeCourtCases(driver);
	    List<String> brokenLinks = cases.checkSupremeCourtCases(driver);

	    if (!brokenLinks.isEmpty()) {
	        String screenshot = UtilityClass.Capaturescreenshot(driver, "SupremeCourt_404_Errors");
	        String testUrl = driver.getCurrentUrl();

	        ForMultiplemailReceipent.sendEmail(
	            driver,
	            new String[]{"ghodake6896@gmail.com"},
	            "Broken Supreme Court Case Links Found",
	            "Please check Issue of broken pages detected while checkig supreme court cases" + String.join("\n", brokenLinks) +
	            "\n\nPlease check. Screenshot attached.",
	            screenshot,
	            testUrl
	        );

	        Assert.fail("Broken links found: " + brokenLinks.size());
	    } else {
	        System.out.println("All Supreme Court cases opened successfully.");
	    }
	}
	
	
	
}



