package TestClass;

import org.testng.annotations.Test;
import Pomclass.Contact_Footer;
import Pomclass.Login;
import generic.ConfingData_provider;
import generic.NewBaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("FooterOption")
@Feature("Verify footeroptions")
public class ContactFooterFeature extends NewBaseTest {
	
	

	
	@Test
	@Description("Verify All Footer Options ")
	public void verifycontactfooter() throws Exception
	
	{
		
		 Allure.step("Login with by Valid credentails");
		Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);

        Contact_Footer footer= new Contact_Footer(driver);
		footer.verifyRequestDemoForm();
	
	}
}
