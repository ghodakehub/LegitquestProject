package TestClass;

import java.io.IOException;
import javax.mail.MessagingException;
import org.testng.annotations.Test;
import Pomclass.Login;
import Pomclass.iDrafButtonOnMyBookmarkPage;
import generic.ConfingData_provider;
import generic.NewBaseTest;
import io.qameta.allure.Description;

public class iDrafbuttonBookmarks  extends NewBaseTest{
	
	
	@Test()
	@Description("")
	public void VerifyHeadersOptions() throws InterruptedException, IOException, MessagingException
	
	{
		Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
		 iDrafButtonOnMyBookmarkPage idraf= new iDrafButtonOnMyBookmarkPage(driver);
		 
		 idraf.verifyidrafbutton();
	}

}
 