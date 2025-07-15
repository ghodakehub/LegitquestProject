package Pomclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import UtilityClass.Library;
import generic.SwitchWindow;

public class JudgmentPrintPdf extends BasePage1 {

	public JudgmentPrintPdf(WebDriver driver) {
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
	
	@FindBy(xpath ="/html/body/div[1]/main/aside/div[1]/ul/li[2]/button/img") // print judgment share
	private WebElement printjudgment;
	
	@FindBy(xpath ="//*[@id=\"c1\"]/figure/img") // print judgment by one cloumn share
	private WebElement printjudgmentbyonecolumn;

	
	@FindBy(xpath ="//*[@id=\"c1\"]/figure/figcaption/span/i") // print 
	private WebElement downloadonecolumnprint;
	
	@FindBy(xpath ="//*[@id=\"c2\"]/figure/img") // print judgment by two cloumn share
	private WebElement  twocloumnprint;

	@FindBy(xpath ="//*[@id=\"c2\"]/figure/figcaption/span/i") // print judgment by two cloumn share
	private WebElement downloadtwoprint ;

	@FindBy(xpath ="//*[@id=\"print-modal\"]/div/div/div[1]/button/span") // print judgment by two cloumn share
	private WebElement closebtn ;
		
		public void verifyjudgmentbyprint(WebDriver driver) throws InterruptedException
		{
			
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			 
		        WebElement enterKeyword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
		        enterKeyword.sendKeys("Ram Kumar");
		        enterKeyword.sendKeys(Keys.ENTER);

		       
		        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='0']/div/div/a/u")));
		        firstResult.click();
			SwitchWindow.switchWindowByIndex(driver, 2);
			Thread.sleep(3000);
		

			JavascriptExecutor js1 = (JavascriptExecutor)driver;
			js1.executeScript("arguments[0].scrollIntoView(true);", printjudgment);
			printjudgment.click();
			
			Thread.sleep(3000);
			JavascriptExecutor js11 = (JavascriptExecutor)driver;
			js11.executeScript("arguments[0].scrollIntoView(true);", printjudgmentbyonecolumn);
			printjudgmentbyonecolumn.click();
			
			Thread.sleep(3000);
			JavascriptExecutor js2 = (JavascriptExecutor)driver;
			js2.executeScript("arguments[0].scrollIntoView(true);", downloadonecolumnprint);
			downloadonecolumnprint.click();
			
			Thread.sleep(3000);
			JavascriptExecutor js3 = (JavascriptExecutor)driver;
			js3.executeScript("arguments[0].scrollIntoView(true);", twocloumnprint);
			twocloumnprint.click();
			
			Thread.sleep(3000);
			JavascriptExecutor js4 = (JavascriptExecutor)driver;
			js4.executeScript("arguments[0].scrollIntoView(true);", downloadtwoprint);
			downloadtwoprint.click();
			
			Thread.sleep(3000);
			JavascriptExecutor js5 = (JavascriptExecutor)driver;
			js5.executeScript("arguments[0].scrollIntoView(true);", closebtn);
			closebtn.click();
			
			

			
		}

}
