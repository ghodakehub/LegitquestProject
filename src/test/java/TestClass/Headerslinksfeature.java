package TestClass;

import java.io.IOException;
import java.util.List;
import javax.mail.MessagingException;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pomclass.Headerslinks;
import Pomclass.Login;
import generic.ConfingData_provider;
import generic.EmailUtility;
import generic.Library;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("HeaderOptions")
@Feature("Verify Headers Options")
public class Headerslinksfeature extends NewBaseTest{

	
	@Test()
	@Description("Verify that the 'Product' and 'Menu' dropdown options in the header are displayed correctly upon clicking.")
	public void VerifyHeadersLinks() throws InterruptedException, IOException, MessagingException
	
	{
		Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
        Headerslinks opt=new Headerslinks (driver);
        opt.verifySelectedHeaderDropdownOptions(driver);
    
    }
	
}
	


