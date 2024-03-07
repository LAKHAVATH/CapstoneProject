package com.crm.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.qa.base.TestBase1;

public class BankingManagerLogin extends TestBase1 {

	@FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement managerLoginBtn;
    
    
    

    public BankingManagerLogin() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnManagerLogin() {
        managerLoginBtn.click();
        
    }

}
