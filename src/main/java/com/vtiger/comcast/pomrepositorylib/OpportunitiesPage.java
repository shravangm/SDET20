package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	public OpportunitiesPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Opportunity...']")
	private WebElement CreateOppBtn;
	
	public WebElement getCreateOppBtn() {
		return CreateOppBtn;
	}
	
	
	
	
}
