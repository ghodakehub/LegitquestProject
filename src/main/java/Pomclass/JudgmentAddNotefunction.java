package Pomclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import UtilityClass.Library;
import generic.SwitchWindow;

public class JudgmentAddNotefunction extends BasePage1 {

	public JudgmentAddNotefunction(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='search']") // Main Search Box
	private WebElement searchbox;

	@FindBy(xpath = "//div[@class='search-btn']") // Main Search Icon (Button)
	private WebElement SearchButton;

	@FindBy(xpath = "//*[@id=\"select-dropdown\"]/div/div/ul/li[1]/div/div/label/span") // All
	private WebElement Allmenu;

	@FindBy(xpath = "//*[@id=\"1\"]/div/div/a/u") // second link
	private WebElement secondlink;

	@FindBy(xpath = "//*[@id=\"notes\"]/button/img") // note
	private WebElement note;

	@FindBy(xpath = "//*[@id=\"note-list\"]/div[2]/div[1]/div[1]/button") // add note 
	private WebElement addnote;

	@FindBy(xpath ="//*[@id=\"title\"]") // enter title 
	private WebElement addtitle;
	
	@FindBy(xpath ="//*[@id=\"description\"]") // enter descripiton
	private WebElement description;
	
	@FindBy(xpath ="//*[@id=\"note-form\"]/div[2]/div[1]/div[6]/button/small")//save note for judgment 
	private WebElement savebtn;
	
	@FindBy(xpath ="//*[@id=\"Layer_1\"]") // print judgment by two cloumn share
	private WebElement closeaddnote;
	
	@FindBy(xpath ="/html/body/div[1]/main/aside/div[1]/ul/li[2]/button/img") // print judgment share
	private WebElement printjudgment;
	
	@FindBy(xpath ="//*[@id=\"c1\"]/figure/img") // print judgment by one cloumn share
	private WebElement printjudgmentbyonecolumn;

	
	@FindBy(xpath ="//*[@id=\"c2\"]/figure/img") // print judgment by two cloumn share
	private WebElement printbytwocolumn;
		
		public void verifyjudgmentbynote(WebDriver driver) throws InterruptedException
		{
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			 
	        WebElement enterKeyword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
	        enterKeyword.sendKeys("Ram Kumar");
	        enterKeyword.sendKeys(Keys.ENTER);

	       
	        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='0']/div/div/a/u")));
	        firstResult.click();
			SwitchWindow.switchWindowByIndex(driver, 2);
			Thread.sleep(3000);
			Library.click(driver, note, "click on note");
			Library.threadSleep(3000);
			Library.click(driver, addnote, "click on addnote");
			Library.threadSleep(3000);
			Library.click(driver, addtitle, "click on addtile");
			Library.threadSleep(3000);
			addtitle.clear();
			Library.threadSleep(3000);
			addtitle.sendKeys("AutomationTest");
			Library.threadSleep(3000);
			
			description.sendKeys("Hello ,Enter discripition in add notes");
			Library.threadSleep(3000);
			
			Library.click(driver, savebtn, "click on savebtn");
			Library.threadSleep(3000);
			

			
		}
}
