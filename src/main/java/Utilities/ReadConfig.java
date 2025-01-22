package Utilities;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    private Properties properties;
    public ReadConfig(){                                                                 // Constructor to load properties file
        properties = new Properties();
        try{
            FileInputStream fis = new FileInputStream("src/main/resources/Config.properties");
            properties.load(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getProperty(String key){
        return properties.getProperty(key);
    }

}
