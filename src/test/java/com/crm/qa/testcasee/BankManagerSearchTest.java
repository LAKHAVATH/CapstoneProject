package com.crm.qa.testcasee;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase1;
import com.crm.qa.pages.BankManagerSearch;
import com.crm.qa.pages.BankingCustomerLogin;
import com.crm.qa.pages.BankingManagerLogin;

public class BankManagerSearchTest extends TestBase1 {

	BankingManagerLogin managerLogin;
	BankManagerSearch customerPage;

    public BankManagerSearchTest() {
        super(); // Constructor call to initialize WebDriver and load URL
    }

    @Test(priority = 1)
    public void searchCustomer() {
        // Initialize page objects
        managerLogin = new BankingManagerLogin();
        customerPage = new BankManagerSearch();

        // Step 1: Click on Bank Manager Login button
        managerLogin.clickOnManagerLogin();
        customerPage.clickOnCustomerLogin();


        // Step 2: Search for a customer
        String customerName = "Harry";
        customerPage.searchCustomer(customerName);
        
     // Step 3: Assert that the customer search was successful
        Assert.assertTrue(driver.getPageSource().contains("Harry"), "Customer 'Harry Potter' not found.");
    

}

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}