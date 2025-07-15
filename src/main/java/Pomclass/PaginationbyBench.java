package Pomclass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import UtilityClass.Library;


public class PaginationbyBench extends BasePage1 {

	public PaginationbyBench(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='search']") // Main Search Box
	private WebElement searchbox;

	@FindBy(xpath = "//div[@class='search-btn']") // Main Search Icon (Button)
	private WebElement SearchButton;

	@FindBy(xpath = "//*[@id=\"benchresult\"]/label") // by bench filter
	private WebElement bybench;

	@FindBy(xpath = "//*[@id=\"bybench\"]/li[3]/div/label") // by bench filter two
	private WebElement bybenchtwo;

	@FindBy(xpath = "//*[@id=\"yearfilter\"]/label") // by year filter
	private WebElement byyear;

	@FindBy(xpath = "//*[@id=\"byyear\"]/li[1]/div/label") // by year filter eight 2010-2019
	private WebElement byyearone;

	@FindBy(xpath = "//*[@id=\"decision\"]/label") // by disposition filter
	private WebElement bydisposition;

	@FindBy(xpath = "//*[@id=\"bydisposition\"]/li[2]/div/label") // by disposition filter one
	private WebElement bydispositionallow;

	@FindBy(linkText = "2") // pageno2 
	private WebElement page2;
	
	@FindBy(linkText= "3") // pageno3
	private WebElement page3;
	
	@FindBy(linkText = "4") // pageno4 court
	private WebElement page4;
	
	@FindBy(linkText = "Next") // next btn court
	private WebElement next;

	@FindBy(xpath = "//*[@id=\"paginationbottom\"]/li[9]/a") // page no last button
	private WebElement Last;
	

// Actions 	
	public void click(WebDriver driver) throws InterruptedException {

Library.sendKeys(driver,searchbox , "enter ram text", "ram");
	Thread.sleep(3000);
	Library.click(driver, SearchButton, "click on searchbtn");
	Thread.sleep(4000);

	

	Library.click(driver, bybench, "click on bybench");
	Library.threadSleep(3000);

	
	 
	  Library.click(driver, bybenchtwo, "click on bybenchtwo");
		Library.threadSleep(3000);
	
	  
	  Library.click(driver, byyear, "click on byyear");
		Library.threadSleep(3000);
		
		
		  
		  Library.click(driver, byyearone, "click on byyearone");
			Library.threadSleep(3000);
			
	 
	
	  Library.click(driver,bydisposition , "click on bydisposition");
		Library.threadSleep(3000);
		
		 Library.click(driver,bydispositionallow , "click on bydispositionallow");
			Library.threadSleep(3000);

	
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", page2);
	Thread.sleep(3000);
	page2.click();
	Thread.sleep(4000);
	
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("arguments[0].scrollIntoView(true);", page3);
	Thread.sleep(3000);
	page3.click();
	Thread.sleep(4000);


	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("arguments[0].scrollIntoView(true);", next);
	Thread.sleep(3000);
	next.click(); 

	}
}
