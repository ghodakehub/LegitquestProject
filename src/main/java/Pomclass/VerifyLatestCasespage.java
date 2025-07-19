package Pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VerifyLatestCasespage extends BasePage1 {

	public VerifyLatestCasespage(WebDriver driver) {
		super(driver);
	}

	
	  @FindBy(xpath = "//button[contains(text(),'Latest Cases')]")
	    WebElement latestJudgmentMenu;

	  @FindBy(xpath = "//div[contains(@class,'card-body p-4')]")
	    List<WebElement> caseCards; 
	    
	    public void clickLatestJudgmentMenu() {
	        latestJudgmentMenu.click();
	    }

	   
	    public boolean isCaseListBlank() {
	        return caseCards.size() == 0;
	    }
	}
	

