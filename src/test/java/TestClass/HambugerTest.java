package TestClass;

import java.io.IOException;
import javax.mail.MessagingException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pomclass.BurgerMenu;
import Pomclass.Login;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("HamburgerMenu")
@Feature("Verify HamburgerMenu options")
public class HambugerTest extends NewBaseTest{
	

	

	@Test
	@Description("Verify that the HamBurgerMenu options is display and working properly")
	public void HamBugerMenu() throws InterruptedException, IOException
	
	{

		Login log= new Login(driver);
		
		 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
        BurgerMenu ham = new BurgerMenu (driver);
		ham.clickhambuger(driver);
		
	}
	@AfterMethod
	public void finish(ITestResult result) throws IOException, MessagingException
	{
	if(ITestResult.FAILURE==result.getStatus())
	{
		String screenshot=  UtilityClass.Capaturescreenshot(driver,result.getName() );
		String testUrl = driver.getCurrentUrl();  
		 ForMultiplemailReceipent.sendEmail(
           	   driver, new String[]{"ghodake6896@gmail.com"},
           	    "Hambuger Menu ",
           	    "Please check Hambuger Menu issue coming  , please find the attached screenshot for details." ,
           	 screenshot , testUrl
           	   
           	);
	
	}

	}

}
