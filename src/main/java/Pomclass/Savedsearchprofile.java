package Pomclass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Savedsearchprofile extends BasePage1 {

	public Savedsearchprofile(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath = "//*[@id=\"navbarsExampleDefault\"]/ul/li/a")
	private WebElement profilename;                 
	
	@FindBy(xpath = "//a[text()='Profile']")        
	private WebElement profile;
	
	@FindBy(xpath = "/html/body/main/section/div/div/div/div/div/section/div/div/div[1]/div[2]/a/button")     //update or rename searchhistory of user   
	private WebElement savedsearch;
	
	@FindBy(xpath = "//*[@id=\"datatable\"]/tbody/tr[1]/td[4]/a[1]/i")     //update or rename searchhistory of user   
	private WebElement renameserachhistory;
	
	
	@FindBy(xpath = "//*[@id=\"editSearchTextarea\"]")
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
	
	public void verifyprofileactions(WebDriver driver) throws InterruptedException
	{
		
		Actions act=new Actions(driver);
		act.moveToElement( profilename).perform();
		act.click().perform();
		profile.click();
		Thread.sleep(2000);
		savedsearch.click();
		Thread.sleep(2000);

		renameserachhistory.click();
		Thread.sleep(2000);

		searchtext.clear();
		Thread.sleep(2000);

		searchtext.sendKeys("save for test automation ");
		Thread.sleep(2000);
		
		updatebtn.click();
		Thread.sleep(2000);
		
		String msg = successfulupdatemsg.getText();
		System.out.println(" Successful Message after rename the search history:" +msg);
		Thread.sleep(2000);
		
	//	closebtn.click();
		//Thread.sleep(3000);
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true);", sharesearchhistoryarrowbtn);
		Thread.sleep(3000);
		sharesearchhistoryarrowbtn.click();
		
		entermailid.sendKeys("ghodake6896@gmail.com");
		Thread.sleep(2000);
				
		sharebtn.click();
		Thread.sleep(2000);
		Alert alt= driver.switchTo().alert();
		alt.accept();
		Thread.sleep(3000);
		
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].scrollIntoView(true);", deletebtn);
		Thread.sleep(3000);
		deletebtn.click();
		
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("arguments[0].scrollIntoView(true);", deletebtnondeletepop);
		Thread.sleep(3000);
		deletebtnondeletepop.click();
		
}
	
	
	public void verifytbale(WebDriver driver)
	{
		int rowcount = driver.findElements(By.xpath("//*[@id=\"datatable\"]/tbody/tr")).size();
		System.out.println("No of rows:"+rowcount);
		
		int column = driver.findElements(By.xpath("//*[@id=\"datatable\"]/tbody/tr[1]/td")).size();
		System.out.println("No of column:"+column);
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=1;j<=column;j++)
			{
				String text = driver.findElement(By.xpath("//*[@id=\"datatable\"]/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.println(text);
			}
		}	}
}