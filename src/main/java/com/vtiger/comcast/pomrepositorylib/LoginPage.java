package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement UN;
	
	@FindBy(name="user_password")
	private WebElement Pwd;
	
	@FindBy(id="submitButton")
	private WebElement LoginBtn;

	public WebElement getUN() {
		return UN;
	}

	public WebElement getPwd() {
		return Pwd;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	
	public void LoginToApp (String username, String password) {
		UN.sendKeys(username);
		Pwd.sendKeys(password);
		LoginBtn.click();
	}
	
}
