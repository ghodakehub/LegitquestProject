package Pomclass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.SwitchWindow;

public class PDFdownloadStateActList extends BasePage1 {

	public PDFdownloadStateActList(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath = "(//button[@class='btn btn-warning latest-case-link btn-sm d-flex align-items-center'])[2]")
	private WebElement ClickActlistbtn;
	
	
	@FindBy(xpath = "//*[@id=\"recordType\"]")
	private WebElement ClickType;
	
	@FindBy(xpath = "//*[@id=\"actType\"]")
	private WebElement SelectState;
	
	@FindBy(xpath = "//*[@id=\"result\"]/tr[1]/td[1]/a")
	private WebElement SelectOnelinkact ;
	
	@FindBy(xpath = "//a[@class='idraf-link'] ") 
	private List< WebElement> SelectsRulesOption ;
	
	
	@FindBy(xpath = "/html/body/div[2]/div/main/section/div/div[2]/div[1]/div[2]/div[3]/button")
	private WebElement Downloadpdf;
	
	
	public void downloadRulesPDF(WebDriver driver) throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // 1. Click Act List
	    ClickActlistbtn.click();
	    Thread.sleep(500);

	    // 2. Select Type = "Rules"
	    Select optact = new Select(ClickType);
	    optact.selectByVisibleText("Rules");

	    // 3. Select State = "GUJARAT"
	    Select optstate = new Select(SelectState);
	    optstate.selectByVisibleText("GUJARAT");

	    Thread.sleep(1000); 
	   
	    SelectOnelinkact.click(); 
	    Thread.sleep(1000);

	   
	    SwitchWindow.switchWindowByIndex(driver, 2);

	    Thread.sleep(1000); 

	   
	    List<WebElement> ruleLinks = driver.findElements(By.xpath("//div[@class='slimScrollDiv']//a[contains(text(),'RULE')]"));

	    for (WebElement rule : ruleLinks) {
	        rule.click(); 
	        Thread.sleep(1500); 
	    }

	   
	    WebElement pdfBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary btn-sm btn--has-shadow ml-auto ml-lg-4 nav-item--btn pdf-btn']")));
	    pdfBtn.click();

	    Thread.sleep(3000); 
	}
}
