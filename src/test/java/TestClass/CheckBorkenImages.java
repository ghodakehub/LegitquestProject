package TestClass;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Pomclass.LatestLegalPageBrokenLink2;
import Pomclass.Login;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("LatestLegalNews")
@Feature("Verify All LatestLegalNews cases")
public class CheckBorkenImages extends NewBaseTest {

	@Test
	@Description("Verify All LatestLegalNews cases")
	public void verifybrokenImages() throws InterruptedException, MessagingException, IOException {
		
	Login log = new Login(driver);
    log.login(ConfingData_provider.Email, ConfingData_provider.Password);
    
    LatestLegalPageBrokenLink2 page = new LatestLegalPageBrokenLink2(driver);
    List<String> brokenImagePages = page.checkAllArticleImages();

    if (!brokenImagePages.isEmpty()) {
        
        String screenshot = UtilityClass.Capaturescreenshot(driver, "BrokenImages");

        StringBuilder body = new StringBuilder("Broken image URLs found:\n\n");
        for (String url : brokenImagePages) {
            body.append("🔗 ").append(url).append("\n");
        }

        String testUrl = driver.getCurrentUrl();

        ForMultiplemailReceipent.sendEmail(
            driver,
            new String[]{"ghodake6896@gmail.com"},
            "LatestLegal News - Broken Images Detected",
            body.toString() + "\n\nScreenshot is attached.",
            screenshot,
            testUrl
        );

        // Optionally fail the test to reflect in reports
        Assert.fail("Broken images detected. Details sent via email.");
    }
}
 
}

   

	


