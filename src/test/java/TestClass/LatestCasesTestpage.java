package TestClass;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pomclass.LatestCasesPage;
import Pomclass.Login;
import UtilityClass.UtilityClass;
import generic.ConfingData_provider;
import generic.ForMultiplemailReceipent;
import generic.NewBaseTest;
import generic.RetryAnalyzer;
import io.qameta.allure.Description;

public class LatestCasesTestpage extends NewBaseTest{
	
	

	@Test
	@Description(
		   "Verifying each tabs provide resutls and filter is working")
	public void VerifyLatesCasePage() throws InterruptedException, IOException, MessagingException
	
	{
		  Login log = new Login(driver);
		    log.login(ConfingData_provider.Email, ConfingData_provider.Password);

		   
		    LatestCasesPage page = new LatestCasesPage(driver);  
		    page.highourtcases(driver); 
		    page.checkLatestCourtJudgments();
		   
		}
	}


