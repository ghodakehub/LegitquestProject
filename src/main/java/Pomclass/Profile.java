package Pomclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class Profile extends BasePage1 {

	public Profile(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id=\"navbarsExampleDefault\"]/ul/li/a")
	private WebElement profilename;                  //main searchbar text
	
	@FindBy(xpath = "//a[text()='Profile']")         //searchbtn
	private WebElement profile;
	
	@FindBy(xpath = "/html/body/main/section/div/div/div/div/div/section/div/div/div[1]/div[1]/p")         //text of searchhistory at profile
	private WebElement searchhistory;
	
	
	@FindBy(xpath = "/html/body/main/section/div/div/div/div/div/div/div/div[1]/div/p")
	private WebElement username;                 //Name of user at profile page
	
	@FindBy(xpath = "/html/body/main/section/div/div/div/div/div/div/div/div[1]/div/div/p/small[1]")
	private WebElement userdetails;                  //main searchbar text
	
	@FindBy(xpath = "/html/body/main/section/div/div/div/div/div/div/div/div[2]/div/div/div/h5")
	private WebElement amounttype;   
	
	@FindBy(xpath = "/html/body/main/section/div/div/div/div/div/div/div/div[2]/div/div/div/h2")
	private WebElement totalamountpay;                  //main
	
	public void verifyprofile(WebDriver driver) throws InterruptedException
	{
		
		Actions act=new Actions(driver);
		act.moveToElement( profilename).perform();
		act.click().perform();
		profile.click();
		Thread.sleep(2000);
		
		String history = searchhistory.getText();
		System.out.println("Title on profile page:"+history);
		
		Thread.sleep(2000);
		String nameofuser = username.getText();
		System.out.println("Name of user at profile page:"+nameofuser);
		
		Thread.sleep(2000);
		String details = userdetails.getText();
		System.out.println("Details of user on profile page:"+details);
		
		Thread.sleep(2000);
		String type = amounttype.getText();
		System.out.println("Subscription Type of user :"+type);
		
		Thread.sleep(2000);
		String pay = totalamountpay.getText();
		System.out.println("Pay of total amount :"+pay);

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
		}
}}
