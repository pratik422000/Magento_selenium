package testBase;

import Utilities.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.CreateNewAccntForm;

import java.time.Duration;

public class TestBase {
    public WebDriver driver;
    private ReadConfig config;

    public TestBase(){
        config = new ReadConfig();
    }

    @BeforeMethod
    public void setUp(){
        String baseUrl=config.getProperty("url");
        driver= new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String title= driver.getTitle();
        System.out.println("Title of the page is: "+ title);
    }
    @BeforeMethod
    public void signIn(){
        String email= config.getProperty("email");
        String password= config.getProperty("pwd");
        CreateNewAccntForm signIn = new CreateNewAccntForm(driver);
        signIn.enterLoginCredentials(email,password);
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
