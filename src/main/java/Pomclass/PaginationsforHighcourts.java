package Pomclass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import UtilityClass.Library;


public class PaginationsforHighcourts extends BasePage1 {

	public PaginationsforHighcourts(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='search']") // Main Search Box
	private WebElement searchbox;

	@FindBy(xpath = "//div[@class='search-btn']") // Main Search Icon (Button)
	private WebElement SearchButton;

	@FindBy(xpath = "//*[@id=\"select-dropdown\"]/div/div/ul/li[1]/div/div/label/span") // All
	private WebElement Allmenu;

	@FindBy(xpath = "//*[@id=\"bycourt\"]/li[2]/div[1]/label/span") // high court
	private WebElement highcourt;

	@FindBy(xpath = "//*[@id=\"bycourt\"]/li[2]/div[2]/form/ul/li[2]/div/label/span") // AP high court court
	private WebElement APhighcourt;
	
	@FindBy(linkText = "2") // pageno2 
	private WebElement page2;
	
	@FindBy(linkText= "3") // pageno3
	private WebElement page3;
	
	@FindBy(linkText = "4") // pageno4 court
	private WebElement page4;
	
	@FindBy(linkText = "Next") // next btn court
	private WebElement next;
	
// Actions 	
	public void click(WebDriver driver) throws InterruptedException {

Library.sendKeys(driver,searchbox , "enter ram text", "shyam");
	Thread.sleep(3000);
	Library.click(driver, SearchButton, "click on searchbtn");
	Thread.sleep(4000);


	Library.waitForVisibilityOf(driver, highcourt);
Library.click(driver, highcourt, "click on high court ");
Thread.sleep(4000);
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", page2);
	Thread.sleep(3000);
	page2.click();
	Thread.sleep(4000);

	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("arguments[0].scrollIntoView(true);", page2);
	Thread.sleep(3000);
	page3.click();

	Thread.sleep(4000);
	JavascriptExecutor js2 = (JavascriptExecutor)driver;
	js2.executeScript("arguments[0].scrollIntoView(true);", page2);
	Thread.sleep(3000);
	page4.click();

	Thread.sleep(4000);
	Library.waitForVisibilityOf(driver, APhighcourt);
Library.click(driver, APhighcourt, "click on APhighcourt court ");
Thread.sleep(5000);

	JavascriptExecutor js8 = (JavascriptExecutor) driver;
	js8.executeScript("arguments[0].scrollIntoView(true);", page2);
	Thread.sleep(3000);
	page2.click();

	Thread.sleep(5000);
	JavascriptExecutor js9 = (JavascriptExecutor)driver;
	js9.executeScript("arguments[0].scrollIntoView(true);", page3);
	Thread.sleep(3000);
	page3.click();

	Thread.sleep(4000);
	JavascriptExecutor js10 = (JavascriptExecutor)driver;
	js10.executeScript("arguments[0].scrollIntoView(true);", page4);
	Thread.sleep(3000);
	page4.click(); 

	/*Thread.sleep(4000);
	JavascriptExecutor js12 = (JavascriptExecutor) BaseLib.driver;
	js12.executeScript("arguments[0].scrollIntoView(true);", page2);
	Thread.sleep(3000);
	page2.click();
	Thread.sleep(3000);*/
	}
}
