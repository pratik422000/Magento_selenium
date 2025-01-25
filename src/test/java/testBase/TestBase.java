package testBase;

import Utilities.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.SignInPage;

import java.time.Duration;

public class TestBase {
    public WebDriver driver;
    public  ReadConfig config =new ReadConfig();

    @BeforeMethod
    public void setUp(){
        String baseUrl=config.getProperty("url");
        driver= new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String actualTitle= driver.getTitle();
        String expectedTitle = "Home Page";
        Assert.assertEquals(actualTitle,expectedTitle,"window not Opened");
    }
    @BeforeMethod
    public void signIn(){
        String email= config.getProperty("email");
        String password= config.getProperty("pwd");
        SignInPage signIn = new SignInPage(driver);
        signIn.enterLoginCredentials(email,password);
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
