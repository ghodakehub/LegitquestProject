package Pomclass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaginationAtmyBookmarks extends BasePage1 {

	public PaginationAtmyBookmarks(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath = "//*[@id=\"navbarsExampleDefault\"]/ul/li/a")
	private WebElement profilename;                  //main searchbar text
	
	@FindBy(linkText = "My Bookmarks")         //searchbtn
	private WebElement mybookmarks;
	
	@FindBy(xpath = "//*[@id=\"bookmarkTable_length\"]/label/select")          
	private WebElement showentries;
	
	@FindBy(xpath = "//*[@id=\"bookmarkTable_paginate\"]/ul/li[3]/a")          
	private  WebElement pageno2;

	@FindBy(xpath = "//*[@id=\"bookmarkTable_paginate\"]/ul/li[4]/a")          
	private  WebElement pageno3;

	@FindBy(xpath = "//*[@id=\"bookmarkTable_paginate\"]/ul/li[1]/a")          
	private  WebElement pageno1;

	@FindBy(xpath = "//*[@id=\"bookmarkTable\"]/tbody/tr[1]/td[2]/a")        
	private  WebElement firstbookmarkcase;

	@FindBy(xpath = "//*[@id=\"bookmarkTable_filter\"]/label/input")          
	private  WebElement searchbar;

	
	
	public void paginationverification(WebDriver driver) throws InterruptedException
	{
		
		Actions act=new Actions(driver);
		act.moveToElement( profilename).perform();
		Thread.sleep(3000);
		mybookmarks.click();
		Thread.sleep(2000);
		Select entries= new Select(showentries);
		entries.selectByIndex(1);
		Thread.sleep(2000);
		entries.selectByIndex(2);
		Thread.sleep(2000);	
		entries.selectByIndex(0);
		Thread.sleep(2000);	
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();",pageno2 );
		Thread.sleep(3000);
		
		JavascriptExecutor js12 = (JavascriptExecutor) driver;
		js12.executeScript("arguments[0].click();",pageno3 );
		Thread.sleep(3000);
		
		
		JavascriptExecutor js13 = (JavascriptExecutor) driver;
		js13.executeScript("arguments[0].click();",pageno1 );
		Thread.sleep(3000);
		
		
		//JavascriptExecutor js14 = (JavascriptExecutor) BaseLib.driver;
		//js14.executeScript("arguments[0].click();",firstbookmarkcase );
	//	Thread.sleep(3000);
		

		JavascriptExecutor js15 = (JavascriptExecutor) driver;
		js15.executeScript("arguments[0].click();",searchbar );
		Thread.sleep(3000);
		
		searchbar.sendKeys("Bachan-singh-");
		Thread.sleep(2000);
		
		
		JavascriptExecutor js14 = (JavascriptExecutor) driver;
		js14.executeScript("arguments[0].click();",firstbookmarkcase );
		Thread.sleep(3000);

		
		
			}

	

}
