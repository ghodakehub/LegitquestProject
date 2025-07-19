package Pomclass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import UtilityClass.Library;


public class NewNoteOFMynote extends BasePage1 {

	public NewNoteOFMynote(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//*[@id=\"firstname\"]/strong)[2]")
	private WebElement profilename;                  //main searchbar text
	
	@FindBy(linkText = "My Notes")         //searchbtn
	private WebElement mynotes;
	
	@FindBy(xpath = "//*[@id=\"noteTab\"]/div/div[2]/h5")         //cick on added note of user
	private WebElement noteofadded;
	
	@FindBy(xpath = "//*[@id=\"result\"]/div[2]/div")         //text of user add in note
	private WebElement textofaddednote;
	
	
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
	
	

	@FindBy(xpath = "/html/body/p")      //move note to notebook
	private WebElement descriptionundereditnote;
	

	@FindBy(xpath = "//*[@id=\"editnotedate\"]")      //move note to notebook
	private WebElement editnotedate;

	@FindBy(xpath = "//*[@id=\"updatebtn\"]")      //update button of edit note pop
	private WebElement updatebtn;
	
	@FindBy(xpath = "//*[@id=\"successmessage\"]")      //update message of note
	private WebElement messageupdate;
	
	
	@FindBy(xpath = "//*[@id=\"cancelbtn\"]")      //update button of edit note pop
	private WebElement closebtn;


	public void verifyeditnote(WebDriver driver) throws InterruptedException
	{
		
		Actions act=new Actions(driver);
		act.moveToElement( profilename).perform();
		Thread.sleep(3000);
		
		mynotes.click();
		Thread.sleep(2000);
		

		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("arguments[0].click();", noteofadded);
		Thread.sleep(4000);
		
		
		String textnote = textofaddednote.getText();
		System.out.println("Added Matter is :"+textnote);
		
		editnote.click();
		Thread.sleep(3000);
		editnotetitle.sendKeys("Note for test");
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"cke_1_contents\"]/iframe")));
		
		Library.sendKeys(driver, descriptionundereditnote, " Add description ", "Here i am adding text description after editing the added note ");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		updatebtn.click();
		Thread.sleep(2000);
		String mesg = messageupdate.getText();
		System.out.println("Successful Message after Add NewNote :"+mesg);
		Thread.sleep(2000);
		closebtn.click();
		
				
	}
}
