package generic;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
public class UtilityMethods {
	
	public static void scrollAndClick(WebDriver driver, WebElement element, String description) throws InterruptedException {
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	    Library.threadSleep(1000);
	    Library.click(driver, element, description);
	}

	public static void scrollToElement(WebDriver driver, WebElement element) {
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void switchToNewTabIfOpened(WebDriver driver, String mainWindow) throws InterruptedException {
	    Set<String> allWindows = driver.getWindowHandles();
	    if (allWindows.size() > 1) {
	        for (String window : allWindows) {
	            if (!window.equals(mainWindow)) {
	                driver.switchTo().window(window);
	                break;
	            }
	        }
	        Library.threadSleep(2000);
	    }
	}

	public static void handleAlertIfPresent(WebDriver driver) {
	    try {
	        Alert alert = driver.switchTo().alert();
	        alert.accept();
	    } catch (NoAlertPresentException e) {
	        System.out.println("No alert present.");
	    }
	}

	public static boolean isFileDownloaded(String downloadPath, String fileExtension) {
	    File dir = new File(downloadPath);
	    File[] files = dir.listFiles((d, name) -> name.toLowerCase().endsWith(fileExtension));
	    return files != null && files.length > 0 && files[0].lastModified() > System.currentTimeMillis() - 30000; // downloaded in last 30 sec
	}
	
	public boolean isFileDownloadedSuccessfully() {
	    // Check download folder for new file — implement logic as per your setup
	    File downloadDir = new File("C:\\Users\\YourUser\\Downloads"); // Adjust path
	    File[] files = downloadDir.listFiles();
	    if (files != null) {
	        for (File file : files) {
	            if (file.isFile() && file.getName().endsWith(".pdf") && file.lastModified() > System.currentTimeMillis() - 60_000) {
	                return true;
	            }
	        }
	    }
	    return false;
	}
	
	public static boolean waitForFileDownload(String downloadDir, String fileExtension, int timeoutInSeconds) {
        File dir = new File(downloadDir);
        long endTime = System.currentTimeMillis() + (timeoutInSeconds * 1000);

        while (System.currentTimeMillis() < endTime) {
            File[] files = dir.listFiles((dir1, name) -> name.endsWith(fileExtension));
            if (files != null && files.length > 0) {
                return true;  // File is downloaded
            }
            try {
                Thread.sleep(500);  // Check every 500ms
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return false;  // Timeout reached, file not downloaded
    }
}

