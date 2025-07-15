package generic;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MailTestLisnerForMultipleRecepient  implements ITestListener{
	
	 private WebDriver driver; 

	    public MailTestLisnerForMultipleRecepient(WebDriver driver) {
	        this.driver = driver;
	    }
	    @Override
	    public void onTestFailure(ITestResult result) {
	        String testName = result.getName();
	        try {
	            // Capture screenshot
	            String screenshotPath = captureScreenshot(testName);

	            // Send email using EmailUtility
	            
	           // WebDriver driver = new ChromeDriver();
	            String[] recipients = {"ghodake6896@gmail.com", "pratiksha6896@gmail.com"};
	            ForMultiplemailReceipent.sendEmail( driver,recipients,
	  
	                "Test Case Failure : " + testName,
	                "The test case " + testName + " has failed. Please find the screenshot attached.",
	                "testUrl",
	                screenshotPath 
	                
	            );

	        } catch (IOException | MessagingException e) {
	            e.printStackTrace();
	        }
	    }

	    private String captureScreenshot(String testName) throws IOException {
	        // Save screenshot in a specific location
	        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String screenshotPath = "screenshots/" + testName + ".png";
	        File destFile = new File(screenshotPath);
	        FileUtils.copyFile(srcFile, destFile);
	        return screenshotPath;
	    }

	   
	}


