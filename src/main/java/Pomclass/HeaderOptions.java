package Pomclass;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import generic.SwitchWindow;

public class HeaderOptions extends BasePage1 {

	public HeaderOptions(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath = "/html/body/div[1]/header/nav/div/div[1]/ul[1]/li[2]/a") ///company
	private WebElement company;

	@FindBy(xpath = "/html/body/header/nav/div/div[1]/ul[1]/li[2]/ul/li[1]/a")
	private WebElement aboutlegitquest;

	@FindBy(xpath = "/html/body/header/nav/div/div[1]/ul[1]/li[2]/ul/li[2]/a")
	private WebElement ourteam;
		
	@FindBy(xpath = "/html/body/header/nav/div/div[1]/ul[1]/li[2]/ul/li[3]/a")
	private WebElement career;
	
	@FindBy(xpath="/html/body/header/nav/div/div[1]/ul[1]/li[2]/ul/li[4]/a")
	private WebElement contact;
	

	public void verifyheadersoptions() throws InterruptedException
	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        
        WebElement enterKeyword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
        enterKeyword.sendKeys("The");
        enterKeyword.sendKeys(Keys.ENTER);

       
        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='0']/div/div/a/u")));
        firstResult.click();
        Thread.sleep(4000); 
        SwitchWindow.switchWindowByIndex(driver, 2);
		Thread.sleep(3000);
		
	}
	public void verifySelectedHeaderDropdownOptions(WebDriver driver) throws InterruptedException {
	    Actions actions = new Actions(driver);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Define which headers and dropdowns you want to test
	    Map<String, List<String>> headerWithDropdowns = new HashMap<>();
	    headerWithDropdowns.put("Company", Arrays.asList("About Legitquest", "Our Team","Career","Contact US"));
	    headerWithDropdowns.put("Products", Arrays.asList("Download for Punjab and Haryana Judiciary"));
	    headerWithDropdowns.put("Home", Collections.emptyList());
	    headerWithDropdowns.put("Pricing ",Collections.emptyList());
	    headerWithDropdowns.put("Latest Cases ", Collections.emptyList());
	    headerWithDropdowns.put("Legiteye", Collections.emptyList());
	    headerWithDropdowns.put("Pratiksha Ghodake", Arrays.asList("Profile","My Packages","My Bookmarks","My Notes","Logout"));
	   

	    List<WebElement> headers = driver.findElements(By.xpath("//header/nav/div/div[1]/ul/li/a"));
	    int headerCount = headers.size();

	    for (int i = 1; i <= headerCount; i++) {
	        String headerXPath = "(//header/nav/div/div[1]/ul/li)[" + i + "]/a";
	        WebElement header = driver.findElement(By.xpath(headerXPath));
	        String headerText = header.getText().trim();

	        if (!headerWithDropdowns.containsKey(headerText)) continue; // skip unlisted headers

	        System.out.println("Checking header: " + headerText);
	        actions.moveToElement(header).perform();
	        Thread.sleep(1000); 

	        String dropdownXPath = "(//header/nav/div/div[1]/ul/li)[" + i + "]/ul/li/a";
	        List<WebElement> dropdownItems = driver.findElements(By.xpath(dropdownXPath));

	        for (int j = 1; j <= dropdownItems.size(); j++) {
	            String itemXPath = "(" + dropdownXPath + ")[" + j + "]";
	            WebElement item = driver.findElement(By.xpath(itemXPath));
	            String itemText = item.getText().trim();

	            if (!headerWithDropdowns.get(headerText).contains(itemText)) continue;

	            System.out.println(" → Clicking: " + itemText);
	            wait.until(ExpectedConditions.elementToBeClickable(item)).click();
	            driver.navigate().back(); 

	            // Re-hover header again after navigating back
	            header = driver.findElement(By.xpath(headerXPath));
	            actions.moveToElement(header).perform();
	            Thread.sleep(1000);
	        }
	    }
	}

}
