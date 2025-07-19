package Pomclass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Trashofmynote extends BasePage1 {

	public Trashofmynote(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id=\"navbarsExampleDefault\"]/ul/li/a")
	private WebElement profilename;                  //main searchbar text
	
	@FindBy(linkText = "My Notes")         //searchbtn
	private WebElement mynotes;
	
	@FindBy(id = "trashBtn")    //showentires selectclass       
	private WebElement trashbtn;
	
	@FindBy(xpath = "//*[@id=\"trashTable_length\"]/label/select")    //select class       
	private WebElement showentries;
	
	@FindBy(xpath ="(//a[@data-target='#showNotebookNote'])[1]")    //      add title
	private WebElement firstnoteoftrash;
	
	@FindBy(xpath = "//*[@id=\"notedescription\"]")    //hereuse iframe   
	private WebElement notedescription ;

	
	@FindBy(id = "notedate")     
	private WebElement dateofnote;

	
	@FindBy(xpath = "//button[@id='cancel']")     
	private WebElement canclebtn;

	@FindBy(xpath = "//*[@id=\"trashTable_filter\"]/label/input")      //verify added note of user
	private WebElement searchfilter;


	@FindBy(xpath = "(//i[@title='Restore'])[1]")      //edit note btn
	private WebElement undobtnarrow;

	@FindBy(xpath = "//*[@id=\"trash\"]/div/div/div[2]/p")      //delete note btn
	private WebElement textonundotrash;

	@FindBy(xpath = "//*[@id=\"trash\"]/div/div/div[3]/button[2]")      //print note
	private WebElement undotrashbtn;

	
	@FindBy(xpath = "//*[@id=\"note5799\"]/td[4]/a/i")      //sharenote 
	private WebElement deleteofaction;
	
	
	@FindBy(xpath = "//*[@id=\"deletemodal12\"]/div/div/div[3]/button[2]")      //move note to notebook
	private WebElement deletebtn;
	
	

	@FindBy(xpath = "//*[@id=\"trashTable_paginate\"]/ul/li[3]/a")      //paginationverificatiion
	private WebElement pageno2;
	
	

	@FindBy(xpath = "//*[@id=\"trashTable_next\"]")      //move note to notebook
	private WebElement nextbtnpage;
	

	@FindBy(xpath = "//*[@id=\"trashTable_paginate\"]/ul/li[4]/a")      //move note to notebook
	private WebElement pageno3;

	
	public void verifynewnote(WebDriver driver) throws InterruptedException
	{
		
		Actions act=new Actions(driver);
		act.moveToElement( profilename).perform();
		Thread.sleep(3000);
		
		mynotes.click();
		Thread.sleep(2000);
		
		
		trashbtn.click();
		Thread.sleep(2000);
		
			int rowcount = driver.findElements(By.xpath("//table[@id='trashTable']/tbody/tr")).size();
			System.out.println("No of rows:"+rowcount);
			
			int column = driver.findElements(By.xpath("//table[@id='trashTable']/tbody/tr[1]/td")).size();
			System.out.println("No of column:"+column);
			for(int i=1;i<=rowcount;i++)
			{
				for(int j=1;j<=column;j++)
				{
					String text = driver.findElement(By.xpath("//table[@id='trashTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
					System.out.println(text);
				}
			}

			Thread.sleep(2000);
			
	}
	public void trashfeature() throws InterruptedException {
		
			Select entries= new Select(showentries);
			entries.selectByIndex(1);
			Thread.sleep(2000);
			
			entries.selectByIndex(0);
			Thread.sleep(2000);

			firstnoteoftrash.click();
			Thread.sleep(2000);
			
			String description = notedescription.getText();
			System.out.println("Description of added note:"+description);
			Thread.sleep(2000);
			
			String date = dateofnote.getText();
			System.out.println("date of added note:"+date);
			Thread.sleep(2000);
			
			canclebtn.click();
			Thread.sleep(2000);
			
		
	}

			
	
}
