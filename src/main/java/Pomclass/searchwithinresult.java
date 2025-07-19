package Pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;

import UtilityClass.Library;

public class searchwithinresult extends BasePage1 {

	public searchwithinresult(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='search']") // Main Search Box
	private WebElement searchbox;

	@FindBy(id = "btnSearch") // Main Search Icon (Button)
	private WebElement SearchButton;

	@FindBy(xpath = "//*[@id=\"select-dropdown\"]/div/div/ul/li[1]/div/div/label/span") // All
	private WebElement Allmenu;

	@FindBy(xpath = "(//a[@class='popup-open search-link mr-3'])[1]") // search within result option
	private WebElement searchwithin;
	
	@FindBy(id = "searchitem0") // search within result box option
	private WebElement searchwithinbox;
	
	@FindBy(xpath = "//*[@id=\"0\"]/div/div[1]/div[3]/div/div[1]/div[2]/div[1]/button[1]") // search within result search button //*[@id="btnSearch"]/i
	private WebElement searchwithinbutton;
	
	@FindBy(xpath = "//*[@id=\"0\"]/div/div[1]/div[3]/div/div[1]/div[2]/div[1]/button[3]") // search within result next button
	private WebElement next;
	
	@FindBy(xpath = "//*[@id=\"0\"]/div/div[1]/div[3]/div/div[1]/div[2]/div[1]/button[2]") // search within result previous button
	private WebElement previous;
	
	@FindBy(xpath = "//*[@id=\"0\"]/div/div/div[3]/div/div[1]/div[1]/a/i") // search within result cancel button
	private WebElement cancel;
	
	@FindBy(xpath = "//*[@id=\"occurancefound0\"]") // search within result 
	private WebElement msg;
	
	@FindBy(xpath = "//*[@id=\"0\"]/div/div[1]/div[3]/a[2]/small") // search within result 
	private WebElement headnote;
	
	@FindBy(xpath = "//*[@id=\"0\"]/div/div[1]/div[3]/div/div[2]/div[2]/p") // search within result 
	private WebElement headnotetext;
	
	@FindBy(xpath = "//*[@id=\"0\"]/div/div[1]/div[3]/div/div[2]/div[1]/a/i") // search within result 
	private WebElement headnotecanclebtn;
	

	@FindBy(xpath = "//*[@id=\"0\"]/div/div[1]/div[3]/a[3]/small") // search within result 
	private WebElement judge;
	
	@FindBy(xpath = "//*[@id=\"0\"]/div/div[1]/div[3]/div/div[3]/div[2]/div/span") // search within result 
	private WebElement judgename;
	
	@FindBy(xpath = "//*[@id=\"0\"]/div/div[1]/div[3]/div/div[3]/div[1]/a/i") // search within result 
	private WebElement judgenamecanclebtn;
	
	
	@FindBy(xpath = "//*[@id=\"0\"]/div/div[1]/div[3]/a[4]") // search within result 
	private WebElement timeline;
	
	@FindBy(xpath = "//*[@id=\"timeline-modal\"]/div/div/div[2]/div/div[2]/div") // search within result 
	private WebElement timelinetext;
	
	@FindBy(xpath = "//*[@id=\"timeline-modal\"]/div/div/div[1]/button") // search within result 
	private WebElement timelineclosebtn;
	
	
// Actions 	
	public void SearhResult(WebDriver driver) throws InterruptedException {
		
		searchbox.sendKeys("ramesh");
		Thread.sleep(3000);
		SearchButton.click();
		Thread.sleep(3000);
		
		searchwithin.click();// option
		Thread.sleep(2000);
		searchwithinbox.sendKeys("ramesh"); //search box
		Thread.sleep(2000);
		searchwithinbutton.click();
		Thread.sleep(2000);
		Library.click(driver, next, "click on nextbtn");
		Thread.sleep(2000);
		Library.click(driver, next, "click on nextbtn");
		Thread.sleep(2000);
		//next.click();
		//Thread.sleep(2000);
		//next.click();
		//Thread.sleep(2000);
		previous.click();
		Thread.sleep(2000);
		previous.click();
		Thread.sleep(2000);
		cancel.click();
		Thread.sleep(2000);
		
		// Search within result meaningless word
		
		searchwithin.click();// option
		Thread.sleep(2000);
		searchwithinbox.clear();
		Thread.sleep(3000);
		searchwithinbox.sendKeys("xyz"); //search box
		Thread.sleep(2000);
		searchwithinbutton.click();
		Thread.sleep(3000);
		
	//	String actualText1 = msg.getText();
	//	String ExpectedText1 = "Found in 33 places";
	//	Assert.assertEquals(actualText1, ExpectedText1);
	//	Reporter.log("Search Within Result is working with meaningless word", true);
	//	Thread.sleep(3000);
		cancel.click();
		Thread.sleep(2000);
		
		
		Library.click(driver, headnote, "click on headnote");
		Library.threadSleep(3000);
		
		String textnote = headnotetext.getText();
		System.out.println("HeadNoteText :"+textnote);
	
		Library.click(driver, headnotecanclebtn, "click on headnotecanclebtn");
		Library.threadSleep(3000);
		
		Library.click(driver, judge, "click on judge");
		Library.threadSleep(3000);
		
		String textnote1 = judgename.getText();
		System.out.println("judgename :"+textnote1);
	
		Library.click(driver,judgenamecanclebtn , "click on judgenamecanclebtn");
		Library.threadSleep(3000);
		
	/*	Library.click(driver, timeline, "click on timeline");
		Library.threadSleep(3000);
				
		String textnote2 = timelinetext.getText();
		System.out.println("timelinetext :"+textnote2);
	
		Library.click(driver,timelineclosebtn , "click on timelineclosebtn");
		Library.threadSleep(3000); */
	


		
		
		

	}

}
