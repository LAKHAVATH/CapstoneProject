package com.crm.qa.testcase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;

import com.crm.qa.pages.SwagLabsLogin;

public class SwagLoginTestcase {
    WebDriver driver;
    String url = "https://www.saucedemo.com/";
    String username = "standard_user";
    String password = "secret_sauce";

    @BeforeTest
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files\\Java\\chromedriver-win64\\chromedriver.exe");driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    public void loginTest() {
        SwagLabsLogin loginPage = new SwagLabsLogin(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        
        // Validate if login is successful (you can add assertions or further actions here)
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"), "Login failed!");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}