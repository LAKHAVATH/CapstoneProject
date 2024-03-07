package com.crm.qa.testcasee;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase1;
import com.crm.qa.pages.BankingManagerLogin;
import com.crm.qa.pages.BankingManager2OpenAccount;

public class BankManager3OpenAcnt extends TestBase1 {

    BankingManagerLogin managerLogin;
    BankingManager2OpenAccount bankManager;

    public BankManager3OpenAcnt() {
        super(); // Constructor call to initialize WebDriver and load URL
    }

    @Test(priority = 1)
    public void validateOpenAccount() {
        // Initialize page objects
        managerLogin = new BankingManagerLogin();
        bankManager = new BankingManager2OpenAccount();

        // Step 1: Click on Bank Manager Login button
        managerLogin.clickOnManagerLogin();
       

        // Step 2: Click on Open Account button
        bankManager.clickOnOpenAccount();
        bankManager.ClickonCustomerDropdown();
        bankManager.ClickonCurrencyDropdown();
     // Assertion: Verify if the account has been successfully opened or if there's any error message
       // Assert.assertTrue(driver.getPageSource().contains("Customer added successfully with customer id :"), "Account creation failed!");
        // Adjust the error message above according to the actual error message displayed on the page
        // Verify if customer added successfully
        Assert.assertTrue(bankManager.isOpenAccountAddedSuccessfully(), "Customer added successfully with customer id : ");
    }
        

        
    
}