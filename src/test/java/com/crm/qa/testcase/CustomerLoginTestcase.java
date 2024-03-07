package com.crm.qa.testcase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase1;
import com.crm.qa.pages.BankingCustomerLogin;

public class CustomerLoginTestcase extends TestBase1 {

    BankingCustomerLogin customerLoginPage;

    public CustomerLoginTestcase() {
        super(); // Constructor call to initialize WebDriver and load URL
    }

    @BeforeMethod
    public void setUp() {
        customerLoginPage = new BankingCustomerLogin();
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    /**
     * Test Case: Validate Customer Login functionality.
     * 
     * Test Steps:
     * 1. Click on Customer Login button.
     * 2. Select customer name from dropdown.
     * 3. Click on Login button.
     */
    @Test(priority = 1)
    public void validateCustomerLogin() {
        // Step 1: Click on Customer Login button
        customerLoginPage.clickOnCustomerLogin();
        
        // Add assertions to verify the successful login if needed
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}