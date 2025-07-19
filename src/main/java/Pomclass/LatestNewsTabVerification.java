package Pomclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LatestNewsTabVerification extends BasePage1 {

	public LatestNewsTabVerification(WebDriver driver) {
		super(driver);
	}

	private By actlistbutton =By.xpath("/html/body/div[3]/main/a[1]/button");
	 private By supremeTab = By.id("court1");
	    private By highCourtTab = By.id("court2");
	    private By tribunalTab = By.id("court3");

	    private By supremeHeading = By.xpath("//h1[contains(text(),'Latest Supreme Court Judgments')]");
	    private By highCourtHeading = By.xpath("//h1[contains(text(),'Latest High Court Judgments')]");
	    private By tribunalHeading = By.xpath("//h1[contains(text(),'Latest Tribunal Court Judgments')]");
	    
	    public void clickonactlistbtn() {
	        driver.findElement(actlistbutton).click();
	    }

	    
	    public void clickSupremeTab() {
	    	
	        driver.findElement(supremeTab).click();
	    }

	    public void clickHighCourtTab() {
	        driver.findElement(highCourtTab).click();
	    }

	    public void clickTribunalTab() {
	        driver.findElement(tribunalTab).click();
	    }

	    public boolean isSupremeHeadingDisplayed() {
	        return driver.findElement(supremeHeading).isDisplayed();
	    }

	    public boolean isHighCourtHeadingDisplayed() {
	        return driver.findElement(highCourtHeading).isDisplayed();
	    }

	    public boolean isTribunalHeadingDisplayed() {
	        return driver.findElement(tribunalHeading).isDisplayed();
	    }
	}

