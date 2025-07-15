package TestClass;

import java.io.IOException;
import javax.mail.MessagingException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pomclass.Login;
import Pomclass.iDrafFeatures;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("Jugement Idraf")
@Feature("Verify iDraf Options")
public class iDrafFeaturesTest extends NewBaseTest{
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	  @Description("Verify that the 'Issue',Fact, Reasoning , Arguement of Petitioner ,Arguement of Respondent and Decision section in IDraf is displayed and highlight the content correctly")
	public void Actlistverify() throws InterruptedException, IOException
	
	{
	 Login log= new Login(driver);
		
	 log.login(ConfingData_provider.Email,ConfingData_provider.Password);
	 iDrafFeatures idf= new iDrafFeatures(driver);
	 idf.verifyIdrafFeatures();
	}
	

	
	
	

}
