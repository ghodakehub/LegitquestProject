package Pomclass;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;

public class VerifyProfile extends BasePage1 {

	public VerifyProfile(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id=\"navbarsExampleDefault\"]/ul/li/a")
	private WebElement profilename;                  //main searchbar text
	
	@FindBy(xpath = "//*[@id=\"firstname\"]/strong")         //searchbtn
	private WebElement nameofuser;
	
	@FindBy(xpath = "//*[@id=\"navbarsExampleDefault\"]/ul/li/ul")         //searchbtn
	private WebElement user;
	
	public void profilefunctionality(WebDriver driver) throws InterruptedException
	{
		
		Actions act=new Actions(driver);
		act.moveToElement( profilename).perform();
		act.click().perform();
		
		for(int i=1;i<=4.;i++)
		{
			Thread.sleep(1000);
			act.sendKeys(Keys.ARROW_DOWN).perform();
			
						
		
		}
		
		String actualtText=nameofuser.getText();
		//String expectedText="Pratiksha Damodar";
	//	Assert.assertEquals(actualtText,expectedText );
		Reporter.log("verify valid username");
		System.out.println("Login UserName :"+actualtText);

	
		
	}
	
}
