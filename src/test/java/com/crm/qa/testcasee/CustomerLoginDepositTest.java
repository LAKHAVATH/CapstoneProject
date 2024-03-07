package com.crm.qa.testcasee;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase1;
import com.crm.qa.pages.BankingCustomerLogin;
import com.crm.qa.pages.CustomerLoginDeposit;

public class CustomerLoginDepositTest extends TestBase1 {

    BankingCustomerLogin customerLogin;
    CustomerLoginDeposit depositPage;

    public CustomerLoginDepositTest() {
        super(); // Constructor call to initialize WebDriver and load URL
    }

    @Test(priority = 1)
    public void depositAmount() {
        // Initialize page objects
        customerLogin = new BankingCustomerLogin();
        depositPage = new CustomerLoginDeposit();

        // Step 1: Perform customer login
        customerLogin.clickOnCustomerLogin();

        // Step 2: Click on Deposit section
        depositPage.clickOnDepositSection();

        // Step 3: Enter amount and click on Deposit button
        depositPage.enterAmount("500");
        depositPage.clickOnDepositButton();

        // Verify deposit success message
        String successMessage = depositPage.getDepositSuccessMessage();
        Assert.assertEquals(successMessage, "Deposit Successful", "Deposit was not successful.");
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
}}