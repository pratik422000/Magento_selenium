package testCases;

import org.testng.annotations.Test;
import testBase.TestBase;

public class TC_02_HomePage extends TestBase {
    @Test
    public void verifyHomePage(){
        String pagetitle =driver.getTitle();
        System.out.println("title of the page after login is : "+ pagetitle);
    }
}



// excel handling, Report creation, testng.xml , parallel execution , grouping of test cases , jenkins.