package com.crm.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase1;

public class BankingManager2OpenAccount extends TestBase1 {

    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    WebElement openAccountBtn;

    @FindBy(xpath = "(//option[@ng-repeat='cust in Customers'])[4]")
    WebElement customerDropdown;

    @FindBy(xpath = "//option[@value='Dollar']")
    WebElement currencyDropdown;

    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement processBtn;

    public BankingManager2OpenAccount() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnOpenAccount() {
        openAccountBtn.click();
    }
    public void ClickonCustomerDropdown() {
        customerDropdown.click();
        
    }
    public void ClickonCurrencyDropdown() {
    	currencyDropdown.click();
        processBtn.click();
    }
    public boolean isOpenAccountAddedSuccessfully() {
        // Add logic to verify if customer added successfully, for example, check for success message or confirmation
        // Return true if added successfully, false otherwise
        return true;
    
    }   
    
}