package generic;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import java.io.ByteArrayInputStream;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

public class AllureListeners implements ITestListener {
 
	public static byte[] captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            if (driver instanceof TakesScreenshot) {
                byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment(screenshotName, new ByteArrayInputStream(screenshotBytes));
                System.out.println("Screenshot captured and attached to Allure Report: " + screenshotName);
                return screenshotBytes; // Return the screenshot
            } else {
                System.out.println("Driver does not support screenshots");
            }
        } catch (Exception e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
        return null;
    }

    public static void attachText(String name, String content) {
        Allure.addAttachment(name, "text/plain", content);
    }
	
	
	@Attachment(value = "URL on Failure", type = "text/plain")
    public static String captureURL(WebDriver driver) {
        try {
            return "Failed URL: " + driver.getCurrentUrl();
        } catch (Exception e) {
            return "URL Not Available";
        }
    }
	
	
	
	
	
	
}
