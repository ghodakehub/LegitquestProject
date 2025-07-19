package generic;


import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;



import io.github.bonigarcia.wdm.WebDriverManager;

public class NewBaseTest {

	public WebDriver driver;
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
   


    public WebDriver initializeDriver() {
        String browser = ConfingData_provider.Browser.toLowerCase();
        boolean headless = Boolean.parseBoolean(ConfingData_provider.Headless);

        switch (browser) {
            case "chrome":
            	WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--disable-extensions");
                if (headless) {
                    chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("--disable-popup-blocking");
                    chromeOptions.setExperimentalOption("prefs", Map.of(
                        "plugins.always_open_pdf_externally", true, // Download PDFs automatically
                        "download.default_directory", "C:\\Users\\Super\\Downloads" // Set download folder path
                    ));
                }
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
            	WebDriverManager.chromedriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless) {
                    firefoxOptions.addArguments("--headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if (headless) {
                    edgeOptions.addArguments("--headless");
                }
                driver = new EdgeDriver(edgeOptions);
                break;

            default:
                throw new IllegalArgumentException("Invalid browser specified: " + browser);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(ConfingData_provider.URL);
        tdriver.set(driver);
        return NewBaseTest.getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tdriver.get();
    }

//    @BeforeClass
//    public void launchBrowser() {
//        initializeDriver();
//    }
//
//    @AfterClass
//    public void closeBrowser() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
    @BeforeMethod
    public void launchBrowser() {
        initializeDriver();
    }

    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    
   
   
}

