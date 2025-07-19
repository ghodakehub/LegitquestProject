package Pomclass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import generic.CommonVerification;
import generic.Library;
import generic.PaginationsUtility;

public class ProfileActionsfunctionality extends BasePage1 {

	public ProfileActionsfunctionality(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id=\"navbarsExampleDefault\"]/ul/li/a")
	private WebElement profilename;                 
	
	@FindBy(xpath = "//a[text()='Profile']")        
	private WebElement profile;
	
	@FindBy(xpath = "(//a[@title='Rename search history'])[1]")     //update or rename searchhistory of user   
	private WebElement renamesearchhistorybtn;
	
	
	@FindBy(xpath = "//input[@id='editSearchTextarea']")
	private WebElement searchtext;                   //here enter rename text
	
	@FindBy(xpath = "//*[@id=\"editSearchModel\"]/div/div/div[3]/button[2]")  //after enter text update this text
	private WebElement updatebtn;                 
	
	@FindBy(xpath = "//span[@id='successupdatemessage']")
	private WebElement successfulupdatemsg;   
	
	@FindBy(xpath = "//*[@id=\"editSearchModel\"]/div/div/div[3]/button[1]")
	private WebElement closebtn;
	
	@FindBy(xpath = "//*[@id=\"datatable\"]/tbody/tr[2]/td[4]/a[3]/i")
	private WebElement sharesearchhistoryarrowbtn;
	
	@FindBy(xpath = "//input[@id='sharesavedhistory_user_email']")
	private WebElement entermailid;
	
	@FindBy(xpath = "//button[@id='share_saved_history_btn']")  // after sharebtn the alert pop is there
	private WebElement sharebtn;
	

	@FindBy(xpath = "//*[@id=\"datatable\"]/tbody/tr[1]/td[4]/a[2]/i")
	private WebElement deletebtn;
	
	@FindBy(xpath = "//*[@id=\"deletesearchmodal\"]/div/div/div[3]/button[2]")
	private WebElement deletebtnondeletepop;
	
	@FindBy(xpath = "/html/body/main/section/div/div/div/div/div/section/div/div/div[1]/div[2]/a/button/i")
	private WebElement savesearhbtn;
	
	public void verifyProfileActions(WebDriver driver) throws InterruptedException {
	  
	        Actions act = new Actions(driver);
	        act.moveToElement(profilename).perform();
	        act.click().perform();
	        profile.click();
	        Thread.sleep(2000);

	        // Click rename search history button
	        renamesearchhistorybtn.click();
	        Thread.sleep(2000);

	        // Update search name
	        searchtext.clear();
	        Thread.sleep(500);
	        searchtext.sendKeys("Test1");
	        Thread.sleep(1000);
	        updatebtn.click();
	        Thread.sleep(2000);

	        // Scroll to share button and share via email
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sharesearchhistoryarrowbtn);
	        sharesearchhistoryarrowbtn.click();
	        Thread.sleep(1000);
	        entermailid.sendKeys("ghodake6896@gmail.com");
	        Thread.sleep(1000);
	        sharebtn.click();
	        Thread.sleep(1000);

	        // Handle alert
	        try {
	            Alert alert = driver.switchTo().alert();
	            alert.accept();
	        } catch (NoAlertPresentException e) {
	            System.out.println("No alert appeared after sharing.");
	        }

	        
	        WebElement closeBtn = driver.findElement(By.xpath("//*[@id='sharesavedhistorymodal']//button"));
	        closeBtn.click();
	        Thread.sleep(1000);

	       
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deletebtn);
	        Thread.sleep(1000);
	        deletebtn.click();
	        Thread.sleep(1000);

	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deletebtnondeletepop);
	        deletebtnondeletepop.click();
	        Thread.sleep(2000);

	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",savesearhbtn );
	        Thread.sleep(1000);
	        savesearhbtn.click();
	        Thread.sleep(1000);
	        if (Library.isErrorPage(driver)) {
	            System.out.println("Error page shown!");
	        }
	}
}
