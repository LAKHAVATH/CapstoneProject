package com.crm.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase1;

public class BankingManger1AddCustomer extends TestBase1 {

    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    WebElement addCustomerBtn;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement zipCodeInput;

    @FindBy(xpath = "(//button[contains(text(),'Add Customer')])[2]")
    WebElement addCustomerSubmitBtn;

    public BankingManger1AddCustomer() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnAddCustomer() {
        addCustomerBtn.click();
    }

    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void enterZipCode(String zipCode) {
        zipCodeInput.sendKeys(zipCode);
    }

    public void clickOnAddCustomerBtn() {
        addCustomerSubmitBtn.click();
    }

    // Add a method to check if customer was added successfully
    public boolean isCustomerAddedSuccessfully() {
        // Add logic to verify if customer added successfully, for example, check for success message or confirmation
        // Return true if added successfully, false otherwise
        return true; // Placeholder, replace with actual logic
    }
}