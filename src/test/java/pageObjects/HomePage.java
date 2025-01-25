package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
    WebElement signInBtn;

    @FindBy(xpath="//div[@class='panel header']//a[normalize-space()='Create an Account']")
    WebElement CreateAccntBtn;

    public void clickCreateAccountBtn(){
        CreateAccntBtn.click();
    }
    public void clickSignInBtn(){
        signInBtn.click();
    }

}
