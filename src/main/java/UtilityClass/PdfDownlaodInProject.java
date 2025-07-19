package UtilityClass;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeOptions;

public class PdfDownlaodInProject {
	
	//BaseLib base;
	
	public void pdff()
	{
	String location=System.getProperty("user.dir")+"\\DownloadPdf\\";
	HashMap preferences= new HashMap();
	
	preferences.put("plugins.always_open_pdf_externally", true);
	
	
	preferences.put("download.default_directory",location );
	 ChromeOptions options= new  ChromeOptions();
	 
	 options.setExperimentalOption("prefs", preferences);
	  
	
	
	}
	
	
	public static boolean isFileDownloaded(String downloadDir, String fileExtension) {
	    File dir = new File(downloadDir);
	    File[] files = dir.listFiles((d, name) -> name.toLowerCase().endsWith(fileExtension));
	    return files != null && files.length > 0;
	}
	
	
	 public static boolean isFileDownloaded() {
	        File dir = new File("C:\\Users\\Pratiksha\\Downloads"); // change path
	        File[] files = dir.listFiles();

	        if (files != null) {
	            for (File file : files) {
	                if (file.getName().endsWith(".pdf") && file.lastModified() > System.currentTimeMillis() - 60000) {
	                    return true;
	                }
	            }
	        }
	        return false;
	    }
	}
