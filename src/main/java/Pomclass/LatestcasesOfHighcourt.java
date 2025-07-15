package Pomclass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import generic.Library;
import generic.SwitchWindow;

public class LatestcasesOfHighcourt extends BasePage1 {

	public LatestcasesOfHighcourt(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath="/html/body/div[3]/main/a[1]/button") private WebElement latestcasebtn;
	@FindBy (xpath="//select[@id='date_filter']") private WebElement datefilterdropdown;
	@FindBy (xpath="//select[@id='sortBy']") private WebElement sortbydropdown;
	@FindBy(xpath="//*[@id=\"court2\"]") private WebElement highcourtbtn;
	@FindBy (xpath="//*[@id=\"select_court\"]") private WebElement selectcourtbtn;
	@FindBy (xpath="//*[@id=\"subCourtValue\"]/div/label/span")private List<WebElement> selectsubcourtoption;
	@FindBy(xpath="//*[@id=\"result\"]/div[2]/div[1]/a") private WebElement subcourtcases;
	
		
	public void highourtcases(WebDriver driver) throws InterruptedException
	{
		
		 
		
     Library.click(driver,latestcasebtn , "Clicked on ClickActlistbtn");
 		
		Library.threadSleep(2000);
		
		
               Library.click(driver,highcourtbtn , "Clicked on highcourt");
 		

                    Library.threadSleep(2000);
		
		String title = driver.getTitle();
		System.out.println(title);
		 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// Scroll into view
		WebElement element = driver.findElement(By.id("select_court"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		// Wait until clickable
		element = wait.until(ExpectedConditions.elementToBeClickable(element));

		// Click the element
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
		
		for(int i=0;i<=selectsubcourtoption.size()-1;i++)
		{
			String allsubcourts = selectsubcourtoption.get(i).getText();
		System.out.println("All subcourts options : "+allsubcourts);
		}
		selectsubcourtoption.get(0).click();
		Thread.sleep(2000);
		try {
			subcourtcases.click();
		} catch (StaleElementReferenceException e) {
		   //element = driver.findElement(By.xpath("//*[@id=\"result\"]/div[2]/div[1]/a"));
			subcourtcases.click();
		}
		// Window switch
				SwitchWindow.switchWindowByIndex(driver, 2);
				Thread.sleep(3000);
				
				// Window switch
				SwitchWindow.switchWindowByIndex(driver, 1);
				Thread.sleep(3000);
				
		selectsubcourtoption.get(1).click();
		
		

	}
	
	
}
