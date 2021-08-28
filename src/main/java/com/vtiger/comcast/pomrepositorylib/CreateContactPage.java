package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	WebDriver driver;
	public CreateContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement ContLastname;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]' and @name='button']")
	private WebElement SaveContBtn;
	
	public WebElement getContLastname() {
		return ContLastname;
	}

	public WebElement getSaveContBtn() {
		return SaveContBtn;
	}
	
	public void createContactWithLastname(String lastname) {
		ContLastname.sendKeys(lastname);
		SaveContBtn.click();
	}
	
}
