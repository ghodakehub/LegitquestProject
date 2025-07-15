package Pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import UtilityClass.Library;

public class SaveSearchJugement extends BasePage1 {

	public SaveSearchJugement(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='search']") // Main Search Box
	private WebElement searchbox;

	@FindBy(xpath = "//div[@class='search-btn']") // Main Search Icon (Button)
	private WebElement SearchButton;

	@FindBy(xpath = "//*[@id=\"select-dropdown\"]/div/div/ul/li[1]/div/div/label/span") // All
	private WebElement Allmenu;

	@FindBy(xpath = "/html/body/div[2]/main/section/div/div/div[3]/a") // click on idraf 
	private WebElement idraf;
	
	@FindBy(xpath ="//select[@id='sortBy']") // sortby oldest newst
	private WebElement sortby;
	
	@FindBy(xpath = "/html/body/div[2]/main/div[1]/a/img") // go to save search  court
	private WebElement savesearch;
	
	@FindBy(id="saved_history")
	private WebElement entertext;
	
	

	@FindBy(xpath="//button[@onclick='SavedSearchHistory();']")
	private WebElement clickonsavebtn;
	
	@FindBy(xpath="//*[@id=\"successMsg\"]") //meassage after save a judgement savesearched history successfully
	private WebElement message;
	
	
	@FindBy(xpath="//button[@class='btn btn-secondary']")
	private WebElement closebtn;
	
	
	public void verifysavesearch(WebDriver driver) throws InterruptedException
	{
		
		
		Library.sendKeys(driver, searchbox, "Enter text in search bar nitish kumar", "Nitish Kumar");
		Library.threadSleep(3000);
	
	
		//Library.waitForVisibilityOf(driver, SearchButton);
		Library.click(driver,SearchButton , "click on searchbtn");
		Library.threadSleep(3000);
		
	
		
		Select opt= new Select(sortby);
		opt.selectByVisibleText("Newest");
		Library.threadSleep(5000);
		
		opt.selectByVisibleText("Oldest");
		Library.threadSleep(5000);
		
		
		opt.selectByVisibleText("Relevance");
		Library.threadSleep(5000);
		
	Actions act= new Actions(driver);
	act.moveToElement(savesearch).click().perform();
	Library.threadSleep(3000);

	//Library.waitForVisibilityOf(driver, entertext);
	Library.sendKeys(driver, entertext, "Enter text in save search", "save doc5");
	Library.threadSleep(3000);

	Library.click(driver,clickonsavebtn , "click on save button of save search");
	
	Thread.sleep(6000);
	String accutalymessage = message.getText();
	System.out.println("After save document or jugdement successfully message get :"+accutalymessage);
			
			Thread.sleep(4000);
		
			Library.click(driver,closebtn , "click on closebtn");
	
}
}
