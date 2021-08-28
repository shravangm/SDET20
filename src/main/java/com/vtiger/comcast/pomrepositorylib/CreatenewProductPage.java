package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatenewProductPage {
	WebDriver driver;
	public CreatenewProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="productname")
	private WebElement productname;
	
	@FindBy(xpath="//input[@name='button' and @title='Save [Alt+S]']")
	private WebElement saveProductbtn;
	public WebElement getProductname() {
		return productname;
	}

	public WebElement getSaveProductbtn() {
		return saveProductbtn;
	}
	
	public void creatingewProduct(String prodName) {
		productname.sendKeys(prodName);
		saveProductbtn.click();
	}
	
}
