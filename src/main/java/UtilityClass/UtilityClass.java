package UtilityClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class UtilityClass {
	

	
	public  static String Capaturescreenshot(WebDriver driver , String FrontpageOFweb) throws IOException 
	{
		
		 String dateName= new SimpleDateFormat("yyyy/MMddhmmss").format(new Date());
		 
		 TakesScreenshot ts=(TakesScreenshot)driver;
		 File source=ts.getScreenshotAs(OutputType.FILE);
		 String destination= System.getProperty("user.dir")+"/Screenshots/" +FrontpageOFweb +dateName+".png";
		 
		 File finalDestination =new File(destination);
		FileUtils.copyFile(source, finalDestination);
		 
		 return destination;
		
	}
		
	
	
	 public static String readPropertyFileData( String key) throws IOException
	 {
		 Properties prop= new Properties();
		 FileInputStream file= new FileInputStream("D:\\Legiteye\\src\\main\\resources\\Credentialsfie\\login.properties");
		 prop.load(file);
		 String value= prop.getProperty(key);
		 return value;
	 }
	
	
	

}
