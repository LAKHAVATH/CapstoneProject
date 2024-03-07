package com.crm.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase1;

public class CustomerLoginWithdraw extends TestBase1 {

    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    WebElement withdrawSectionButton;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amountInput;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement withdrawButton;
    
    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement withdrawlSuccessful;

    public CustomerLoginWithdraw() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnWithdrawSection() {
        withdrawSectionButton.click();
    }

    public void enterAmount(String amount) {
        amountInput.sendKeys(amount);
    }

    public void clickOnWithdrawlButton() {
    	withdrawButton.click();
        
    }

	public String getWithdrawSuccessMessage() {
		return withdrawlSuccessful.getText();
	}
}