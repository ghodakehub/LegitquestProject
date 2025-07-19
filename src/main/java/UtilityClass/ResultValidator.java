package UtilityClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class ResultValidator {
	
	  public static void validateSearchResult(WebDriver driver, WebElement resultElement, String searchType) {
	        Waitutility.waitForSpinnerToDisappear(driver);

	        String resultText = resultElement.getText().trim();

	        if (resultText.isEmpty() || resultText.contains("  No results found ") || resultText.equals("0")) {
	            String currentUrl = driver.getCurrentUrl();
	            throw new AssertionError("No results found for " + searchType + " | URL: " + currentUrl);
	        }

	        Reporter.log(searchType + " search returned results successfully: " + resultText, true);
	    }
	}


