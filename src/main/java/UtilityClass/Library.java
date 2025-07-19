package UtilityClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Library {

	public static WebElement waitForVisibilityOf(WebDriver driver, WebElement element) {
		Library.scrollByPixelSize(driver, 100);
		Library.threadSleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	public static void scrollTillElementDisplay(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public static void scrollByPixelSize(WebDriver driver, int PixelSize) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + PixelSize + ")", "");
	}

	public static void click(WebDriver driver, WebElement element, String LogMessege) {
		try {
			scrollTillElementDisplay(driver, element);
			waitForVisibilityOf(driver, element);
			element.click();
			System.out.println(LogMessege);
		} catch (Exception e) {
			element.click();
			System.out.println("Test failed at step : " + LogMessege);

		}
	}

	public static void sendKeys(WebDriver driver, WebElement element, String LogMessege, String enterValue) {
		try {
			scrollTillElementDisplay(driver, element);
			waitForVisibilityOf(driver, element);
			element.clear();
			element.sendKeys(enterValue);
			System.out.println(LogMessege);
		} catch (Exception e) {
			element.sendKeys(enterValue);
			System.out.println("Test failed at step : " + LogMessege);
		}
	}

	public static void performEnterAction(WebElement element) {
		element.sendKeys(Keys.ENTER);
	}

	public static void threadSleep(int MiliSeconds) {
		try {
			Thread.sleep(MiliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String getConfigueData(String key) {
		Properties pro = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "src\\main\\resources\\config.properties1");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			pro.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String value = pro.getProperty(key);
		return value;
	}
}
