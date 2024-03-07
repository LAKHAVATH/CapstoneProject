package com.crm.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase1;

public class BankingCustomerDelete extends TestBase1 {

    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    WebElement customersBtn;

    @FindBy(xpath = "(//button[@ng-click='deleteCust(cust)'])[2]")
    WebElement deleteCustomerBtn;

    public BankingCustomerDelete() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnCustomers() {
        customersBtn.click();
    }

    public void deleteCustomer() {
        deleteCustomerBtn.click();
       
    }
    
}