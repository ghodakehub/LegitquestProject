package Pomclass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;




public class FilterWithinResult extends BasePage1 {

	public FilterWithinResult(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='search']")  //Main Search Box
	private WebElement searchbox;
	
	@FindBy(xpath = "//div[@class='search-btn']") // Main Search Icon (Button) hh
	private WebElement SearchButton;
	
	@FindBy(xpath = "//button[@data-toggle='collapse']")  //Search type button drop down
	private WebElement SearchType;

	@FindBy(xpath="//*[@id=\"searchwithinresult\"]")  //filter within result box
	private WebElement FWRbox;
	
	@FindBy(xpath = "//*[@id=\"btnFilterResult\"]")  // filter within result search icon
	private WebElement FWRSicon;
	
	@FindBy(xpath="//*[@id=\"filterwithinclosebutton\"]")  // filter within result cancel icon
	private WebElement FWRCButton;
	
	@FindBy(xpath = "//*[@id=\"totalWithinResult\"]/div/div/div/a")  // filter within result remover icon
	private WebElement FWRRButton;
	
// Actions 	
	public void verifyfilterwithinresult(WebDriver driver) throws InterruptedException {
		searchbox.sendKeys("ex debito");
		Thread.sleep(3000);
		SearchButton.click(); // Main search icon
		Thread.sleep(3000);
		FWRbox.sendKeys("ram"); // filter within result search box
		Thread.sleep(3000);
		FWRSicon.click(); //filter within result search icon
		Thread.sleep(4000);
		
		
	FWRbox.sendKeys("rahul"); // filter within result search box
		Thread.sleep(3000);
		
		FWRSicon.click(); //filter within result search icon
		Thread.sleep(3000);
		
		try {
		
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click();", FWRRButton);
			Thread.sleep(4000);
			
		
			

		}catch(StaleElementReferenceException e) {
					
	}
	}
}
