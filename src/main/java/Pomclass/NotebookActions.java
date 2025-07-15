package Pomclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import UtilityClass.Library;

public class NotebookActions extends BasePage1 {

	public NotebookActions(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath = "(//*[@id=\"firstname\"]/strong)[2]")
	private WebElement profilename;                  //main searchbar text
	
	@FindBy(linkText = "My Notes")         //searchbtn
	private WebElement mynotes;
	
	@FindBy(id = "notebookBtn")         //cick on added note of user
	private WebElement notebookbtn;
	
	@FindBy(xpath = "//*[@id=\"myTable\"]/tr[2]/td[1]")         //text of user add in note
	private WebElement clickonaddednotebook;
	
	
	@FindBy(xpath = "//*[@id=\"myTable\"]/tr[1]/td[3]/i[1]")      //add note under notebook
	private WebElement addnewnote;

	@FindBy(xpath = "//*[@id=\"notebooknotetitle\"]")      //delete note btn
	private WebElement titleofnote;

	@FindBy(xpath = "/html/body/p")      //print note
	private WebElement descriptionofnote;

	@FindBy(xpath = "//*[@id=\"add-notes-directly-notebook\"]/div/div/div[3]/button[2]")      //print note
	private WebElement addnotebtn;

	@FindBy(xpath = "//*[@id=\"myTable\"]/tr[1]/td[3]/i[3]")      //sharenote 
	private WebElement renamenotebookbtn;
	

	@FindBy(id = "editnotebookname")      //sharenote 
	private WebElement enterrenamenotebook;
	
	
	@FindBy(xpath = "//*[@id=\"editNotebookModel\"]/div/div/div[3]/button[2]")      //sharenote 
	private WebElement updatebtn;
	
	@FindBy(xpath = "//*[@id=\"myTable\"]/tr[1]/td[3]/i[4]")      //sharenote 
	private WebElement sharenotebookbtn;
	
	@FindBy(xpath = "//*[@id=\"notebookemail\"]")      //sharenote 
	private WebElement enteremail;
	
	@FindBy(xpath = "//*[@id=\"shareNoteBookModal\"]/div/div/div[3]/button[2]")      //sharenote 
	private WebElement shrenotebook;
	
	
	@FindBy(xpath = "//*[@id=\"myTable\"]/tr[1]/td[3]/i[2]")      //sharenote 
	private WebElement deletebtn;

	
	@FindBy(xpath = "//*[@id=\"deletenotebook\"]/div/div/div[2]/p")      //sharenote 
	private WebElement waringondeletepop;
	
	@FindBy(xpath = "//*[@id=\"myTable\"]/tr[1]/td[3]/i[2]")      //sharenote 
	private WebElement deletbtnpop;

	
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
		
		addnewnote.click();
		Thread.sleep(2000);
		
		titleofnote.sendKeys("NewTitle1");
		
	driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"cke_4_contents\"]/iframe")));
		
		Library.sendKeys(driver,descriptionofnote , " Add description note of notebook ", "Hi , Here I am verifying Notebook Funcitonaliyt discription");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		addnotebtn.click();
		Thread.sleep(3000);
		
		notebookbtn.click();
		Thread.sleep(2000);
		//clickonaddednotebook.click();
		//Thread.sleep(3000);
		renamenotebookbtn.click();
		Thread.sleep(2000);
		
		enterrenamenotebook.clear();
		Thread.sleep(2000);
		
		enterrenamenotebook.sendKeys("NewNotebook2");
		Thread.sleep(2000);
		
		updatebtn.click();
		Thread.sleep(2000);
		
		notebookbtn.click();
		Thread.sleep(2000);
		
		//clickonaddednotebook.click();
		//Thread.sleep(2000);
		sharenotebookbtn.click();
		Thread.sleep(2000);
		enteremail.sendKeys("ghodake6896@gmail.com");
		Thread.sleep(3000);
		shrenotebook.click();
		Thread.sleep(3000);
		
		

	}
}
