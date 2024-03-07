package com.crm.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
public class SwagAddToCart extends TestBase{

	 
	//Page Factory - OR:
	@FindBy(xpath="(//div[@class = 'inventory_item_price'])[1]")
	WebElement itemprice;
	@FindBy(xpath="(//div[@class = 'inventory_item_name '])[1]")
	WebElement itemname;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	WebElement addtocart;

 
	@FindBy(xpath="//a[@class = 'shopping_cart_link']")
	WebElement cartlink;
	//Initializing the Page Objects:
	public SwagAddToCart(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	// Actions or the methods for add to cart page
	public void addtocart() {
		String itempr = itemprice.getText();
		String itemnm =  itemname.getText();
		addtocart.click();
		cartlink.click();


	}
}