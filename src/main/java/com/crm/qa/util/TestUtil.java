package com.crm.qa.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.homepage;

public class TestUtil extends TestBase{



public static long PAGE_LOAD_TIMEOUT = 20;

	public static long IMPLICIT_WAIT = 20;
 
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\Lenovo\\Downloads"

			+ "/FreeCRMTest/src/main/java/com/crm/qa/testdata/FreeCrmTestData.xlsx";
 
	static Workbook book;

	static Sheet sheet;

	static JavascriptExecutor js;
 
	public void switchToFrame() {

		driver.switchTo().frame("mainpanel");

	}
 
	public static Object[][] getTestData(String sheetName) {

		FileInputStream file = null;

		try {

			file = new FileInputStream(TESTDATA_SHEET_PATH);

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		}

		try {

			book = WorkbookFactory.create(file);

		} catch (InvalidFormatException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		sheet = (Sheet) book.getSheet(sheetName);

		Object[][] data = new Object[((org.apache.poi.ss.usermodel.Sheet) sheet).getLastRowNum()][((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(0).getLastCellNum()];

		// System.out.println(sheet.getLastRowNum() + "--------" +

		// sheet.getRow(0).getLastCellNum());

		for (int i = 0; i < ((org.apache.poi.ss.usermodel.Sheet) sheet).getLastRowNum(); i++) {

			for (int k = 0; k < ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(0).getLastCellNum(); k++) {

				data[i][k] = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(i + 1).getCell(k).toString();

				// System.out.println(data[i][k]);

			}

		}

		return data;

	}
 
	public static void takeScreenshotAtEndOfTest() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String currentDir = System.getProperty("user.dir");

		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));

	}
 
	public static void runTimeInfo(String messageType, String message) throws InterruptedException {

		js = (JavascriptExecutor) driver;

		// Check for jQuery on the page, add it if need be

		js.executeScript("if (!window.jQuery) {"

				+ "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"

				+ "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"

				+ "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");

		Thread.sleep(5000);
 
		// Use jQuery to add jquery-growl to the page

		js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");
 
		// Use jQuery to add jquery-growl styles to the page

		js.executeScript("$('head').append('<link rel=\"stylesheet\" "

				+ "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");

		Thread.sleep(5000);
 
		// jquery-growl w/ no frills

		js.executeScript("$.growl({ title: 'GET', message: '/' });");

//'"+color+"'"

		if (messageType.equals("error")) {

			js.executeScript("$.growl.error({ title: 'ERROR', message: '"+message+"' });");

		}else if(messageType.equals("info")){

			js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");

		}else if(messageType.equals("warning")){

			js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");

		}else

			System.out.println("no error message");

		// jquery-growl w/ colorized output

//		js.executeScript("$.growl.error({ title: 'ERROR', message: 'your error message goes here' });");

//		js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");

//		js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");

		Thread.sleep(5000);

	}


// this is page object model page - it consists of locators and actions
 
	// FindBy - Page Factory - ObjectRepo
 
	@FindBy(name = "email")

	WebElement username;
 
	@FindBy(name = "password")

	WebElement password;
 
	@FindBy(xpath = "//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")

	WebElement signUpBtn;
 
	@FindBy(xpath = "//span[contains(text(),'Log In')]")

	WebElement loginbutton;
 
	@FindBy(xpath = "(//a[@class = 'brand-name'])[1]")

	WebElement logo;
 
	// Initializing the Page Objects:

	public void Loginpage() throws IOException {

		PageFactory.initElements(driver, this);

	}
 
	// Actions
 
	// verify the page title
 
	public String validateLoginPageTitle() {
 
		return driver.getTitle();
 
	}
 
	// verify the logo presence
 
	public boolean validateCRMImage() {
 
		return logo.isDisplayed();
 
	}
 
	// verify the login functionlaity
 
	public homepage login(String un, String pwd) {
 
		signUpBtn.click();

		username.sendKeys(un);

		password.sendKeys(pwd);

		loginbutton.click();
 
		return new homepage();
 
	}
}