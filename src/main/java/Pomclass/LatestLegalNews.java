package Pomclass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import UtilityClass.Library;
import generic.SwitchWindow;
public class LatestLegalNews  extends BasePage1 {

	public LatestLegalNews(WebDriver driver) {
		super(driver);
	}


	@FindBy (xpath="/html/body/div[3]/main/a[3]/button")
	private WebElement latestlegalnewsbtn;
	
	@FindBy (xpath="/html/body/main/section/div/div/div/div/div[2]/div/div[2]/div/a[1]/u")  //main latestpage legal news casefirst
	private WebElement firstlinkcase;
	
	@FindBy (xpath="/html/body/main/section/div/div/div/div/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table[4]/tbody/tr/td/table[5]/tbody/tr/th[2]/table/tbody/tr/td[2]/table[4]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td[2]/div/a/span")  //after click on firstcase redirect to another page there is another case readmore
	private WebElement readmorebtn2;
	
	@FindBy(xpath="//*[@id=\"entity_section\"]/div/div/div/div[1]/div[4]/p[1]/a/strong") 
	private WebElement clickonreadorder;
	
	@FindBy(xpath="//*[@id=\"tab11_padding_top\"]") 
	private WebElement clickonissue;
	
	@FindBy(xpath="//*[@id=\"tab1_padding_top\"]") 
	private WebElement fact;
	
	@FindBy(xpath="//*[@id=\"tab2_padding_top\"]") 
	private WebElement ArgumentsOfPetitioner;
	
	@FindBy(xpath="//*[@id=\"tab4_padding_top\"]") 
	private WebElement  Reasoning;
	
	@FindBy(xpath="//*[@id=\"tab7_padding_top\"]") 
	private WebElement   Decision;
	//there


	public void latestlegalnewsfeature(WebDriver driver) throws InterruptedException
	{
		Library.click(driver, latestlegalnewsbtn, "click on legalnewsbtn");
		Library.threadSleep(3000);

		SwitchWindow.switchWindowByIndex(driver, 2);
		Thread.sleep(3000);
	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", firstlinkcase);
		firstlinkcase.click();
		Thread.sleep(3000);

		
		SwitchWindow.switchWindowByIndex(driver, 3);
		Thread.sleep(3000);
		
		
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("arguments[0].scrollIntoView(true);", readmorebtn2);
		readmorebtn2.click();
		Thread.sleep(4000);
		
		
		SwitchWindow.switchWindowByIndex(driver, 4);
		Thread.sleep(3000);
		
		
		Library.click(driver,clickonreadorder , "click on readorder link");
		Library.threadSleep(3000);
		
	//	Library.click(driver,clickonissue , "click on issue");
	//	Library.threadSleep(3000);
		
	//	Library.click(driver,fact , "click on fact");
	//	Library.threadSleep(3000);

	//	Library.click(driver,ArgumentsOfPetitioner , "click on ArgumentsOfPetitioner");
	//	Library.threadSleep(3000);

		//Library.click(driver,Reasoning , "click on Reasoning");
		//Library.threadSleep(3000);


		//Library.click(driver,Decision , "click on Decision");
		//Library.threadSleep(3000);
	}
	
	
}
