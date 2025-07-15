package Pomclass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import UtilityClass.Library;


public class SnapShot extends BasePage1 {

	public SnapShot(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath = "(//button[@type='button'])[4]") // LoginButton
	private WebElement loginbtn;

	@FindBy(xpath = "//input[@id='search']") // Main Search Box
	private WebElement searchbox;

	@FindBy(xpath = "//div[@class='search-btn']") // Main Search Icon (Button)
	private WebElement SearchButton;

	@FindBy(xpath = "//*[@id=\"select-dropdown\"]/div/div/ul/li[1]/div/div/label/span") // All
	private WebElement Allmenu;

	
	@FindBy(xpath = "//*[@id=\"bycourt\"]/li[1]/div/label/span") // supreme court
	private WebElement supremecourt;
	
	@FindBy(xpath = "/a[@class='popup-open snapshot-link mr-3']") // snapshot button
	private WebElement Snapshot;

	@FindBy(xpath = "//*[@id=\"8\"]/div/div/div[2]/div/div[3]/div[1]/span/span") // snapshot result
	private WebElement Snapshotresult;
	
	
	
	
// Actions 	
	public void click(WebDriver driver) throws InterruptedException {
		searchbox.sendKeys("snapshot");
		Thread.sleep(3000);
		SearchButton.click();
		Thread.sleep(3000);
		supremecourt.click();
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		js.executeScript("arguments[0].scrollIntoView(true);", Snapshot);
		
		Thread.sleep(3000);
		Snapshot.click();
		Thread.sleep(5000);
		
		
		// By Supreme court filter data match
		String actualText = Snapshotresult.getText();
		String ExpectedText = "Snapshot";
		Assert.assertEquals(actualText, ExpectedText);
		Reporter.log("Snapshot results verified", true);
		
		
		
		

	}

}
