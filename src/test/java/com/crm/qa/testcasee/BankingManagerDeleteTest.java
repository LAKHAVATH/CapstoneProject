package com.crm.qa.testcasee;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase1;
import com.crm.qa.pages.BankingManagerLogin;
import com.crm.qa.pages.BankingCustomerDelete;

public class BankingManagerDeleteTest extends TestBase1 {

    BankingManagerLogin managerLogin;
    BankingCustomerDelete deleteCustomerPage;

    public BankingManagerDeleteTest() {
        super(); // Constructor call to initialize WebDriver and load URL
    }

    @Test(priority = 1)
    public void deleteCustomer() {
        // Initialize page objects
        managerLogin = new BankingManagerLogin();
        deleteCustomerPage = new BankingCustomerDelete();

        // Step 1: Click on Bank Manager Login button
        managerLogin.clickOnManagerLogin();

        // Step 2: Click on Customers button
        deleteCustomerPage.clickOnCustomers();

        // Step 3: Delete a customer
        deleteCustomerPage.deleteCustomer();
        

    }
}