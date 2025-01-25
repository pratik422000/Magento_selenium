package testCases;

import org.testng.annotations.Test;
import pageObjects.CreateNewAccntForm;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_01_CreateAccount extends TestBase {

    @Test(enabled = false)
    public void CreateAccount(){
        CreateNewAccntForm accnt = new CreateNewAccntForm(driver);
        HomePage hm = new HomePage(driver);
        hm.clickCreateAccountBtn();
        accnt.verifyheader();
        accnt.enterPersonalInfo();
        accnt.enterSignInInfo(config.getProperty("email"),config.getProperty("pwd"));
    }

}
