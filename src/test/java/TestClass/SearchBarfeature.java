package TestClass;

import java.io.IOException;
import javax.mail.MessagingException;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pomclass.Login;
import Pomclass.Search;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("Search Bar")
@Feature("Verify all search options")
public class SearchBarfeature extends NewBaseTest{
	@Test()
	@Description("Verifies that all search types (free text, citation, judge name, party name, act name) return results.")
	public void verifySearchBarfunction() throws InterruptedException, IOException {
	    Login log = new Login(driver);
	    log.login(ConfingData_provider.Email, ConfingData_provider.Password);

	    Search searchbar = new Search(driver);
	    searchbar.verifysearchfilter(driver);
	}

	@AfterMethod
	public void finish(ITestResult result) throws IOException, MessagingException {
	    if (result.getStatus() == ITestResult.FAILURE && result.getThrowable() != null && driver != null) {
	        String screenshot = UtilityClass.Capaturescreenshot(driver, result.getName());
	        String testUrl = driver.getCurrentUrl();

	        ForMultiplemailReceipent.sendEmail(
	            driver,
	            new String[]{"ghodake6896@gmail.com"},
	            "LR - All Search Filter",
	            "Search failed or returned no results.\n\nURL: " + testUrl,
	            screenshot,
	            testUrl
	        );

	        System.out.println("Failure email sent for test: " + result.getName());
	    }
	}
	
}

