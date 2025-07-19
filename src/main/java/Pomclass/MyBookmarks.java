package Pomclass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.CommonVerification;

public class MyBookmarks extends BasePage1 {

	public MyBookmarks(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//*[@id=\"firstname\"]/strong)[2]")
	private WebElement profilename;                  //main searchbar text
	
	@FindBy(linkText = "My Bookmarks")         //searchbtn
	private WebElement mybookmarks;
	
	@FindBy(xpath = "//*[@id=\"bookmarkTable_length\"]/label/select")    //showentires selectclass       
	private WebElement showentries;
	
	@FindBy(xpath = "//*[@id=\"bookmarkTable\"]/tbody/tr[1]/td[3]/a/i")    //showentires selectclass       
	private WebElement deletebtn;
	
	@FindBy(xpath = "//*[@id=\"deletebookmark\"]/div/div/div[2]/button[2]")    //showentires selectclass       
	private WebElement deletebtnpop;
	
	@FindBy(xpath = "//*[@id=\"loader_message6\"]")    //showentires selectclass       
	private WebElement deletemessage;

	
	public List<String> validateBookmarks(WebDriver driver) throws InterruptedException {
			Actions act=new Actions(driver);
			act.moveToElement( profilename).perform();
			Thread.sleep(3000);
			mybookmarks.click();
			 List<String> brokenUrls = new ArrayList<>();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    String originalTab = driver.getWindowHandle();

		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='My Bookmarks']")));

		   
		    List<WebElement> links = driver.findElements(By.xpath("//table//tr/td[2]/a"));

		    for (int i = 0; i < links.size(); i++) {
		        WebElement link = driver.findElements(By.xpath("//table//tr/td[2]/a")).get(i);
		        String titleText = link.getText();
		        System.out.println("Checking link: " + titleText);
		        Thread.sleep(2000);
		 
		        String clickScript = "window.open(arguments[0].href,'_blank');";
		        ((JavascriptExecutor) driver).executeScript(clickScript, link);

		  
		        wait.until(driver1 -> driver.getWindowHandles().size() > 1);
		        Set<String> allTabs = driver.getWindowHandles();
		        for (String tab : allTabs) {
		            if (!tab.equals(originalTab)) {
		                driver.switchTo().window(tab);
		                if (CommonVerification.isErrorPage(driver)) {
       	                    brokenUrls.add(driver.getCurrentUrl());
       	                }
		                break;
		            }
		        }
		        driver.close();
		        Thread.sleep(3000);
		        driver.switchTo().window(originalTab);
		    }
		    Thread.sleep(3000);
			return brokenUrls;
	
	}

	public void verifytbale(WebDriver driver)
	{
		int rowcount = driver.findElements(By.xpath("//*[@id=\"bookmarkTable\"]/tbody/tr")).size();
		System.out.println("No of rows:"+rowcount);
		
		int column = driver.findElements(By.xpath("//*[@id=\"bookmarkTable\"]/tbody/tr[1]/td")).size();
		System.out.println("No of column:"+column);
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=1;j<=column;j++)
			{
				String text = driver.findElement(By.xpath("//*[@id=\"bookmarkTable\"]/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.println(text);
			}
		}

			
	}
}
