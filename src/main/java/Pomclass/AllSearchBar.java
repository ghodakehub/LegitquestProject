package Pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.testng.Assert;
import org.testng.Reporter;


import UtilityClass.Library;
import UtilityClass.ResultValidator;
import UtilityClass.Waitutility;

public class AllSearchBar extends BasePage1 {

	public AllSearchBar(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath = "//*[@id=\"search\"]") // Main Search Box
	private WebElement searchbox;

	@FindBy(xpath = "//div[@class='search-btn']") // Main Search Icon (Button)
	private WebElement SearchButton;

	@FindBy(id = "changesearchbutton") // Search type button drop down
	private WebElement SearchType;

	@FindBy(xpath = "//*[@id=\"select-dropdown\"]/div/div/ul/li[1]/div/div/label/span") // All Button
	private WebElement All;

	@FindBy(xpath = "//*[@id=\"totalResult\"]/span/strong") // All Button result
	private WebElement Allresult;

	@FindBy(xpath = "//*[@id=\"select-dropdown\"]/div/div/ul/li[2]/div/div/label/span") // Citation button 
	private WebElement citation;
	
	@FindBy(xpath = "//input[@id='searchCitationFormat']") // Citation search box
	private WebElement citationsearchbox;

	@FindBy(xpath = "//input[@id='publisher']") // Citation section search box
	private WebElement citationsectionbox;

	@FindBy(xpath = "//*[@id=\"citationJournal\"]/tr[37]/td[2]") // Citation name
	private WebElement Citationname;

	@FindBy(xpath = "//*[@id=\"totalResult\"]/span") // Citation name result
	private WebElement Citationresult;

	@FindBy(xpath = "//*[@id=\"select-dropdown\"]/div/div/ul/li[3]/div/div/label/span") // Judge Name
	private WebElement JudgeName;

	@FindBy(xpath = "//input[@id='judgename']") // Judge Name search box
	private WebElement JudgeNamebox;

	@FindBy(xpath = "//*[@id=\"totalResult\"]/span") // Judge Name search result
	private WebElement JudgeNameresult;

	@FindBy(xpath = "//*[@id=\"select-dropdown\"]/div/div/ul/li[4]/div/div/label/span") // Party Name
	private WebElement PartyName;

	@FindBy(xpath = "//input[@id='petitionername']") // Party Name box
	private WebElement PartyNamebox;

	@FindBy(xpath = "//*[@id=\"totalResult\"]/span") // Party Name result
	private WebElement PartyNameresult;

	@FindBy(xpath = "//*[@id=\"select-dropdown\"]/div/div/ul/li[5]/div/div/label/span") // Act Name
	private WebElement ActName;

	@FindBy(xpath = "//input[@id='actname']") // Act Name box
	private WebElement ActNamebox;

	@FindBy(xpath = "//input[@id='section']") // Act Name section box
	private WebElement ActNamesection;

	@FindBy(xpath = "//*[@id=\"totalResult\"]/span") // Act Name result
	private WebElement ActNameresult;
	
	@FindBy(xpath = "//*[@id=\"changesearchbutton\"]") // Search Type button
	private WebElement search_type_button;
	
	
	// Actions 	
	  public void verifysearchfilter(WebDriver driver) throws InterruptedException {
	        // Free text search
	        searchbox.sendKeys("ram");
	        SearchButton.click();
	        Waitutility.waitForSpinnerToDisappear(driver);
	        ResultValidator.  validateSearchResult(driver, Allresult, "Free Text Search");

	        // Citation search
	        Library.click(driver, SearchType, "Open Search Type");
	        Library.click(driver, citation, "Select Citation");
	        Library.sendKeys(driver, citationsearchbox, "Enter journal", "AIR");
	        Library.click(driver, citationsectionbox, "Focus Section Box");
	        Library.click(driver, Citationname, "Select Citation Name");
	        Library.sendKeys(driver, citationsectionbox, "Enter year", "201749");
	        Library.click(driver, SearchButton, "Click Search");
	      UtilityClass.Waitutility.waitForSpinnerToDisappear(driver);
	       ResultValidator. validateSearchResult(driver,Citationresult, "Citation Search");

	        // Judge Name search
	        Library.click(driver, SearchType, "Open Search Type");
	        Library.click(driver, JudgeName, "Select Judge Name");
	        Library.sendKeys(driver, JudgeNamebox, "Enter judge name", "rakesh");
	        SearchButton.click();
	        Waitutility.waitForSpinnerToDisappear(driver);
	        ResultValidator. validateSearchResult(driver,JudgeNameresult, "Judge Name Search");

	        // Party Name search
	        SearchType.click();
	        PartyName.click();
	        PartyNamebox.sendKeys("ashiana");
	        SearchButton.click();
	        Waitutility.waitForSpinnerToDisappear(driver);
	        ResultValidator. validateSearchResult(driver,PartyNameresult, "Party Name Search");

	        // Act Name search
	        SearchType.click();
	        ActName.click();
	        ActNamebox.sendKeys("indian penal code");
	        ActNamesection.sendKeys("53");
	        SearchButton.click();
	        Waitutility.waitForSpinnerToDisappear(driver);
	        ResultValidator.validateSearchResult(driver,ActNameresult, "Act Name Search");
	    }
		}
