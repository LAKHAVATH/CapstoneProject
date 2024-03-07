package com.crm.qa.testcasee;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase1;
import com.crm.qa.pages.BankingCustomerLogin;
import com.crm.qa.pages.CustomerLoginWithdraw;

public class CustomerLoginWithdrawlTest extends TestBase1 {

    BankingCustomerLogin customerLogin;
    CustomerLoginWithdraw withdrawlPage;

    public CustomerLoginWithdrawlTest() {
        super(); // Constructor call to initialize WebDriver and load URL
    }

    @Test(priority = 1)
    public void WithdrawAmount() {
        // Initialize page objects
        customerLogin = new BankingCustomerLogin();
        withdrawlPage = new CustomerLoginWithdraw();

        // Step 1: Perform customer login
        customerLogin.clickOnCustomerLogin();

        // Step 2: Click on withdraw section
        withdrawlPage.clickOnWithdrawSection();

        // Step 3: Enter amount and click on withdrawl button
        withdrawlPage.enterAmount("10");
        withdrawlPage.clickOnWithdrawlButton();

        // Verify deposit success message
        String successMessage = withdrawlPage.getWithdrawSuccessMessage();
        Assert.assertEquals(successMessage, "Transaction Failed. You can not withdraw amount more than the balance.", "Transaction successful");
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
}}