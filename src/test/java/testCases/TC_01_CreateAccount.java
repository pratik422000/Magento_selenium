package testCases;

import Utilities.ReadConfig;
import org.testng.annotations.Test;
import pageObjects.CreateNewAccntForm;
import testBase.TestBase;

public class TC_01_CreateAccount extends TestBase {
    private ReadConfig config;

    public TC_01_CreateAccount(){
        config = new ReadConfig();
    }

    @Test(enabled = false)
    public void CreateAccount(){
        CreateNewAccntForm accnt = new CreateNewAccntForm(driver);
        accnt.clickCreateAccountBtn();
        accnt.verifyheader();
        accnt.enterPersonalInfo();
        accnt.enterSignInInfo(config.getProperty("email"),config.getProperty("pwd"));
    }

    @Test
    public void verifyHomePage(){
        String pagetitle =driver.getTitle();
        System.out.println("title of the page after login is : "+ pagetitle);
    }

}
