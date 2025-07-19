package Pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import UtilityClass.Library;

public class BurgerMenu extends BasePage1 {

	public BurgerMenu(WebDriver driver) {
		super(driver);
	}


	@FindBy (xpath="/html/body/div[3]/header/nav/div/a[1]/span/span") private WebElement hambuger;
	@FindBy (xpath="(//span[@id='firstname'])[1]") private WebElement profilename;
	@FindBy(xpath="/html/body/nav/div[2]/div[1]/ul/li[1]/ul/li") private List<WebElement> listofprofilename;
     @FindBy(linkText="Company")private WebElement companyoption;

     @FindBy(linkText="Products")private WebElement Productsoption;
     

	
	public void clickhambuger(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		hambuger.click();
		
		Thread.sleep(3000);
		Library.click(driver,profilename , "clcik on profilename");
		
	
		Thread.sleep(3000);
		Library.click(driver,companyoption , "clcik on company");
		
		Thread.sleep(3000);
		Library.scrollTillElementDisplay(driver, Productsoption);
		Library.click(driver, Productsoption,"clickon product");
		
	}
	}
