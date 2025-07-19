package Pomclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import UtilityClass.Library;

public class SelectLaunguage extends BasePage1 {

	public SelectLaunguage(WebDriver driver) {
		super(driver);
	}


	
	@FindBy(xpath = "//input[@id='search']") // Main Search Box
	private WebElement searchbox;

	@FindBy(xpath = "//div[@class='search-btn']") // Main Search Icon (Button)
	private WebElement SearchButton;

	@FindBy(xpath = "//*[@id=\"select-dropdown\"]/div/div/ul/li[1]/div/div/label/span") // All
	private WebElement Allmenu;

	@FindBy(xpath = "//*[@id=\"bycourt\"]/li[1]/div/label/span") // supreme court
	private WebElement supremecourt;
	
	@FindBy(xpath ="//img[@title='Vernacular Translation']") // supreme court
	private WebElement Clickonlaunge;
	
	@FindBy(xpath = "//*[@id=\":0.targetLanguage\"]/select") // supreme court
	private WebElement launguage;
	
	@FindBy(id=":1.restore")
	private WebElement showoriginalbtn;
	
	
	
	public void selectlanguage(WebDriver driver) throws InterruptedException
	{
		
		Library.waitForVisibilityOf(driver, searchbox);
		Library.sendKeys(driver, searchbox, "Enter text in search bar Ram", "ram");
		Library.threadSleep(3000);
	
	
		//Library.waitForVisibilityOf(driver, SearchButton);
		Library.click(driver,SearchButton , "click on searchbtn");
		Library.threadSleep(3000);
		
	
	
	Actions act= new Actions(driver);
	act.moveToElement(Clickonlaunge).build().perform();
	Library.threadSleep(3000);

	launguage.click();
	
	Thread.sleep(2000);
Select optact= new Select(launguage);

optact.selectByIndex(3);

Library.threadSleep(4000);

optact.selectByVisibleText("Marathi");
Library.threadSleep(2000);


driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id=':1.container']")));
Library.threadSleep(2000);
Library.click(driver,showoriginalbtn , "click on showoriginalbtn");
//Library.threadSleep(3000);


/*List<WebElement>alloptionact=optact.getOptions();
for(WebElement actslist:alloptionact)
{
	if(actslist.getText().equals("Hindi"))
	{
		actslist.click();
		break;
	}
}	*/




	
	}

}
