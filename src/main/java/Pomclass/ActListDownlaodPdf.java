package Pomclass;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class ActListDownlaodPdf extends BasePage1 {

	public ActListDownlaodPdf(WebDriver driver) {
		super(driver);
	}
	 
	 
	 @FindBy(xpath = "(//button[@class='btn btn-warning latest-case-link btn-sm d-flex align-items-center'])[2]")
		private WebElement ClickActlistbtn;
		
	 @FindBy(xpath = "//select[@id='recordType']")
	    private WebElement typeDropdown;

	   
	    @FindBy(xpath = "//a[contains(text(),'Download')]")
	    private List<WebElement> downloadButtons;

	    
	    public void openActListPage() {
	    	ClickActlistbtn.click();
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

