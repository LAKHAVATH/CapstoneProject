package com.crm.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase1;

public class CustomerLoginDeposit extends TestBase1 {

    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    WebElement depositSectionButton;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amountInput;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement depositButton;
    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement DepositSuccessful;

    public CustomerLoginDeposit() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnDepositSection() {
        depositSectionButton.click();
    }

    public void enterAmount(String amount) {
        amountInput.sendKeys(amount);
    }

    public void clickOnDepositButton() {
        depositButton.click();
        
    }

	public String getDepositSuccessMessage() {
		return DepositSuccessful.getText();
	}
}