package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreateNewAccntForm {
    public WebDriver driver;

    // Sign In WebElements
    @FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
    WebElement signInBtn;
    @FindBy (xpath = "//button[@class='action login primary']")
        WebElement signInBtn2;
    @FindBy(xpath = "//input[@id='email']")
    WebElement loginEmail;
    @FindBy(xpath = "//*[@name='login[password]']")
    WebElement loginPassword;


    // Create Account WebElements

    @FindBy(xpath="//div[@class='panel header']//a[normalize-space()='Create an Account']")
    WebElement CreateAccntBtn;
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
    public CreateNewAccntForm(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void clickCreateAccountBtn(){
        CreateAccntBtn.click();
    }
    public void clickSignInBtn(){
        signInBtn.click();
    }

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

    public void enterLoginCredentials(String emailInput, String pass){
        signInBtn.click();
        loginEmail.sendKeys(emailInput);
        loginPassword.sendKeys(pass);
        signInBtn2.click();

    }


}