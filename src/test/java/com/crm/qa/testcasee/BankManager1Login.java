package com.crm.qa.testcasee;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase1;
import com.crm.qa.pages.BankingManagerLogin;

public class BankManager1Login extends TestBase1 {

    BankingManagerLogin managerlogin;

    public BankManager1Login() {
        super(); // Constructor call to initialize WebDriver and load URL
    }

    @BeforeMethod
    public void setUp() {
        managerlogin = new BankingManagerLogin ();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    
    @Test(priority = 1)
    public void validateManagerLogin() {
        // Step 1: Click on manager Login button
    	managerlogin.clickOnManagerLogin();
    	
        
      
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}