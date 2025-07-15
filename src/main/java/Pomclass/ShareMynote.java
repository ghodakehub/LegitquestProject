package Pomclass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClass.Library;


public class ShareMynote extends BasePage1 {


	public ShareMynote(WebDriver driver) {
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
	

	@FindBy(xpath = "//*[@id=\"result\"]/div[2]/div/div[2]/i[2]")      //delete note btn
	private WebElement deletennote;
	
	@FindBy(xpath = "//*[@id=\"deletemodal1\"]/div/div/div[3]/button[2]")      //delete note btn
	private WebElement deletennotebtn;


	@FindBy(xpath = "//*[@id=\"result\"]/div[2]/div/div[2]/i[3]")      //print note
	private WebElement printnote;

	
	@FindBy(xpath = "//*[@id=\"result\"]/div[2]/div/div[2]/i[4]")      //sharenote 
	private WebElement sharenote;
	
	
	@FindBy(xpath = "//*[@id=\"result\"]/div[2]/div/div[2]/i[5]")      //move note to notebook
	private WebElement movenote;
	
	@FindBy(xpath = "//*[@id=\"selectNotebook\"]/tbody/tr[1]/td[1]/input")      //select notebook where to move note mail
	private WebElement selectnotebook;
	
	
	@FindBy(xpath = "//*[@id=\"movenotemodal\"]/div/div/div[3]/button[1]")      //select notebook where to move note mail
	private WebElement movebtn;
	
	@FindBy(xpath = "//*[@id=\"email\"]")      //share mail
	private WebElement sharemail;
	
	@FindBy(xpath = "//*[@id=\"sharebutton\"]")      //share mail
	private WebElement sharenotebtn;

	
			public void noteshare(WebDriver driver) throws InterruptedException {
				
				Actions act=new Actions(driver);
				act.moveToElement( profilename).perform();
				Thread.sleep(3000);
				
				Library.click(driver, mynotes, "click on Mynotes");
				Thread.sleep(2000);
				

				JavascriptExecutor js1 = (JavascriptExecutor)driver;
				js1.executeScript("arguments[0].click();", noteofadded);
				Thread.sleep(4000);
				
				
				String textnote = textofaddednote.getText();
				System.out.println("Matter of add in new note  by user is :"+textnote);
				   
				deletennote.click();
				Thread.sleep(2000);

				deletennotebtn.click();
				Thread.sleep(2000);
				
				
				JavascriptExecutor js2 = (JavascriptExecutor)driver;
				js2.executeScript("arguments[0].click();", noteofadded);
				Thread.sleep(4000);
				
				printnote.click();
				Thread.sleep(2000);
				sharenote.click();
				Thread.sleep(2000);
				sharemail.sendKeys("ghodake6896@gmail.com");
				Thread.sleep(3000);
				sharenotebtn.click();
				Thread.sleep(2000);
				

				try {
				    Alert alert = driver.switchTo().alert();
				    alert.accept();
				    // Perform actions on the alert
				} catch (NoAlertPresentException e) {
				    // Handle the case when no alert is present
				    System.out.println("No alert present.");
				}
				
	                   Thread.sleep(2000);

			}
			}
