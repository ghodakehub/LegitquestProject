package Pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import UtilityClass.Library;
import generic.SwitchWindow;

public class LatestLegalNewsDateSortby extends BasePage1 {

	public LatestLegalNewsDateSortby(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath="/html/body/div[3]/main/a[3]/button")
	private WebElement latestlegalnewsbtn;
	
	@FindBy (id="days_filter_news")
	private WebElement datefilter;
	
	@FindBy (id="sort_by_filter_news")
	private WebElement sortby;
	
	@FindBy (xpath="//h4[text()='Latest Legal News Roundup']")  //get title
	private WebElement latestlegalnewsroundup;
	
	@FindBy (xpath="/html/body/main/section/div/div/div/div/div[1]")
	private WebElement dateofcase;


	public void Verifylatestlegalnewsbydatesortby(WebDriver driver) throws InterruptedException
	{
		Library.click(driver, latestlegalnewsbtn, "click on legalnewsbtn");
		Library.threadSleep(3000);
		
		
		SwitchWindow.switchWindowByIndex(driver, 2);
		Thread.sleep(3000);
	
		Select option= new Select(datefilter);
		option.selectByValue("15");
		Library.threadSleep(3000);
		
				
		option.selectByValue("30");
		Library.threadSleep(3000);
		
		String date1 = dateofcase.getText();
		System.out.println("Date :"+date1);
		
		Select option1= new Select(sortby);
		option1.selectByVisibleText("Oldest");
		Library.threadSleep(3000);

		
		option1.selectByVisibleText("Random");
		Library.threadSleep(3000);
		
		option.selectByValue("60");
		Library.threadSleep(3000);

		option1.selectByVisibleText("Newest");
		Library.threadSleep(3000);
		
		option.selectByValue("7");
		Library.threadSleep(3000);


		String titleofpage = latestlegalnewsroundup.getText();
		System.out.println("Title of LatestLegalNews Page :"+titleofpage);
}
}