package pageObjects;

import Utilities.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends HomePage {

    public WebDriver driver;
    WebDriverUtils utils= new WebDriverUtils(driver);
    public SignInPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@class='action login primary']")
    WebElement signInBtn2;
    @FindBy(xpath = "//input[@id='email']")
    WebElement loginEmail;
    @FindBy(xpath = "//*[@name='login[password]']")
    WebElement loginPassword;


    public void enterLoginCredentials(String emailInput, String pass){
        signInBtn.click();
        loginEmail.sendKeys(emailInput);
        loginPassword.sendKeys(pass);
        utils.waitForElementToBeVisibleAndClick(signInBtn2);

    }
}
