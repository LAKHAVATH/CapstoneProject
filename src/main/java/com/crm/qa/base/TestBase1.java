package com.crm.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.util.TestUtil;

public class TestBase1 {
    public static WebDriver driver;
    public static Properties prop;

    public TestBase1() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "/src/main/java/com/crm/qa/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @BeforeMethod
    public void setup() {
    	initialization();
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
        	System.setProperty("webdriver.chrome.driver",
					"C:\\Program Files\\Java\\chromedriver-win64\\chromedriver.exe");driver = new ChromeDriver();             
					driver = new ChromeDriver();
        }
        
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        
        String url = prop.getProperty("url");
        if (url != null) {
            driver.get(url);
        } else {
            System.out.println("URL is not specified in config.properties file");
        }
    }
    @AfterMethod
    public void teardown() {
    	driver.quit();
    }
}
