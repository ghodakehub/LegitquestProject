package generic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
public class PaginationsUtility {


    public static boolean clickNextPagination(WebDriver driver) {
    	
    	 try {
    	        // Locate the "Next" button inside the pagination container
    	        WebElement nextBtn = driver.findElement(By.xpath("//*[@id='paginationbottom']//li/a[contains(text(), 'Next')]"));

    	        // Ensure the button is both displayed and enabled
    	        if (nextBtn.isDisplayed() && nextBtn.isEnabled()) {
    	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextBtn);
    	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextBtn);

    	            // Wait for the next page data to load (replace with WebDriverWait if needed)
    	            Thread.sleep(2000);
    	            return true;
    	        } else {
    	            System.out.println("Next button is not enabled or visible.");
    	        }
    	    } catch (Exception e) {
    	        System.out.println("Next button click failed: " + e.getMessage());
    	    }
    	    return false;
    	}
	
    
    public static void clickAllNumberedPages(WebDriver driver) {
        try {
            List<WebElement> pages = driver.findElements(By.xpath("//li[contains(@class,'page-item')]//button"));
            
            for (int i = 0; i < pages.size(); i++) {
                List<WebElement> refreshedPages = driver.findElements(By.xpath("//li[contains(@class,'page-item')]//button"));
                WebElement page = refreshedPages.get(i);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", page);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", page);
                System.out.println("Clicked on page: " + page.getText());
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            System.out.println("Could not click all numbered pages: " + e.getMessage());
        }
    }
    
    
    
}


