package TestClass;


import java.util.List;

import org.testng.annotations.Test;
import Pomclass.LatestLegalNewsfooteroptions;
import Pomclass.Login;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("FooterOptions")
@Feature("Verify FooterOptions on LatestLegalNews")
public class FooterOptionsOnLatestLegalnewspage extends NewBaseTest{
	
	@Test
	public void verifyFooterOptions() throws Exception
	
	{
		Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
	     
		 LatestLegalNewsfooteroptions options = new LatestLegalNewsfooteroptions(driver);

		    List<String> brokenLinks = options.validateFooterLinks();  

		    if (!brokenLinks.isEmpty()) {
		        StringBuilder emailBody = new StringBuilder();
		        emailBody.append("Broken Footer Links Detected on LatesLegalNewsPage , please check attached urls and screenshot");

		        for (String url : brokenLinks) {
		            emailBody.append(" - Error on this FooterLinks ").append(url).append("\n");
		        }

		        
		        String screenshotPath = UtilityClass.Capaturescreenshot(driver, "error_footer_links");

		    
		        String currentUrl = driver.getCurrentUrl();
		        emailBody.append("Test Page URL: ").append(currentUrl);

		       
		        ForMultiplemailReceipent.sendEmail(
		            driver,
		            new String[]{"ghodake6896@gmail.com"},
		            "LR:FooterOptions On LatestLegalNews Page",
		            emailBody.toString(),
		            screenshotPath,
		           ""
		        );
		    } 
		     else {
		        System.out.println("No broken footer links found.");
		    }
		}
	}
	
