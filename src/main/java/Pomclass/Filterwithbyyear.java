package Pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import UtilityClass.Library;

public class Filterwithbyyear extends BasePage1 {

	public Filterwithbyyear(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath = "//input[@id='search']") // Main Search Box
	private WebElement searchbox;

	@FindBy(xpath = "//div[@class='search-btn']") // Main Search Icon (Button)
	private WebElement SearchButton;

	@FindBy(xpath = "//*[@id=\"select-dropdown\"]/div/div/ul/li[1]/div/div/label/span") // All
	private WebElement Allmenu;

	@FindBy(id = "benchresult") // Main Search Icon (Button)
	private WebElement bench;
	
	@FindBy(xpath = "//*[@id=\"bybench\"]/li[1]") // Main Search Icon (Button)
	private WebElement benchoption;
	
	@FindBy(xpath = "//*[@id=\"btnClearFilter\"]") // Main Search Icon (Button)
	private WebElement clearbutton;
	
	@FindBy(xpath = "//*[@id=\"yearfilter\"]/label") // Main Search Icon (Button)
	private WebElement yearfilter;
	
	@FindBy(xpath = "//*[@id=\"byyear\"]/li[1]/div/label") // Main Search Icon (Button)
	private WebElement yearfilteroption;
	
	
	@FindBy(xpath ="//*[@id=\"decision\"]/label") // Main Search Icon (Button)
	private WebElement decision;
	
	@FindBy(xpath = "//*[@id=\"bydisposition\"]/li/div/label") // Main Search Icon (Button)
	private WebElement decisionoption;
	
	
	public void searchfilterbybench( WebDriver driver) throws InterruptedException {
	
		//Library.waitForVisibilityOf(driver, searchbox);
		Library.sendKeys(driver, searchbox, "Enter text in search bar Shyam", "Shyam");
		Library.threadSleep(3000);
	
	
		//Library.waitForVisibilityOf(driver, SearchButton);
		Library.click(driver,SearchButton , "click on searchbtn");
		Library.threadSleep(3000);
		
		
		//Library.waitForVisibilityOf(driver, bench);
		Library.click(driver,bench , "click on Bybench");
		Library.threadSleep(2000);

	
		Library.waitForVisibilityOf(driver,benchoption );
		Library.click(driver,benchoption , "click on BybenchOption");
		Library.threadSleep(2000);

	
		
		Library.waitForVisibilityOf(driver,yearfilter );
		Library.click(driver,yearfilter , "click on Byyear");
		Library.threadSleep(2000);
		
		Library.waitForVisibilityOf(driver,yearfilteroption );
		Library.click(driver,yearfilteroption , "click on ByyearOption");
		Library.threadSleep(2000);

		

		
		
		Library.click(driver,decision , "click on ByDecision");
		Library.threadSleep(2000);
		
		Library.waitForVisibilityOf(driver, decisionoption);
		Library.click(driver,decisionoption , "click on ByDecisionOption");
		Library.threadSleep(2000);
	
	}	
}
