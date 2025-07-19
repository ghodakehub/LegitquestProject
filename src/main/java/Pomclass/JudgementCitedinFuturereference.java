package Pomclass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import UtilityClass.Library;
import generic.SwitchWindow;

public class JudgementCitedinFuturereference extends BasePage1 {

	public JudgementCitedinFuturereference(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='search']")
	private WebElement searchbar;                  //main searchbar text
	
	@FindBy(xpath = "//a[@id='btnSearch']")         //searchbtn
	private WebElement searchbtn;
	
	@FindBy(xpath = "//*[@id=\"bycourt\"]/li[1]/div/label/span")         //there is all details avaliable likefuturereference citedin 
	private WebElement supremecourt;
	
	@FindBy(xpath = "//*[@id=\"changesearchbutton\"]")
	private WebElement allbtn;
	
	@FindBy(xpath = "//*[@id=\"0\"]/div/div/a/u")
	private WebElement firstcaselink;
	
	@FindBy(linkText = "Future Reference")
	private WebElement futurereference;
	
	@FindBy(xpath = "//*[@id=\"citedresult\"]/ul/li[2]/a")
	private WebElement hccasetabbtn;
	
	
	@FindBy(xpath = "//*[@id=\"HighCourt\"]/div[1]/div/h4/a")
	private WebElement futurereferenceHCcase;
	
	@FindBy(linkText = "Tribunal")
	private WebElement futurereferenTribunal;
	
	
	@FindBy(xpath = "//*[@id=\"Tribunal\"]/div[1]/div/h4/a")
	private WebElement futurereferenTribunalcecase1;
	
	@FindBy(linkText = "Cited In")
	private WebElement citedIn;
	
	@FindBy(linkText = "New India Assurance Co. Ltd. V. R. Srinivasan")
	private WebElement citedIncase;
	
	
	
	@FindBy(linkText = "Advocates")
	private WebElement advocates;
	
	@FindBy(xpath = "//*[@id=\"advocate\"]/div[2]/h4/span")
	private WebElement advocateslist;
	
	@FindBy(linkText = "Bench")
	private WebElement bench;
	
	@FindBy(xpath = "//*[@id=\"bench\"]/div[2]/h4[1]/span")
	private WebElement benchlist1;
	
	@FindBy(xpath = "//*[@id=\"bench\"]/div[2]/h4[2]/span")
	private WebElement benchlist2;
	
	@FindBy(linkText = "Eq Citations")
	private WebElement eqCitations;
	
	@FindBy(xpath = "//*[@id=\"eqcitation\"]/div[2]/h4[2]/span")
	private WebElement eqCitationscase;
	
	@FindBy(xpath = "//*[@id=\"eqcitation\"]/div[2]/h4[3]/span")
	private WebElement eqCitationscase3;
	
	@FindBy(xpath = "//*[@id=\"eqcitation\"]/div[2]/h4[4]/span")
	private WebElement eqCitationscase4;
	
	
	@FindBy(linkText = "HeadNote")
	private WebElement headNote;
	
	@FindBy(xpath = "//*[@id=\"headnotes\"]/div[2]/p/span")
	private WebElement headNotedetail;
	
	
	public void verifycitedinfuturebench(WebDriver driver) throws InterruptedException
	{
		
		
		Library.sendKeys(driver,searchbar , "Enter text in search bar ", " arvindkumar");
		Library.threadSleep(3000);
	
		Library.click(driver,searchbtn , "click on searchbtn");
		Library.threadSleep(3000);
		

		Library.click(driver,supremecourt , "click on supremecourt");
		Library.threadSleep(3000);
		
		JavascriptExecutor js10 = (JavascriptExecutor) driver;
		js10.executeScript("arguments[0].scrollIntoView(true);", firstcaselink);
		Thread.sleep(3000);
		firstcaselink.click();
		
		SwitchWindow.switchWindowByIndex(driver, 2);
		Thread.sleep(3000);
	
		
		Library.click(driver,futurereference , "click on Futurereference");
		Library.threadSleep(3000);
		
		hccasetabbtn.click();
		Library.threadSleep(3000);
		futurereferenceHCcase.click();
		Thread.sleep(3000); 
		
		SwitchWindow.switchWindowByIndex(driver, 2);
		Thread.sleep(3000);
	

		futurereferenTribunal.click();
		Thread.sleep(3000);

		futurereferenTribunalcecase1.click();
		Thread.sleep(3000);

		
		SwitchWindow.switchWindowByIndex(driver, 2);
		Thread.sleep(3000);
	

		Library.click(driver, citedIn, "click on CitedIn");
		Library.threadSleep(3000);
		
		citedIncase.click();	
		Thread.sleep(2000);
		SwitchWindow.switchWindowByIndex(driver, 2);
		Thread.sleep(3000);
	
		
		Library.click(driver,advocates , "click on Advocates");
		Library.threadSleep(3000);
		
		String advocatedetails = advocateslist.getText();
		System.out.println("Advocate details :"+advocatedetails);
		
		Library.click(driver,bench , "click on Bench");
		Library.threadSleep(3000);
		
		String benchdetails = benchlist1.getText();
		System.out.println("Bench details :"+benchdetails);
		
		String benchdetails1 = benchlist2.getText();
		System.out.println("Bench details :"+benchdetails1);
		
		
		Library.click(driver, eqCitations, "click on EqCitations");
		Library.threadSleep(3000);
		
			String abc = eqCitationscase.getText();
			System.out.println("Eq Citationsdetails details :"+abc);
			Thread.sleep(3000);
			
			String abc1 = eqCitationscase3.getText();
			System.out.println("Eq Citationsdetails details :"+abc1);
			Thread.sleep(3000);
			

			String abc2 = eqCitationscase4.getText();
			System.out.println("Eq Citationsdetails details :"+abc2);
			Thread.sleep(3000);
			
		Library.click(driver,headNote , "click on HeadNote");
		Library.threadSleep(3000);
		
		String headnotedetails = headNote.getText();
		System.out.println("Headnote details :"+headnotedetails);
	}		

}
