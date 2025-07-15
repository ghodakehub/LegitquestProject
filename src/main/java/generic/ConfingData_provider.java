package generic;

public class ConfingData_provider {
	public static String  driverpath="D:\\Legitquest\\src\\main\\resources\\Drivers\\chromedriver-win64\\chromedriver.exe";
	public static String excelsheet="C:\\Users\\Super\\Downloads\\Patrol\\TestDataExelSheet\\TestData.xlsx";
	
	public static String URL= ConfigReader.getConfigData("URL");
	public static String Email= ConfigReader.getConfigData("Email");
	public static String Password = ConfigReader.getConfigData("Password");
	public static String screenshot = "C:\\Users\\Super\\Downloads\\Patrol\\Screenshot";
	public static String Browser = ConfigReader.getConfigData("Browser");
	public static String Headless = ConfigReader.getConfigData("Headless");

}
