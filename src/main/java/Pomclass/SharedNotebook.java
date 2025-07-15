package Pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class SharedNotebook extends BasePage1 {

	public SharedNotebook(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id=\"navbarsExampleDefault\"]/ul/li/a")
	private WebElement profilename;                  //main searchbar text
	
	@FindBy(linkText = "My Notes")         //searchbtn
	private WebElement mynotes;
	
	@FindBy(id = "notebookBtn")         //cick on added note of user
	private WebElement notebookbtn;
	
	@FindBy(xpath = "//*[@id=\"myTable\"]/tr[2]/td[1]")         //text of user add in note
	private WebElement clickonaddednotebook;


	@FindBy(xpath = "//*[@id=\"myTable\"]/tr[1]/td[3]/i[2]")      //sharenote 
	private WebElement deletebtn;

	
	@FindBy(xpath = "//*[@id=\"deletenotebook\"]/div/div/div[2]/p")      //sharenote 
	private WebElement waringondeletepop;
	
	@FindBy(xpath = "//*[@id=\"deletenotebook\"]/div/div/div[3]/button[2]")      //sharenote 
	private WebElement deletbtnpop;

	
	@FindBy(xpath = "//*[@id=\"sharedNoteBooks\"]")      //add note under notebook
	private WebElement sharednotebookbtn;

	@FindBy(xpath = "//*[@id=\"sharenotebook100\"]/td[1]")      
	private WebElement clickonsharednotebook;

	@FindBy(xpath = "//*[@id=\"demoShare0\"]/ul/li")     
	private WebElement addednoteundernotebook;
	
	
	@FindBy(xpath = "//*[@id=\"caseURL\"]")     
	private WebElement titleofaddednote;

	
	@FindBy(xpath = "//*[@id=\"notedescription\"]")    
	private WebElement textundernote;
	
	@FindBy(xpath = "//*[@id=\"notedate\"]")     
	private WebElement createddate;

	
	@FindBy(xpath = "//*[@id=\"cancel\"]")      
	private WebElement canclebtn;
	
	
	@FindBy(xpath = "//*[@id=\"myInputShare\"]")     
	private WebElement findsharednotebook;
	
	
	public void verifynotebookfunction(WebDriver driver) throws InterruptedException
	{
		
		Actions act=new Actions(driver);
		act.moveToElement( profilename).perform();
		Thread.sleep(3000);
		
		mynotes.click();
		Thread.sleep(2000);
		
		notebookbtn.click();
		Thread.sleep(2000);
		
		deletebtn.click();
		Thread.sleep(2000);
		
		String textwarning = waringondeletepop.getText();
		System.out.println("warnig text on delete pop:"+textwarning);
		Thread.sleep(2000);

		deletbtnpop.click();
		Thread.sleep(2000); 
		
		sharednotebookbtn.click();

		Thread.sleep(2000); 
		
		clickonsharednotebook.click();
		Thread.sleep(2000); 
		
		addednoteundernotebook.click();
		Thread.sleep(2000); 
		
		String title=	titleofaddednote.getText();
		System.out.println("title note:"+title);
		Thread.sleep(2000); 
		
		String textmsg=	textundernote.getText();
		System.out.println("text in note:"+textmsg);
		Thread.sleep(2000); 
		
		String  datecreate=	createddate.getText();
		System.out.println("date of note:"+datecreate);
		Thread.sleep(2000); 
		
		canclebtn.click();
		Thread.sleep(2000); 
		
		findsharednotebook.sendKeys("Vaibhav123");
		Thread.sleep(2000); 
		
		
		
	}
	}
