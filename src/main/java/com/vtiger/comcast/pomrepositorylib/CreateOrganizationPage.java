package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	WebDriver driver;
	public CreateOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement Orgname;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]' and @ name='button']")
	private WebElement OrgSaveBtn;
	
	@FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']")
	private WebElement homeBtnInOrgDetails;
	
	public WebElement getOrgname() {
		return Orgname;
	}

	public WebElement getOrgSaveBtn() {
		return OrgSaveBtn;
	}
		
	public WebElement getHomeBtnInOrgDetails() {
		return homeBtnInOrgDetails;
	}

	public void CreateorgForOpp(String orgnName) {
		Orgname.sendKeys(orgnName);
		OrgSaveBtn.click();
	}
	
}
