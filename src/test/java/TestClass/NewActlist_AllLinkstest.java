package TestClass;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import org.testng.annotations.Test;
import Pomclass.Login;
import Pomclass.NewActList_AllLinks;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("ActList")
@Feature("Verify NewActlist")
public class NewActlist_AllLinkstest extends NewBaseTest {


	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	@Description(
		    "Verify 'NewActlist'functionality under 'ActList':\n" +
		    "- Ensure user can all acts links are open correctly" 
		    		)
	public void Actlistverify() throws InterruptedException, IOException, MessagingException
	
	{
		Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);

		
		 NewActList_AllLinks state= new NewActList_AllLinks(driver);
		 
		 List<String> brokenurls = state.checkAllActLinks();

	        if (!brokenurls.isEmpty()) {
	            String screenshot = UtilityClass.Capaturescreenshot(driver, "Error_on_actlist");


	            StringBuilder urlList = new StringBuilder();
	            for (String url : brokenurls) {
	                urlList.append(url).append("\n");
	            }

	            ForMultiplemailReceipent.sendEmail(
	                driver,
	                new String[]{"ghodake6896@gmail.com"},
	                "ActList For NewActList - Error Found",
	                "Hi,\n\nPlease The content is not displaying correctly, and some actlist appear to be broken please check URLs error detected:\n\n" + urlList.toString() +
	                "\n\nScreenshot is attached for your reference.",
	                screenshot,
	                "https://legitquest.com/actlist#"
	            );
	        } else {
	            System.out.println("No broken URLs found.");
	        }
		           
	
	}
}



