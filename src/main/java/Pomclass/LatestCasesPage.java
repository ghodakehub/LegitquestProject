package Pomclass;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import UtilityClass.UtilityClass;
import generic.ForMultiplemailReceipent;
import generic.Library;

public class LatestCasesPage extends BasePage1 {

	public LatestCasesPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (xpath="/html/body/div[3]/main/a[1]/button") 
	private WebElement latestcasebtn;
	    @FindBy(xpath = "//a[contains(text(),'Supreme Court')]")
	    private WebElement supremeTab;

	    @FindBy(xpath = "//a[contains(text(),'High Court')]")
	    private WebElement highCourtTab;

	    @FindBy(xpath = "//a[contains(text(),'Tribunal')]")
	    private WebElement tribunalTab;

	    @FindBy(xpath = "//select[@id='daysFilter']")
	    private WebElement daysFilterDropdown;

	    @FindBy(xpath = "//option[text()='7 Days']")
	    private WebElement sevenDaysOption;

	    @FindBy(xpath = "//div[contains(@class,'card-body')]")
	    private List<WebElement> judgmentCards;

	    public void highourtcases(WebDriver driver) throws InterruptedException
		{
			
			 
			
	     Library.click(driver,latestcasebtn , "Clicked on ClickActlistbtn");
	 		
			Library.threadSleep(2000);
		}

	    public void checkLatestCourtJudgments() throws InterruptedException, MessagingException, IOException {
	       
	        driver.get("https://www.legitquest.com/latest-court-judgments");

	        Thread.sleep(5000); 

	        WebElement filterDropdown = driver.findElement(By.xpath("//select[@id='date_filter']"));
	        Select select = new Select(filterDropdown);
	        select.selectByVisibleText("30 Days");

	        Thread.sleep(2000); // Wait for refresh

	        String[] tabs = {"Supreme Court", "High Court", "Tribunal"};
	        boolean isError = false;
	        StringBuilder errorTabs = new StringBuilder();

	        for (String tab : tabs) {
	            
	            WebElement tabElement = driver.findElement(By.xpath("//a[contains(text(),'" + tab + "')]"));
	            tabElement.click();

	            Thread.sleep(3000);

	           
	            List<WebElement> caseList = driver.findElements(By.xpath("//div[contains(@class,'card-body p-4')]"));

	            if (caseList.isEmpty()) {
	                isError = true;
	                errorTabs.append(tab).append(", ");
	            }
	        }

	        if (isError) {
	            String screenshotPath = UtilityClass.Capaturescreenshot(driver, "No_Cases_Visible");

	            ForMultiplemailReceipent.sendEmail(
	                driver,
	                new String[]{"ghodake6896@gmail.com"},
	                "No Judgments Found in One or More Tabs",
	                "No judgments were visible in the following tabs: " + errorTabs.toString(),
	                screenshotPath,
	                driver.getCurrentUrl()
	            );
	        } else {
	            System.out.println("✅ All tabs are showing judgment cases.");
	        }

	        driver.quit();
	    }

	}
