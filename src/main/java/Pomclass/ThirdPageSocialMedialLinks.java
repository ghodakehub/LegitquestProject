package Pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;
import generic.SwitchWindow;

public class ThirdPageSocialMedialLinks extends BasePage1 {

	public ThirdPageSocialMedialLinks(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//button[@type='button'])[4]") // LoginButton
	private WebElement loginbtn;

	@FindBy(xpath = "//input[@id='search']") // Main Search Box
	private WebElement searchbox;

	@FindBy(xpath = "//*[@id=\"btnSearch\"]/i") // Main Search Icon (Button)
	private WebElement SearchButton;

	@FindBy(xpath = "//*[@id=\"select-dropdown\"]/div/div/ul/li[1]/div/div/label/span") // All
	private WebElement Allmenu;

	@FindBy(xpath = "//*[@id=\"0\"]/div/div/a/u") // first link
	private WebElement firstlink;

	@FindBy(xpath = "//*[@id=\"share\"]/li[5]/button/img") // email
	private WebElement email;

	@FindBy(xpath = "//*[@id=\"sharejudgment_user_email\"]") // email box for judgment share
	private WebElement emailbox;

	@FindBy(xpath = "//*[@id=\"share_judgment_btn\"]") // share button for judgment share
	private WebElement share;

	@FindBy(xpath = "//*[@id=\"share\"]/li[1]/button/img") // what's app share button for judgment share
	private WebElement whatsapp;

	@FindBy(xpath = "//h2[contains(text(), 'Send the following on WhatsApp')]") // what's app page for judgment share
	private WebElement whatsapppage;

	@FindBy(xpath = "//*[@id=\"share\"]/li[2]/button/img") // FB share button for judgment share
	private WebElement fb;

	@FindBy(xpath = "//*[@id=\"login_form\"]/table/tbody/tr[1]/td[1]/label") // FB app page for judgment share
	private WebElement FBApp;

	@FindBy(xpath = "//*[@id=\"share\"]/li[3]/button/img") // twitter share button for judgment share
	private WebElement twitter;

	@FindBy(xpath = "//*[@id=\"layers\"]/div[3]/div/div/div/div/div/div[2]/div[2]/div/div[1]/div[1]/div[1]/div/span")
	private WebElement twitterpage;

	@FindBy(xpath = "//*[@id=\"share\"]/li[4]/button/img") // linkdin share button for judgment share
	private WebElement linkdin;

	@FindBy(xpath = "//*[@id=\"app__container\"]/main/div[3]")
	private WebElement linkdinpage;
	
	@FindBy(xpath = "/html/body/div[1]/main/div[20]/div/div/div[2]/div[1]/p")
	private WebElement Jsharetext;
	

	public WebElement getloginbtn() {
		return loginbtn;
	}

	public WebElement getsearchbox() {
		return searchbox;
	}

	public WebElement getSearchButton() {
		return SearchButton;
	}

	public WebElement getAllmenu() {
		return Allmenu;
	}

	public WebElement getemail() {
		return email;
	}

	public WebElement getemailbox() {
		return emailbox;
	}

	public WebElement getshare() {
		return share;
	}

	public WebElement getwhatsapp() {
		return whatsapp;
	}

	public WebElement getwhatsapppage() {
		return whatsapppage;
	}

	public WebElement getfb() {
		return fb;
	}

	public WebElement getFBApp() {
		return FBApp;
	}

	public WebElement gettwitter() {
		return twitter;
	}

	public WebElement gettwitterpage() {
		return twitterpage;
	}

	public WebElement getlinkdin() {
		return linkdin;
	}

	public WebElement getlinkdinpage() {
		return linkdinpage;
	}
	
	public WebElement getJsharetext() {
		return Jsharetext;
	}

	
	
	
// Actions 	
	public void click() throws InterruptedException {
	
		searchbox.sendKeys("ashiana");
		Thread.sleep(3000);
		SearchButton.click();
		Thread.sleep(3000);

		/*
		 * String parent = BaseLib.driver.getWindowHandle();
		 * Reporter.log("parent window id is" + parent);
		 */

		firstlink.click();
		Thread.sleep(3000);
		SwitchWindow.switchWindowByIndex(driver, 2);
		Thread.sleep(3000);
		whatsapp.click();
		Thread.sleep(3000);
		SwitchWindow.switchWindowByIndex(driver, 3);
		Thread.sleep(3000);
		
		// verifying the judgment has share with what's app or not
		String actualtext1 = whatsapppage.getText();
		String ExpectedText1 = "Send the following on WhatsApp";
		Assert.assertEquals(actualtext1, ExpectedText1);
		Reporter.log("What's App page has open successfully", true);
		Thread.sleep(3000);
		
		// judgment has share with FaceBook or no
		SwitchWindow.switchWindowByIndex(driver, 2);
		Thread.sleep(3000);
		fb.click();
		Thread.sleep(3000);
		SwitchWindow.switchWindowByIndex(driver, 4);
		Thread.sleep(3000);

		// verifying the judgment has share with Facebook app or not
		String actualtext2 = FBApp.getText();
		String ExpectedText2 = "Email or phone";
		Assert.assertEquals(actualtext2, ExpectedText2);
		Reporter.log("Facebook page has open successfully", true);
		Thread.sleep(3000);
		
		// judgment has share with twitter or no
		SwitchWindow.switchWindowByIndex(driver, 2);
		Thread.sleep(3000);
		twitter.click();
		SwitchWindow.switchWindowByIndex(driver, 5);
		Thread.sleep(3000);

		// verifying the judgment has share with twitter app or not
		String actualtext3 = twitterpage.getText();
		String ExpectedText3 = "Want to log in first?";
		Assert.assertEquals(actualtext3, ExpectedText3);
		Reporter.log("Twitter page has open successfully", true);
		Thread.sleep(3000);
		

		// judgment has share with linkdin or no
		SwitchWindow.switchWindowByIndex(driver, 2);
		Thread.sleep(3000);
		linkdin.click();
		SwitchWindow.switchWindowByIndex(driver, 6);
		Thread.sleep(3000);

		// verifying the judgment has share with linkdin or not
		String actualtext4 = linkdinpage.getText();
		String ExpectedText4 = "New to LinkedIn? Join now";
		Assert.assertEquals(actualtext4, ExpectedText4);
		Reporter.log("Linkdin page has open successfully", true);
		Thread.sleep(3000);
	
	}
	}
	

	

