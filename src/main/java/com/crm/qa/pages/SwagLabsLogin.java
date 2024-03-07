package com.crm.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.TestBase;

public class SwagLabsLogin extends TestBase {
    private WebDriver driver;
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    public SwagLabsLogin(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        WebElement usernameInput = driver.findElement(usernameField);
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordField);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();
    }
}