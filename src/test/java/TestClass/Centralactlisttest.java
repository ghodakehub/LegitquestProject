package TestClass;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pomclass.CentralActList;
import Pomclass.Login;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.EmailUtility;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("ActList")
@Feature("Verify CentralActlist")
public class Centralactlisttest extends NewBaseTest {


	
	@Test
	@Description("Verify all Type of central Links and paginations")
	public void Actlistverify() throws InterruptedException, IOException, MessagingException
	
	{
		 Allure.step("Login with by Valid credentails");
		Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);

		 Allure.step("Click on Central actlsit and central actlist tab");
		 CentralActList central= new CentralActList(driver);
		 Allure.step("Click on all links and paginations");
		 
		 List<String> brokenurls = central.checkAllActLinks();

	        if (!brokenurls.isEmpty()) {
	            String screenshot = UtilityClass.Capaturescreenshot(driver, "Error_on_actlist");


	            StringBuilder urlList = new StringBuilder();
	            for (String url : brokenurls) {
	                urlList.append(url).append("\n");
	            }

	            ForMultiplemailReceipent.sendEmail(
	                driver,
	                new String[]{"ghodake6896@gmail.com"},
	                "ActList For Central - Error Found",
	                "Hi,\n\nPlease find below actlistlinks The content is not displaying correctly.please check URLs :\n\n" + urlList.toString() +
	                "\n\nScreenshot is attached for your reference.",
	                screenshot,
	                "https://legitquest.com/actlist#"
	            );
	        } else {
	            System.out.println("No bad URLs found.");
	        }
		           
	}
}

	


