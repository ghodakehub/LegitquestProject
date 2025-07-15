package Pomclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import UtilityClass.Library;

import generic.SwitchWindow;

public class Third_PageButton extends BasePage1 {

	public Third_PageButton(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='search']") // Main Search Box
	private WebElement searchbox;

	@FindBy(xpath = "//div[@class='search-btn']") // Main Search Icon (Button)
	private WebElement SearchButton;

	@FindBy(xpath = "//*[@id=\"select-dropdown\"]/div/div/ul/li[1]/div/div/label/span") // All
	private WebElement Allmenu;

	@FindBy(xpath = "//*[@id=\"0\"]/div/div/a/u") // first link
	private WebElement firstlink;

	@FindBy(xpath = "//button[@title='Download Judgment']") // download button
	private WebElement download;

	@FindBy(xpath = "//*[@id=\"selectfontdiv\"]/label") // Alert box for judgment download 
	private WebElement DownloadBox;

	@FindBy(xpath = "//select[@id='getfontsize']") // Alert drop down box for judgment download
	private WebElement downloadbysize;

	@FindBy(xpath = "//*[@id=\"downloadbtn\"]/button") // Download Button for judgment Download
	private WebElement DownloadButton;

	@FindBy(xpath = "//*[@id=\"share_judgment_message\"]") // Download Box text for judgment download
	private WebElement DownloadText;
	
	
	@FindBy(xpath = "//*[@id=\"selectfontsizemodal\"]/div/div/div[1]/button") //  judgment download close 
	private WebElement closebtnofdownload;
	
	@FindBy(xpath = "//*[@id=\"body\"]/div[1]/div[2]/div[2]/button[2]/i") // savebookmark
	private WebElement savebookmark;
	

	@FindBy(xpath = "/html/body/div[9]/div[2]/div/div[4]/div[2]/button") // alertpopsavebookmark ok btn
	private WebElement savebookmarkokbtn;
	
	
	@FindBy(xpath = "//button[@id='nightmode']") // change into nighmode 
	private WebElement nightmode;
	
	@FindBy(xpath = "//button[@id='lightmode']") // change into lightmode again  
	private WebElement lightmode;
	

	@FindBy(xpath = "//button[@data-target='.report-problem-form']") // Report a problem
	private WebElement Reportaproblem;

	@FindBy(xpath = "//*[@id=\"report-problem-form\"]/div/div/div[2]/div[3]/label")
	private WebElement ReportaproblemPop;

	@FindBy(xpath = "//*[@id=\"report-problem-form\"]/div/div/div[1]/button/span") //
	private WebElement ReportaproblemPopX;

	@FindBy(xpath = "//*[@id=\"app__container\"]/main/div[3]")
	private WebElement linkdinpage;

	@FindBy(xpath = "//*[@id=\"selectfontsizemodal\"]/div/div/div[1]/button/span")
	private WebElement cancelbutton;

	
	@SuppressWarnings({ "deprecation" })
	public void thirdpagebuttonsverification(WebDriver driver ) throws InterruptedException {
	Thread.sleep(3000);
	searchbox.sendKeys("ram");
	Thread.sleep(3000);
	SearchButton.click();
	Thread.sleep(3000);
	Library.waitForVisibilityOf(driver, firstlink);
	Library.click(driver,firstlink , "click on firstlink");
	Library.threadSleep(3000);
	
	SwitchWindow.switchWindowByIndex(driver, 2);
	Thread.sleep(3000);
	// Download Button
	download.click();
	Thread.sleep(3000);
	Actions action = new Actions(driver);
	action.moveToElement(DownloadBox);
	Thread.sleep(3000);

	String ActualText = DownloadBox.getText();
	String ExpectedText = "Select font size of your choice";
	Assert.assertEquals(ActualText, ExpectedText);
	Reporter.log("Judgment Download box has open successfully");
	Thread.sleep(3000);

	Select select = new Select(downloadbysize);
	select.selectByIndex(3);
	Thread.sleep(3000);

	DownloadButton.click();

	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	action.moveToElement(DownloadText);

	String ActualText2 = DownloadText.getText();
	String ExpectedText2 = "Downloading judgment please wait....";
	Assert.assertEquals(ActualText2, ExpectedText2);
	Reporter.log("Judgment Download has successfully");
	Thread.sleep(3000); 
	
	closebtnofdownload.click();
	Thread.sleep(2000);
     Library.click(driver,savebookmark, "click on savebookmarkbtn");
	
	
	Thread.sleep(2000);
	Library.click(driver, nightmode, "click on nightmode");
	Library.threadSleep(3000);
	
	Library.click(driver, lightmode, "click on lightmode");
	Library.threadSleep(3000);
	// Report a problem Button
	
	 Reportaproblem.click(); Thread.sleep(3000);
	 

	 action.moveToElement(ReportaproblemPop); Thread.sleep(3000);
	 
	 String ActualText3 = ReportaproblemPop.getText(); 
	 String ExpectedText3 = ReportaproblemPop.getText();
	 Assert.assertEquals(ActualText3, ExpectedText3);
	 Reporter.log("Report a Problem is working fine");
	 Thread.sleep(3000);
	  ReportaproblemPopX.click();
	  Thread.sleep(3000);
	 
}
}
