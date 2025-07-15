package Pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.Library;
import generic.SwitchWindow;

public class LoginPageByCoperate extends BasePage1 {

	public LoginPageByCoperate(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "/html/body/div[2]/div/nav/div/a[2]")
	private WebElement lgbtn1;

	@FindBy(xpath = "//*[@id=\"login-modal\"]/div/div/div[2]/div/div[1]/div/a/div")
	private WebElement lgbtn2;

	@FindBy(xpath = "//*[@id=\"loginForm\"]/div[2]/div/label[2]")
	private WebElement corporatebtn;

	@FindBy(xpath = "//*[@id=\"coorporate_form\"]/div/div[1]/div/input")
	private WebElement companycode;

	@FindBy(xpath = "//*[@id=\"coorporate_form\"]/div/div[2]/button")

	private WebElement Takemein1;

	@FindBy(xpath = "//*[@id=\"loginCoorporateForm\"]/div[3]/div[1]/input")
	private WebElement email;

	@FindBy(xpath = "//*[@id=\"loginCoorporateForm\"]/div[3]/div[2]/input")
	private WebElement password;
		
	@FindBy(xpath = "//*[@id=\"loginCoorporateForm\"]/div[3]/div[4]/button")
	private WebElement Takemein2;
	

	public void VerifyLoginpage(WebDriver driver) throws InterruptedException
	
	{
		
		lgbtn1.click(); // login button for home page first
		Thread.sleep(3000);
		lgbtn2.click(); // login button for home page second
		Thread.sleep(3000);
		
		SwitchWindow.switchWindowByIndex(driver, 1);
		Thread.sleep(3000);
		
		Library.click(driver, corporatebtn, "click on corporatebtn");
		Library.threadSleep(3000);
		
		Library.sendKeys(driver, companycode, "Enter company code", "TEST");
		Library.threadSleep(3000);
		
		Library.click(driver, Takemein1, "click on Takemein1");
		Library.threadSleep(3000);
		
		Library.sendKeys(driver,email , "Enter Email", "123@gmail.com");
		Library.threadSleep(3000);
		
		Library.sendKeys(driver,password ,"Enter Password", "lq@123");
		Library.threadSleep(3000);
		
		Library.click(driver, Takemein2, "click on Takemein2");
		Library.threadSleep(3000);



		
	}
}
