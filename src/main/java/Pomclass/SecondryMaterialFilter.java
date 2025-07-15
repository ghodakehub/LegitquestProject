package Pomclass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;

import UtilityClass.Waitutility;

public class SecondryMaterialFilter extends BasePage1 {

	public SecondryMaterialFilter(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath = "//*[@id=\"search\"]") // Main Search Box
	private WebElement searchbox;

	@FindBy(xpath = "//*[@id=\"btnSearch\"]/i") // Main Search Icon
	private WebElement SearchButton;

	@FindBy(xpath = "//button[@href='#select-dropdown']") // All
	private WebElement Allmenu;

	@FindBy(xpath = "//a[@id='material11']") // By Acts (Secondary material)
	private WebElement actname;

	@FindBy(xpath = "//*[@id=\"totalResult\"]/span") // result main
	private WebElement result;

	@FindBy(xpath = "//*[@id=\"secondaryId\"]/div/div[2]/button[2]/i") // Secondary material next button
	private WebElement Secondrynxtbtn;

	@FindBy(xpath = "//*[@id=\"secondaryId\"]/div/div[2]/button[1]/i") // Secondary material back button
	private WebElement Secondrybkbtn;

	@FindBy(xpath = "//*[@id=\"material4\"]") // Secondary material Notification option
	private WebElement Notification;

	@FindBy(xpath = "//*[@id=\"material1\"]") // Secondary material Bills in Parliament option
	private WebElement Billinparliament;

	@FindBy(xpath = "//*[@id=\"material5\"]") //
	private WebElement ReportCM;

	@FindBy(xpath = "//*[@id=\"material3\"]")
	private WebElement LawCReport;

	@FindBy(xpath = "//*[@id=\"material2\"]")
	private WebElement CAD;

	@FindBy(xpath = "//*[@id=\"material6\"]")
	private WebElement Treaties;

	@FindBy(xpath = "//*[@id=\"material10\"]")
	private WebElement News;

	@FindBy(xpath = "//*[@id=\"material9\"]")
	private WebElement Interviews;

	@FindBy(xpath = "//*[@id=\"material8\"]")
	private WebElement Columns;

	@FindBy(xpath = "//*[@id=\"material13\"]")
	private WebElement circular;

	@FindBy(xpath = "//*[@id=\"myBtn\"]/i")
	private WebElement topbtn;

	@FindBy(xpath = "//*[@id=\"0\"]/div/div/div[2]/a[1]/small")
	private WebElement srchwthcase;

	@FindBy(xpath = "//*[@id=\"searchitem0\"]")
	private WebElement Searchwithinsearch;

	@FindBy(xpath = "//*[@id=\"0\"]/div/div/div[2]/div/div[1]/div[2]/div[1]/button[1]")
	private WebElement search;

	@FindBy(xpath = "//*[@id=\"0\"]/div/div/div[2]/div/div[1]/div[2]/div[1]/button[3]")
	private WebElement Next;

	@FindBy(xpath = "//*[@id=\"0\"]/div/div/div[2]/div/div[1]/div[2]/div[1]/button[2]")
	private WebElement previous;

	@FindBy(xpath = "//*[@id=\"0\"]/div/div/div[2]/div/div[1]/div[1]/a/i")
	private WebElement close;

	@FindBy(xpath = "//*[@id=\"presecriptive2\"]")
	private WebElement referred;

	// Filter

	@FindBy(xpath = "//*[@id=\"smyearfilter\"]/label")
	private WebElement YearButton;

	@FindBy(xpath = "//*[@id=\"bysmyear\"]/li/div/label/span")
	private WebElement filterfirstdata;

	@FindBy(xpath = "//*[@id=\"ministryfilter\"]/label")
	private WebElement Ministry;

	@FindBy(xpath = "//*[@id=\"byministry\"]/li/div/label/span")
	private WebElement Ministryfirst;

	@FindBy(xpath = "//*[@id=\"titlefilter\"]/label")
	private WebElement titlefilter;

	@FindBy(xpath = "//*[@id=\"bytitle\"]/li/div/label/span")
	private WebElement Titlefiltersencond;

	@FindBy(xpath = "//*[@id=\"subtitlefilter\"]/label")
	private WebElement subtitlefilter;

	@FindBy(xpath = "//*[@id=\"bysubtitle\"]/li/div/label/span")
	private WebElement subtitlefilterfirst;

	@FindBy(xpath = "//*[@id=\"reportnofilter\"]/label")
	private WebElement LawReportfilter;

	@FindBy(xpath = "//*[@id=\"byreportno\"]/li/div/label/span")
	private WebElement LawReportfilterfirst;

	@FindBy(xpath = "//*[@id=\"subtitlefilter\"]/label")
	private WebElement CADFilter;

	@FindBy(xpath = "//*[@id=\"bysmyear\"]/li[1]/div/label/span")
	private WebElement CADFilterYearFirst;

	@FindBy(xpath = "//*[@id=\"titlefilter\"]/label")
	private WebElement TreatiesFilter;

	@FindBy(xpath = "//*[@id=\"bytitle\"]/li[1]/div/label/span")
	private WebElement TreatiesTitleFilter;

	@FindBy(xpath = "//*[@id=\"smyearfilter\"]/label/div")
	private WebElement NewsFilter;

	@FindBy(xpath = "//*[@id=\"bysmyear\"]/li[2]/div/label/span")
	private WebElement NewsFilterYeartwo;

	@FindBy(xpath = "//*[@id=\"smyearfilter\"]/label")
	private WebElement ColumnFilter;

	@FindBy(xpath = "//*[@id=\"bysmyear\"]/li[1]/div/label/span")
	private WebElement ColumnFilterYearone;


	// Actions 	
	public void click() throws InterruptedException {
		   searchbox.sendKeys("rama");
	        Thread.sleep(3000);
	        SearchButton.click();
	        Thread.sleep(3000);

	        navigateSecondaryMaterial();

	        applyFiltersSafely(actname, YearButton, filterfirstdata, "ACTS");
	        applyFiltersSafely(Notification, Ministry, Ministryfirst, "Notification");
	        applyFiltersSafely(Billinparliament, titlefilter, Titlefiltersencond, "Bills In Parliament");
	        applyFiltersSafely(ReportCM, subtitlefilter, subtitlefilterfirst, "Reports of Commissions and Committees");
	        applyFiltersSafely(LawCReport, LawReportfilter, LawReportfilterfirst, "Law Commission Reports");

	        scrollAndClick(CAD, "CAD");
	        Thread.sleep(3000);

	        applyFiltersSafely(Treaties, titlefilter, TreatiesTitleFilter, "Treaties");
	        applyFiltersSafely(News, NewsFilter, NewsFilterYeartwo, "News");
	        applyFiltersSafely(Columns, NewsFilter, ColumnFilterYearone, "Columns");
	        applyFiltersSafely(circular, Ministry, Ministryfirst, "Circular");
	    }

	    private void applyFiltersSafely(WebElement mainTab, WebElement filterCategory, WebElement filterOption, String tabName) throws InterruptedException {
	        try {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", mainTab);
	            Thread.sleep(1000);
	            Waitutility.waitForSpinnerToDisappear(driver);
	            mainTab.click();
	            Thread.sleep(2000);
	            Waitutility.waitForSpinnerToDisappear(driver);
	            filterCategory.click();
	            Thread.sleep(2000);
	            Waitutility.waitForSpinnerToDisappear(driver);
	            filterOption.click();
	            Thread.sleep(2000);
	            Waitutility.waitForSpinnerToDisappear(driver);

	            String resultText = result.getText().trim();
	            if (resultText.isEmpty() || resultText.contains("  No results found ") || resultText.equals("0")) {
	                throw new AssertionError(tabName + " did not return any results.");
	            }
	            Reporter.log(tabName + " filter is working. Result: " + resultText, true);
	        } catch (Exception e) {
	           // System.out.println("Error in " + tabName + " filter: " + e.getMessage());
	           Reporter.log(tabName + " filter failed or not clickable.", true);
	        }
	    }

	    private void scrollAndClick(WebElement element, String label) {
	        try {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	            Thread.sleep(1000);
	            element.click();
	            Reporter.log(label + " tab clicked successfully.", true);
	        } catch (Exception e) {
	            System.out.println("Error clicking on " + label + ": " + e.getMessage());
	        }
	    }

	    private void navigateSecondaryMaterial() throws InterruptedException {
	        Secondrynxtbtn.click(); Thread.sleep(2000);
	        Secondrynxtbtn.click(); Thread.sleep(2000);
	        Secondrybkbtn.click(); Thread.sleep(2000);
	    }
	}




