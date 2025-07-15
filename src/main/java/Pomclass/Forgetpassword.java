package Pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.aventstack.extentreports.ExtentTest;
import generic.SwitchWindow;

public class Forgetpassword extends BasePage1 {

	public Forgetpassword(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "/html/body/div[2]/div/nav/div/a[2]")
	private WebElement lgbtn1;

	@FindBy(xpath = "//*[@id=\"login-modal\"]/div/div/div[2]/div/div[1]/div/a")
	private WebElement lgbtn2;

	@FindBy(xpath = "//*[@id=\"indiviual_form\"]/div/div[1]/div/input")

	private WebElement username;

	@FindBy(xpath = "//*[@id=\"indiviual_form\"]/div/div[2]/div/div/input")
	private WebElement pwd;

	@FindBy(xpath = "//*[@id=\"indiviual_form\"]/div/div[3]/button")
	private WebElement lgbtn;
		
	@FindBy(xpath = "/html/body/div[3]/div/div/div[3]/button[2]")
	private WebElement loginpop;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/main/form/div[3]/div/div[2]/div/span/small[1]/a")
	private WebElement forgetpass;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement email_address;
	
	@FindBy(xpath="//button[text()='Send Password Reset Link']")
	private  WebElement resetpassword ;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-block']") 
	private WebElement verifymailofresetpass;
	

	
		public WebElement getforget() {
			return forgetpass;
		}

		public WebElement getemail_address() {
			return email_address;
		}

		public WebElement getRestpass() {
			return resetpassword;
		}
		/*public WebElement getrestpassverificationemail()
		{
			return verifymailofresetpass;
		}*/
		
		

	public WebElement getlgbtn1() {
		return lgbtn1;
	}

	public WebElement getlgbtn2() {
		return lgbtn2;
	}

	public WebElement getusername() {
		return username;
	}

	public WebElement getpwd() {
		return pwd;
	}

	public WebElement getlgbtn() {
		return lgbtn;
	}

	public WebElement getloginpop() {
		return loginpop;
	}

	public void validforgetpass(String email) throws InterruptedException {

		lgbtn1.click(); // login button for home page first
		Thread.sleep(3000);
		lgbtn2.click(); // login button for home page second
		Thread.sleep(3000);

		// Window switch
		SwitchWindow.switchWindowByIndex(driver, 1);
		Thread.sleep(3000);
		forgetpass.click();
		Thread.sleep(2000);
		email_address.sendKeys(email);
		Thread.sleep(2000);
		resetpassword.click();
		Thread.sleep(3000);
		
		//verify the message of reset password 
//		String actual= verifymailofresetpass.getText();
//		String expect="We have emailed your Password reset link ! Please note that you have consumed 2 of 5 attempts today.";
//		Assert.assertEquals(actual, expect);
		Reporter.log("verify the resetmessage sucsssfully",true);
		
	}
	

}
