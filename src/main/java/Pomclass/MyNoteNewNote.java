package Pomclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


import UtilityClass.Library;

public class MyNoteNewNote extends BasePage1 {

	public MyNoteNewNote(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath = "(//*[@id=\"firstname\"]/strong)[2]")
	private WebElement profilename;                  //main searchbar text
	
	@FindBy(linkText = "My Notes")         //searchbtn
	private WebElement mynotes;
	
	@FindBy(xpath = "//*[@id=\"newNoteBtn\"]")    //showentires selectclass       
	private WebElement newnotebtn;
	
	@FindBy(id = "notebook_id")    //select class       
	private WebElement selectnote;
	
	@FindBy(xpath = "//input[@id='title']")    //      add title
	private WebElement titlename;
	
	@FindBy(xpath = "/html/body/p")    //hereuse iframe   
	private WebElement addDescription;

	
	@FindBy(xpath = "//*[@id=\"add-notes\"]/div/div/div[3]/button[2]")     
	private WebElement addnotebtn;

	
	@FindBy(xpath = "//*[@id=\"noteTab\"]/div/div[1]/h5")     
	private WebElement addednote;

	@FindBy(xpath = "//*[@id=\"noteTab\"]/div/div[1]/div")      //verify added note of user
	private WebElement dateofaddednote;


	@FindBy(xpath = "//*[@id=\"result\"]/div[2]/div/div[2]/i[1]")      //edit note btn
	private WebElement editnote;

	@FindBy(xpath = "//*[@id=\"result\"]/div[2]/div/div[2]/i[2]")      //delete note btn
	private WebElement deltennote;

	@FindBy(xpath = "//*[@id=\"result\"]/div[2]/div/div[2]/i[3]")      //print note
	private WebElement printnote;

	
	@FindBy(xpath = "//*[@id=\"result\"]/div[2]/div/div[2]/i[4]")      //sharenote 
	private WebElement sharenote;
	
	
	@FindBy(xpath = "//*[@id=\"result\"]/div[2]/div/div[2]/i[5]")      //move note to notebook
	private WebElement movenote;
	
	

	@FindBy(xpath = "//*[@id=\"editnotetitle\"]")      //move note to notebook
	private WebElement editnotetitle;
	
	

	@FindBy(xpath = "//div[@id='cke_3_contents']")      //move note to notebook
	private WebElement descriptionundereditnote;
	

	@FindBy(xpath = "//*[@id=\"editnotedate\"]")      //move note to notebook
	private WebElement editnotedate;

	@FindBy(xpath = "//*[@id=\"updatebtn\"]")      //update button of edit note pop
	private WebElement updatebtn;
	
	@FindBy(xpath = "//*[@id=\"successmessage\"]")      //update message of note
	private WebElement messageupdate;
	
	
	@FindBy(xpath = "//*[@id=\"cancelbtn\"]")      //update button of edit note pop
	private WebElement closebtn;

	
	public void verifynewnote(WebDriver driver) throws InterruptedException
	{
		
		Actions act=new Actions(driver);
		act.moveToElement( profilename).perform();
		Thread.sleep(3000);
		
		mynotes.click();
		Thread.sleep(2000);
		
		newnotebtn.click();
		Thread.sleep(2000);
		
		selectnote.click();
		Select notes= new Select(selectnote);
		notes.selectByVisibleText("ImpNotebook1");
		Thread.sleep(2000);
		
		titlename.sendKeys("Automation test2");
		Thread.sleep(2000);

	driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"cke_3_contents\"]/iframe")));
	//addDescription.click();
	Library.sendKeys(driver, addDescription, "enter description", "Verifying add new note funcitonality by autoamtion script");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		
		addnotebtn.click();
		Thread.sleep(2000);
		
		 String text=addednote.getText();
		 System.out.println("Title of added not by user:"+text);
		Thread.sleep(2000);
		
	
		 String text1=dateofaddednote.getText();
		 System.out.println("verify date of added note by user:"+text1);
		Thread.sleep(2000);

		
}
}