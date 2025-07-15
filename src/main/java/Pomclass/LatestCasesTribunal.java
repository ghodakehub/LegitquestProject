package Pomclass;

import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import generic.SwitchWindow;

public class LatestCasesTribunal extends BasePage1 {

	public LatestCasesTribunal(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath="/html/body/div[3]/main/a[1]/button") private WebElement latestcasebtn;
	@FindBy (xpath="//select[@id='date_filter']") private WebElement datefilterdropdown;
	@FindBy (xpath="//select[@id='sortBy']") private WebElement sortbydropdown;
	@FindBy(xpath="//a[@id='court3']")  private WebElement tribunalbtn;
	@FindBy(xpath="//button[@id='select_court']") private WebElement selectbtn;
	@FindBy(xpath="//ul[@id='resultLi']//li") private List<WebElement> subcourts;
	@FindBy(xpath="//*[@id=\"result\"]/div[2]/div[1]/a") private WebElement selectsubcourtsoption;
	@FindBy(xpath="//*[@id=\"result\"]/div[5]/div[1]/a") private WebElement selectsubcourtsoption1;


	public void latestcasetribunal() throws InterruptedException
	{
		latestcasebtn.click();
		Thread.sleep(2000);
		tribunalbtn.click();
		Thread.sleep(2000);
		selectbtn.click();
		Thread.sleep(2000);
		
		for(int i=0; i<=subcourts.size()-1;i++)
		{
			String listofsubcourts = subcourts.get(i).getText();
			System.out.println("List Of subcourts:"+listofsubcourts);
			
		}
	
		subcourts.get(0).click();
		Thread.sleep(2000);
		try {
			selectsubcourtsoption.click();
		} catch (StaleElementReferenceException e) {
		   // element = driver.findElement(By.id("yourElementId"));
			selectsubcourtsoption.click();
		}
				
		// Window switch
				SwitchWindow.switchWindowByIndex(driver, 2);
				Thread.sleep(3000);
				
				// Window switch
				SwitchWindow.switchWindowByIndex(driver, 1);
				Thread.sleep(3000);
				
		subcourts.get(1).click();
		
		Thread.sleep(2000);
		try {
			selectsubcourtsoption.click();
		} catch (StaleElementReferenceException e) {
		   // element = driver.findElement(By.id("yourElementId"));
			selectsubcourtsoption.click();
		}
		
	}
	
}
