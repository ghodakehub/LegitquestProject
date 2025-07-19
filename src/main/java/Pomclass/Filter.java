package Pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import UtilityClass.Library;

public class Filter extends BasePage1 {

	public Filter(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath = "//input[@id='search']") // Main Search Box
	private WebElement searchbox;

	@FindBy(xpath = "//div[@class='search-btn']") // Main Search Icon (Button)
	private WebElement SearchButton;

	@FindBy(xpath = "//*[@id=\"select-dropdown\"]/div/div/ul/li[1]/div/div/label/span") // All
	private WebElement Allmenu;

	@FindBy(xpath = "//*[@id=\"bycourt\"]/li[1]/div/label/span") // supreme court
	private WebElement supremecourt;

	@FindBy(xpath = "//*[@id=\"totalResult\"]/span/strong") // total result for the SC filter main
	private WebElement totalresult;

	@FindBy(xpath = "//*[@id=\"bycourt\"]/li[2]/div[1]/label/span") // highcourt court
	private WebElement highcourt;

	@FindBy(xpath = "//*[@id=\"bycourt\"]/li[2]/div[2]/form/ul/li[2]/div/label/span") // AP high court court
	private WebElement APhighcourt;

	@FindBy(xpath = "//*[@id=\"bycourt\"]/li[3]/div[1]/label/span") // tribunal court
	private WebElement tribunalcourt;
	
	@FindBy(xpath = "//*[@id=\"bycourt\"]/li[3]/div[2]/form/ul/li[1]/div[1]/label/span") // tribunal court
	private WebElement tribunalcourtAAAR;   //AAAR OPTION

	
	@FindBy(xpath = "//*[@id=\"bycourt\"]/li[3]/div[2]/form/ul/li[1]/div[1]/label/span") // tribunal court
	private WebElement tribunalcourtAAAROptionAP;  //AFTER AAAR ANDRAHA PRADESH
	
	@FindBy(xpath = "//*[@id=\"btnClearFilter\"]") // clear button
	private WebElement clear;

	
//filter result count
	@FindBy(xpath = "//*[@id=\"bycourt\"]/li[1]/div/label/small")
	private WebElement SCResult;
	
	@FindBy(xpath = "//*[@id=\"bycourt\"]/li[2]/div[1]/label/small")
	private WebElement HCResult;
	
	@FindBy(xpath = "//*[@id=\"bycourt\"]/li[2]/div[2]/form/ul/li[1]/div[1]/label/small")
	private WebElement APHCResult;
	
	@FindBy(xpath = "//*[@id=\"bycourt\"]/li[3]/div[1]/label/small")
	private WebElement TribunalResult;
	
	@FindBy(xpath = "//*[@id=\"bybench\"]/li/div/label/small")
	private WebElement BenchResult;
	
	@FindBy(xpath = "//*[@id=\"byyear\"]/li/div/label/small")
	private WebElement YearResult;
	
	@FindBy(xpath = "//*[@id=\"bydisposition\"]/li[1]/div/label/small")
	private WebElement DispositionResult;
	
	
	
		
		public void searchfilter( WebDriver driver) throws InterruptedException {
		
		
			Library.waitForVisibilityOf(driver, searchbox);
			Library.sendKeys(driver, searchbox, "Enter text in search bar Ram", "Ram");
			Library.threadSleep(3000);
		
		
			//Library.waitForVisibilityOf(driver, SearchButton);
			Library.click(driver,SearchButton , "click on searchbtn");
			Library.threadSleep(3000);
			
			Library.waitForVisibilityOf(driver, supremecourt);
		Library.click(driver, supremecourt, "click on SupremeCourt");
		Thread.sleep(3000);
		
		// By Supreme court total no cases found 
				String totalnocases = SCResult.getText();
				System.out.println("Total Numbers of cases found in SupremeCourt :" +totalnocases);
				Thread.sleep(3000);
				
              //High court cases
				Library.waitForVisibilityOf(driver,highcourt );
				Library.click(driver, highcourt, "click on HighCourt");
				
				String highcourtcases = HCResult.getText();
				System.out.println("Total Numbers of cases found in highcourtcases :" +highcourtcases);
				Thread.sleep(3000);
				
				Library.waitForVisibilityOf(driver,APhighcourt );
				Library.click(driver, APhighcourt, "click on AndhraPradeshHighcourt");
				

				Thread.sleep(2000);
				
				// By AP high court filter totalno of cases
				String APhighcourtcases = APHCResult.getText();
				System.out.println("Total Numbers of cases found in APhighcourtcases :" +APhighcourtcases);
				
				Thread.sleep(2000);
				Library.waitForVisibilityOf(driver,clear );
				Library.click(driver, clear, "click on clear");
				
				Thread.sleep(5000);
				// By tribunal court cases
				Library.waitForVisibilityOf(driver,tribunalcourt );
				Library.click(driver, tribunalcourt, "click on TribunalCourt");
				
				Thread.sleep(3000);
				String tribunalcases =TribunalResult .getText();
				System.out.println("Total numbers of TribunalCourtcases:"+tribunalcases);
				
				Thread.sleep(3000);
				Library.waitForVisibilityOf(driver,tribunalcourtAAAR );
				Library.click(driver, tribunalcourtAAAR, "click on AAAR Under TribunalCourt");

			
		}
}
