package TestClass;

import java.io.IOException;
import javax.mail.MessagingException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pomclass.AllFooterOptions;
import Pomclass.Login;
import UtilityClass.UtilityClass;
import generic.AllureListeners;
import generic.ConfingData_provider;
import generic.EmailUtility;
import generic.ForMultiplemailReceipent;
import generic.Library;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

@Epic("FooterOptions")
@Feature("Verify FooterOptions")
public class CheckAllfooterOptions extends NewBaseTest {


	
	
	 @Test
	 @Description("Verify all footer options like Our Team,Gallery,Contact Us,Careers,Terms & Conditions,We value your Privacy, Newsletter")
	 		
	    public void Actlistverify() throws InterruptedException, IOException, MessagingException {
		 Allure.step("Login with by Valid credentails");
	        Login log = new Login(driver);
	        log.login(ConfingData_provider.Email, ConfingData_provider.Password);

	        AllFooterOptions footer = new AllFooterOptions(driver);
	        Allure.step("Click on footer options ");
	         footer.verifySelectedFooterLinks();  
	 }
	}



