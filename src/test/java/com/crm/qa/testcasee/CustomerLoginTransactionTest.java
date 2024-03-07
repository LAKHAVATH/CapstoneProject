package com.crm.qa.testcasee;
import java.util.NoSuchElementException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase1;
import com.crm.qa.pages.BankingCustomerLogin;
import com.crm.qa.pages.CustomerLoginTransaction;

public class CustomerLoginTransactionTest extends TestBase1 {

    BankingCustomerLogin customerLogin;
    CustomerLoginTransaction transactionPage;

    public CustomerLoginTransactionTest() {
        super(); // Constructor call to initialize WebDriver and load URL
    }

    @Test(priority = 1)
    public void performTransaction() {
        // Initialize page objects
        customerLogin = new BankingCustomerLogin();
        transactionPage = new CustomerLoginTransaction();

        // Step 1: Perform customer login
        customerLogin.clickOnCustomerLogin();

        // Step 2: Click on Transaction section
        transactionPage.clickOnTransactionSection();
     // Verify if the transaction section is displayed
        boolean isTransactionSectionDisplayed = false;
        try {
            isTransactionSectionDisplayed = transactionPage.isTransactionSectionDisplayed();
        } catch (NoSuchElementException e) {
            // Catch the exception if the transaction section is not displayed
        }

        // Assert that the transaction section is displayed
        assert(isTransactionSectionDisplayed) : "Transaction section is not displayed after performing the transaction.";
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}