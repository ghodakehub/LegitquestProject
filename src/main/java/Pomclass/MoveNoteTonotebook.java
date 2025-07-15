package Pomclass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoveNoteTonotebook extends BasePage1 {

	public MoveNoteTonotebook(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//*[@id=\"firstname\"]/strong)[2]")
	private WebElement profilename;               
	
	@FindBy(linkText = "My Notes")        
	private WebElement mynotes;
	
	@FindBy(xpath = "//*[@id=\"noteTab\"]/div/div[2]/h5")        
	private WebElement noteofadded;
	
	@FindBy(xpath = "//*[@id=\"result\"]/div[2]/div")         
	private WebElement textofaddednote;
	


	
	@FindBy(xpath = "//*[@id=\"result\"]/div[2]/div/div[2]/i[4]")      
	private WebElement sharenote;
	
	
	@FindBy(xpath = "//*[@id=\"result\"]/div[2]/div/div[2]/i[5]")      //move note to notebook
	private WebElement movenote;
	
	@FindBy(xpath = "//*[@id=\"selectNotebook\"]/tbody/tr[1]/td[1]/input")      //select notebook where to move note mail
	private WebElement selectnotebook;
	
	
	@FindBy(xpath = "//*[@id=\"movenotemodal\"]/div/div/div[3]/button[1]")      //select notebook where to move note mail
	private WebElement movebtn;
	

		// Actions 	
			public void noteshare(WebDriver driver) throws InterruptedException {
				
				Actions act=new Actions(driver);
				act.moveToElement( profilename).perform();
				Thread.sleep(3000);
				
				mynotes.click();
				Thread.sleep(2000);
				

				JavascriptExecutor js1 = (JavascriptExecutor)driver;
				js1.executeScript("arguments[0].click();", noteofadded);
				Thread.sleep(4000);
				
				
				String textnote = textofaddednote.getText();
				System.out.println("Matter of add in new note  by user is :"+textnote);
				   
				
				JavascriptExecutor js2 = (JavascriptExecutor) driver;
				js2.executeScript("arguments[0].click();", movenote);
				Thread.sleep(4000);
				
				selectnotebook.click();
				Thread.sleep(2000);
				movebtn.click();
			}
			

			public void verifytbale(WebDriver driver)
			{
				int rowcount = driver.findElements(By.xpath("//*[@id=\"selectNotebook\"]/tbody/tr")).size();
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