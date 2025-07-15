package Pomclass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import UtilityClass.Library;
import generic.CommonVerification;
import generic.PaginationsUtility;
import generic.SwitchWindow;

public class BlogPaginations extends BasePage1 {

	public BlogPaginations(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(linkText = "Blog")   //blog contact footer option verify pages
	private WebElement blog;
	
	@FindBy(xpath = "/html/body/main/section[2]/div/div/ul/li[3]/a")
	private WebElement page2;
	
	@FindBy(xpath = "/html/body/main/section[2]/div/div/ul/li[4]/a")
	private WebElement page3;
	
	@FindBy(xpath = "/html/body/main/section[2]/div/div/ul/li[5]/a")
	private WebElement page4;
	
	@FindBy(xpath = "/html/body/main/section[2]/div/div/ul/li[6]/a")
	private WebElement page5;
	
	@FindBy(xpath = "/html/body/main/section[2]/div/div/ul/li[7]/a")
	private WebElement page6;
	
	@FindBy(xpath = "/html/body/main/section[2]/div/div/ul/li[8]/a")
	private WebElement page7;
	

	@FindBy(linkText = "Environment Laws In India")   
	private WebElement bloglink;
	
	@FindBy(linkText = " Wildlife Protection Act 1972")   
	private WebElement bloglink1;
	
	
	
	
	public List<String> checkBlogsFor404(WebDriver driver) throws InterruptedException {
		blog.click();
		Thread.sleep(2000);
    	List<String> brokenUrls = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.legitquest.com/legal-guide");
	    String mainWindow = driver.getWindowHandle();
	    int totalPages = 15; 
	    
	    for (int page = 1; page <= totalPages; page++) {
	        System.out.println("Checking Page: " + page);
	        
	      
	        List<WebElement> actLinks = driver.findElements(By.xpath("//a[contains(@href,'/legal-guide/')]"));

            for (int i = 0; i < actLinks.size(); i++) {
                actLinks = driver.findElements(By.xpath("//a[contains(@href,'/legal-guide/')]"));
                WebElement actLink = actLinks.get(i);

                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", actLink);
                Thread.sleep(1500);
                actLink.click();

                wait.until(driver1 -> driver.getWindowHandles().size() > 1);
                Set<String> allWindows = driver.getWindowHandles();
                for (String win : allWindows) {
                    if (!win.equals(mainWindow)) {
                        driver.switchTo().window(win);
                        break;
                    }
                }

                if (CommonVerification.isErrorPage(driver)) {
  	              brokenUrls.add(driver.getCurrentUrl());
  	               
  	            }

                driver.close();
                driver.switchTo().window(mainWindow);
                Thread.sleep(1500);
            }

	        
	        if (page < totalPages) {
	            try {
	                WebElement nextPage = driver.findElement(By.xpath("//a[text()='" + (page + 1) + "']"));
	                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextPage);
	                nextPage.click();
	                Thread.sleep(2000);
	            } catch (Exception e) {
	                System.out.println("error click page on this page: " + (page + 1));
	            }
	        }
	      
        }

        return brokenUrls;
    }
	    
	}

	
	
	

