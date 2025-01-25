package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreateNewAccntForm {
    public WebDriver driver;
    public CreateNewAccntForm(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//span[text()='Create New Customer Account']")
    WebElement createAccntHeader;
    @FindBy(xpath = "//input[@id='firstname']")
    WebElement firstName;
    @FindBy(xpath = "//input[@id='lastname']")
    WebElement lastName;
    @FindBy(xpath = "//input[@id='email_address']")
    WebElement email;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//input[@id='password-confirmation']")
    WebElement confirmPwd;
    @FindBy(xpath = "//button[@title='Create an Account']")
    WebElement createAccntBtn;

    @FindBy(xpath = "//div[@data-ui-id='message-success']/div")
    WebElement successMessage;


    public void verifyheader(){
        String Header =createAccntHeader.getText();
        Assert.assertEquals(Header, "Create New Customer Account");
    }
    public void enterPersonalInfo(){
        firstName.sendKeys("pratik");
        lastName.sendKeys("Test");
    }
    public void enterSignInInfo(String emailInput, String pass){
        email.sendKeys(emailInput);
        password.sendKeys(pass);
        confirmPwd.sendKeys(pass);
        createAccntBtn.click();
        String successMsg= successMessage.getText();
        System.out.println(successMsg);
    }

}