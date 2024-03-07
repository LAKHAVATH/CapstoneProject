package com.crm.qa.testcasee;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase1;
import com.crm.qa.pages.BankingManagerLogin;
import com.crm.qa.pages.BankingManger1AddCustomer;

public class BankManger2AddCustomer extends TestBase1 {

    BankingManagerLogin managerLogin;
    BankingManger1AddCustomer bankManager;

    public BankManger2AddCustomer() {
        super(); // Constructor call to initialize WebDriver and load URL
    }

    @BeforeMethod
    public void setUp() {
        managerLogin = new BankingManagerLogin();
        bankManager = new BankingManger1AddCustomer();
        initialization();
    }

    
    @Test(priority = 1)
    public void validateAddCustomer() {
        // Step 1: Click on Bank Manager Login button
        managerLogin.clickOnManagerLogin();

        // Step 2: Click on Add Customer button
        bankManager.clickOnAddCustomer();

        // Step 3: Enter customer details
        bankManager.enterFirstName("Lakhavath");
        bankManager.enterLastName("Naveen");
        bankManager.enterZipCode("505404");

        // Step 4: Click on Add Customer button
        bankManager.clickOnAddCustomerBtn();

        // Verify if customer added successfully
        Assert.assertTrue(bankManager.isCustomerAddedSuccessfully(), "Customer was not added successfully.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}