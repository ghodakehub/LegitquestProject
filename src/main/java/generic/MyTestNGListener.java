package generic;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.google.common.io.Files;

 

	public class MyTestNGListener  implements ITestListener
	{
	public static int executionCount,passCount,failCount,skipCount=0;
	public static int startMinute,endMinute=0;

	

		public void onTestStart(ITestResult result) {
			executionCount++;
			Reporter.log(result.getName()+"script execution starts"+new Date(),true);
		
			
		}

		public void onTestSuccess(ITestResult result) {
			
			passCount++;
			Reporter.log(result.getName()+"script is passsed",true);

			
		}


		public void onTestFailure(ITestResult result, WebDriver driver) {
			failCount++;
			Reporter.log(result.getName()+"script is failed",true);
			TakesScreenshot ts=(TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File destFile = new File("./Screenshots/"+result.getName()+".png");			
				
			try {
				Files.copy(srcFile, destFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			Reporter.log("screenshot has taken",true);
		}

		
		public void onTestSkipped(ITestResult result) {
			skipCount++;
			Reporter.log(result.getName()+"scriptis skipped",true);

			
			
		}

		
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			
		}

		
		public void onStart(ITestContext context) {
			Reporter.log("suite execution starts:"+new Date(),true);
			startMinute=LocalTime.now().getMinute();
			
		}

		
		public void onFinish(ITestContext context) {
			Reporter.log("suite execution ends:"+new Date(),true);
			endMinute=LocalTime.now().getMinute();
			int totalMinutes=startMinute-endMinute;
			Reporter.log("Total suite execution time:"+totalMinutes+"mins",true);
			
			Reporter.log("Total script executed:"+executionCount,true);
			Reporter.log("Total script passed:"+passCount,true);
			Reporter.log("Total script failed:"+failCount,true);
			Reporter.log("Total script skippped:"+skipCount,true);

			

			
		}
		
		
		
		
		           
			  
			  
			  
			  
			  
			  
			  
		
		


}
