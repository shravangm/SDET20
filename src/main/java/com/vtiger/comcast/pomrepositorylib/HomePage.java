package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']")
	private WebElement homeBtnImg;
	
	@FindBy(xpath="//a[text()='Opportunities']")
	private WebElement OpportunitiesLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLink;
	
	@FindBy(linkText="Organizations")
	private WebElement OrganizationLink;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLink;
	
	public WebElement getHomeBtnImg() {
		return homeBtnImg;
	}

	public WebElement getOpportunitiesLink() {
		return OpportunitiesLink;
	}
	
	public WebElement getProductsLink() {
		return productsLink;
	}
	
	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}
	
	public void Logout() {
		Actions action= new Actions(driver);
		action.moveToElement(administratorImg).perform();
		signoutLink.click();
	}
	
	
}
