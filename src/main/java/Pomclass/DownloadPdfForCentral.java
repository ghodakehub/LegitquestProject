package Pomclass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DownloadPdfForCentral extends BasePage1 {

	public DownloadPdfForCentral(WebDriver driver) {
		super(driver);
	}
	 
	 
	 @FindBy(xpath = "(//button[@class='btn btn-warning latest-case-link btn-sm d-flex align-items-center'])[2]")
		private WebElement ClickActlistbtn;
		
	 @FindBy(xpath = "//*[@id=\"centralList\"]")
		private WebElement CentralList;
		
	 
	 @FindBy(xpath = "//select[@id='recordType']")
	    private WebElement typeDropdown;

	   
	    @FindBy(xpath = "//a[contains(text(),'Download')]")
	    private List<WebElement> downloadButtons;

	    
	    public void openActListPage() throws InterruptedException {
	    	ClickActlistbtn.click();
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    	WebElement centralTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'CENTRAL LIST')]")));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", centralTab);
	    	}

	    public void selectActType(String type) {
	        new org.openqa.selenium.support.ui.Select(typeDropdown).selectByVisibleText(type);
	    }

	    public WebElement getFirstDownloadButton() {
	        return downloadButtons.isEmpty() ? null : downloadButtons.get(0);
	    }

	    public List<WebElement> getDownloadButtons() {
	        return downloadButtons;
	    }

	    public void clickDownloadButton(WebElement button) {
	        button.click();
	    }
	}


