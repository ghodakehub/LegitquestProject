package Pomclass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClass.Library;


public class Search {

	
	@FindBy(xpath = "//input[@id='search']")
	private WebElement searchbar;                  //main searchbar text
	
	@FindBy(xpath = "//a[@id='btnSearch']")         //searchbtn
	private WebElement searchbtn;
	
	@FindBy(xpath = "//*[@id=\"changesearchbutton\"]")
	private WebElement allbtn;
	
	@FindBy(xpath = "//span[text()='All']")
	private WebElement searchforall;
	
	@FindBy(xpath = "//span[text()='Citation']")
	private WebElement citation;
	
	@FindBy(xpath = "//span[text()='Party Name']")
	private WebElement partyname;
	
	@FindBy(xpath = "//input[@id='searchCitationFormat']")
	private WebElement selectcitationsearchbar;
	
	@FindBy(xpath="//*[@id=\"citationJournal\"]/tr[37]/td[1]")
	private WebElement selectallhabad;
	
	@FindBy(xpath = "//input[@id='publisher']")
	private WebElement searchthroughcitation;
	
	
	@FindBy(xpath = "//span[text()='Judge Name']")
	private WebElement judgename;
	
	@FindBy(xpath = "//input[@id='judgename']")
	private WebElement enterjudgename;
	
	
	@FindBy(xpath = "//input[@id='petitionername']")
	private WebElement enterpartyname;
	
	
	@FindBy(xpath = "//span[text()='Act Name']")
	private WebElement actname;
	
	
	@FindBy(xpath = "//input[@id='actname']")
	private WebElement enteractname;
	
	@FindBy(xpath = "//input[@id='section']")
	private WebElement enteractnamesection;
	
	
	@FindBy(xpath = "//input[@id='searchCitationFormat']") // Citation search box
	private WebElement citationsearchbox;

	@FindBy(xpath = "//input[@id='publisher']") // Citation section search box
	private WebElement citationsectionbox;

	@FindBy(xpath = "//*[@id=\"citationJournal\"]/tr[37]/td[2]") // Citation name
	private WebElement Citationname;

	@FindBy(xpath = "//*[@id=\"totalResult\"]/span") // Citation name result
	private WebElement Citationresult;

	
	public Search (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void verifysearchfilter(WebDriver driver) throws InterruptedException
	{
		
		
		Library.sendKeys(driver,searchbar , "Enter text in search bar ", "Nitish Kumar");
		Library.threadSleep(3000);
	
	
		//Library.waitForVisibilityOf(driver, SearchButton);
		Library.click(driver,searchbtn , "click on searchbtn");
		Library.threadSleep(3000);
		
		JavascriptExecutor js10 = (JavascriptExecutor) driver;
		js10.executeScript("arguments[0].scrollIntoView(true);", allbtn);
		Thread.sleep(3000);
		allbtn.click();
		
		
		
		//Library.click(driver,searchforall , "click on forall");
	//	Library.threadSleep(3000);
		
		
		
		
		//citation search type 
		JavascriptExecutor js9 = (JavascriptExecutor) driver;
		js9.executeScript("arguments[0].scrollIntoView(true);", citation);
		Thread.sleep(3000);
		citation.click();
		
		citationsearchbox.sendKeys("AIR");
		Thread.sleep(4000);
		citationsectionbox.click();
		Thread.sleep(3000);
		citationsearchbox.click();
		Citationname.click();// for suggestion citation select 
		Thread.sleep(3000);
		citationsectionbox.sendKeys("201749");
		Library.threadSleep(1000); 	
		
		Library.click(driver,searchbtn , "click on searchbtn");
		Library.threadSleep(3000);
		
		JavascriptExecutor js11 = (JavascriptExecutor)driver;
		js11.executeScript("arguments[0].scrollIntoView(true);", allbtn);
		Thread.sleep(3000);
		allbtn.click();
		
		JavascriptExecutor js12 = (JavascriptExecutor)driver;
		js12.executeScript("arguments[0].scrollIntoView(true);", judgename);
		Thread.sleep(3000);
		judgename.click();
		
		
	
		

		
		Library.sendKeys(driver, enterjudgename, "Enter text in enterjudgename","RAKESH");
		Library.threadSleep(3000);
		
		Library.click(driver,searchbtn , "click on searchbtn");
		Library.threadSleep(3000);
		
		
		JavascriptExecutor js13 = (JavascriptExecutor)driver;
		js13.executeScript("arguments[0].scrollIntoView(true);", allbtn);
		Thread.sleep(3000);
		allbtn.click();
		
		
		JavascriptExecutor js14 = (JavascriptExecutor)driver;
		js14.executeScript("arguments[0].scrollIntoView(true);", partyname);
		Thread.sleep(3000);
		partyname.click();
		
	
		Library.sendKeys(driver,enterpartyname , "Enter text in enterpartyname","AjayKumar");
		Library.threadSleep(3000);
		
		Library.click(driver,searchbtn , "click on searchbtn");
		Library.threadSleep(3000);
		
		
		JavascriptExecutor js15 = (JavascriptExecutor)driver;
		js15.executeScript("arguments[0].scrollIntoView(true);", allbtn);
		Thread.sleep(3000);
		allbtn.click();
		
		JavascriptExecutor js16 = (JavascriptExecutor)driver;
		js16.executeScript("arguments[0].scrollIntoView(true);", actname);
		Thread.sleep(3000);
		actname.click();
		
		Library.sendKeys(driver, enteractname, "Enter text in enteractname","indian penal code");
		Library.threadSleep(3000);
		
		Library.sendKeys(driver,enteractnamesection , "Enter text in enteractnamesection","420");
		Library.threadSleep(3000);
		
		Library.click(driver,searchbtn , "click on searchbtn");
		Library.threadSleep(3000);
		
		
	}	
}
