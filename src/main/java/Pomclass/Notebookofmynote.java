package Pomclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import UtilityClass.Library;

public class Notebookofmynote extends BasePage1 {

	public Notebookofmynote(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath = "//*[@id=\"navbarsExampleDefault\"]/ul/li/a")
	private WebElement profilename;                  //main searchbar text
	
	@FindBy(linkText = "My Notes")         //searchbtn
	private WebElement mynotes;
	
	@FindBy(id = "notebookBtn")         //cick on added note of user
	private WebElement notebookbtn;
	
	@FindBy(xpath = "//*[@id=\"myTable\"]/tr[1]/td[1]")         //text of user add in note
	private WebElement clickonaddednotebook;
	
	
	@FindBy(xpath = "//*[@id=\"demo0\"]/ul/li")      //edit note b 
	private WebElement noteundernotebook;

	@FindBy(xpath = "//*[@id=\"notedescription\"]")      
	private WebElement titleofnote;

	@FindBy(xpath = "//*[@id=\"notedate\"]")      
	private WebElement dateofnote;

	@FindBy(xpath = "//*[@id=\"notedescription\"]")      //*[@id="notebooknotetitle"]
	private WebElement notbookdescription;

	@FindBy(xpath = "//*[@id=\"cancel\"]")      
	private WebElement canclebtn;
	

	@FindBy(xpath = "//*[@id=\"myInput\"]")       
	private WebElement findnotebook;
	
	
	@FindBy(xpath = "//*[@id=\"myTable\"]/tr[2]/td[1]")       
	private WebElement nootebookfind;                              //*[@id="myTable"]/tr[10]/td[1]
	
	@FindBy(xpath = "//*[@id=\"myTable\"]/tr[1]/td[3]/i[1]")       
	private WebElement createnewnotebook;
	
	@FindBy(xpath = "//*[@id='notebooknotetitle']")      
	private WebElement notebookname;
	
	
	@FindBy(xpath = "/html/body/p")      
	private WebElement descriptionofnotebook;

	@FindBy(xpath = "//*[@id=\"add-notes-directly-notebook\"]/div/div/div[3]/button[2]")       
	private WebElement submitbtn;

	
	public void verifynotebookfunction(WebDriver driver) throws InterruptedException
	{
		
		Actions act=new Actions(driver);
		act.moveToElement( profilename).perform();
		Thread.sleep(3000);
		
		mynotes.click();
		Thread.sleep(2000);
		
		notebookbtn.click();
		Thread.sleep(2000);
		
		clickonaddednotebook.click();
		Thread.sleep(2000);
		
		noteundernotebook.click();
		Thread.sleep(2000);
		
		String notetitle= titleofnote.getText();
		System.out.println("Title of added note under notebook:"+notetitle);
		Thread.sleep(2000);	
		
		String date= dateofnote.getText();
		System.out.println("date od note under notebook:"+date);
		Thread.sleep(2000);	
		

		String descript= notbookdescription.getText();
		System.out.println("Title of added note under notebook:"+descript);
		Thread.sleep(2000);	
		
		canclebtn.click();
		Thread.sleep(2000);
		
		findnotebook.sendKeys("ImpNotebook1");
		Thread.sleep(2000);
		
	/*	nootebookfind.click();
		Thread.sleep(2000);
		
	   WebElement Addnoteinside = driver.findElement(By.xpath("//*[@id=\"myTable\"]/tr[2]/td[3]/i[1]"));
		Addnoteinside.click();
		Thread.sleep(2000);
		
		notebookname.sendKeys("Test1");
		Thread.sleep(2000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"cke_2_contents\"]/iframe")));
		
		Library.sendKeys(driver,descriptionofnotebook , " Add description in notebook ", "Hi , here I am adding case for High court cases under  created notebook");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		submitbtn.click();  */
		
	}
	public void verifytbale(WebDriver driver)
	{
		int rowcount = driver.findElements(By.xpath("//*[@id=\"selectNotebook\"]/tbody/tr[1]")).size();
		System.out.println("No of rows:"+rowcount);
		
		int column = driver.findElements(By.xpath("//*[@id=\"selectNotebook\"]/tbody/tr[1]/td")).size();
		System.out.println("No of column:"+column);
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=1;j<=column;j++)
			{
				String text = driver.findElement(By.xpath("//*[@id=\"selectNotebook\"]/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.println(text);
			}
		}

}
}