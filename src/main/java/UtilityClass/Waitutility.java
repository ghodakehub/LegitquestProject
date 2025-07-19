package UtilityClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Waitutility {
	public static void waitForSpinnerToDisappear(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//img[contains(@src, 'lq-spin.gif')]")
            ));
        } catch (TimeoutException e) {
            System.out.println("Spinner did not disappear in expected time.");
        }
    }


}