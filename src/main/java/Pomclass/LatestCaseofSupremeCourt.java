package Pomclass;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import generic.SwitchWindow;

public class LatestCaseofSupremeCourt extends BasePage1 {

	public LatestCaseofSupremeCourt(WebDriver driver) {
		super(driver);
	}
	@FindBy (xpath="/html/body/div[3]/main/a[1]/button") private WebElement latestcasebtn;
	@FindBy (xpath="//select[@id='date_filter']") private WebElement datefilterdropdown;
	@FindBy (xpath="//select[@id='sortBy']") private WebElement sortbydropdown;
	@FindBy(xpath="//*[@id=\"result\"]/div[2]/div[1]/a") private WebElement clcikonnews;
	@FindBy(xpath="//*[@id=\"court1\"]")private WebElement supremecourtcasetotal;
	@FindBy(xpath="//*[@id=\"court2\"]") private WebElement totalNoOFhighcourtcases;
	@FindBy(xpath="//*[@id=\"court3\"]") private WebElement totalNoOFtribunalcases;
	
	
	public List<String> checkSupremeCourtCases(WebDriver driver) throws InterruptedException {
	    List<String> brokenLinks = new ArrayList<>();
	    
	   
	    driver.findElement(By.xpath("//a[contains(text(),'Supreme Court')]")).click();
	    Thread.sleep(2000);

	    
	    Select dateFilter = new Select(datefilterdropdown);
	    dateFilter.selectByValue("7");
	    Thread.sleep(2000);

	   
	    List<WebElement> caseLinks = driver.findElements(By.xpath("//*[@id=\"result\"]/div/div/a"));

	    for (WebElement link : caseLinks) {
	        String openInNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
	        link.sendKeys(openInNewTab);
	        Thread.sleep(3000);

	        
	        SwitchWindow.switchWindowByIndex(driver, 1);
	        Thread.sleep(3000);

	        String pageSource = driver.getPageSource().toLowerCase();

	        if (pageSource.contains("404") || pageSource.contains("server error") || pageSource.contains("this page isn’t working")) {
	            brokenLinks.add(driver.getCurrentUrl());
	        }

	        driver.close(); 
	        SwitchWindow.switchWindowByIndex(driver, 0);
	    }

	    return brokenLinks;
	}
	

}
