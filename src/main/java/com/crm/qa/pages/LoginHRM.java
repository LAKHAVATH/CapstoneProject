package com.crm.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase1;

public class LoginHRM extends TestBase1 {
    // Page Factory - OR:
    @FindBy(xpath = "//input[@name='username']")
    WebElement usernameField;

    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    // Initializing the Page Objects:
    public LoginHRM() {
        PageFactory.initElements(driver, this);
    }

    // Actions:
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}