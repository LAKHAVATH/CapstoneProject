package com.crm.qa.testcase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase1;
import com.crm.qa.pages.LoginHRM;

public class loginHRMTestcase extends TestBase1 {
	com.crm.qa.pages.LoginHRM loginpage;


    public loginHRMTestcase() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginpage = new LoginHRM ();
    }

    @Test
    public void loginTest() {
        loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
        // Add assertion to verify successful login
        String homePageTitle = driver.getTitle();
        Assert.assertEquals(homePageTitle,"OrangeHRM","Login not successful.Actual page title: "+ homePageTitle);
    }
    
    

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}