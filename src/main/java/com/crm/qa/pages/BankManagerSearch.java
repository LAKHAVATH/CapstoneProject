package com.crm.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase1;

public class BankManagerSearch extends TestBase1 {

	@FindBy(xpath = "//button[@ng-class='btnClass3']")
    WebElement CustomerBtn;
	//@FindBy(xpath = "//button[@ng-class='btnClass3']")
    //WebElement customerBtn;
    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement customeNameBtn;
    
    
    

    public BankManagerSearch() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnCustomerLogin() {
    	CustomerBtn.click();
    	//customerBtn.click();
       
        //lgnBtn.click();        
        
    }
    public void searchCustomer(String customerName) {
    	customeNameBtn.click();
    	customeNameBtn.sendKeys(customerName);
    }
    public boolean isCustomerPresent(String customerName) {
        return driver.getPageSource().contains(customerName);
    }

}