package generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader  {
    public static String getConfigData(String key) {
        Properties properties = new Properties();
        String filePath = System.getProperty("user.dir")+"/src/main/resources/Config.properties";
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Return null if there's an error loading the file
        }
        // Retrieve the value from properties file
        return properties.getProperty(key, "Key not found"); // Default message if key doesn't exist
    }}
