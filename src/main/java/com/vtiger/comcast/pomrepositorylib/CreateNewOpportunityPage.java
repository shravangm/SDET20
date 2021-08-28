package com.vtiger.comcast.pomrepositorylib;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOpportunityPage {
	public WebDriver driver;
	public CreateNewOpportunityPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//all elements found at first place
	@FindBy(name="potentialname")
	private WebElement OpporName;
	
	@FindBy(id="related_to_type")
	private WebElement orgDropDown;
	
	@FindBy(xpath="//select[@id='related_to_type']/../following-sibling::td//img")
	private WebElement organizationLookUpPage;

	@FindBy(linkText="TY")
	private WebElement orgnamelink;
	
	@FindBy(xpath="//input[@name='assigntype' and @value='T']")
	private WebElement assignedtoRadiobtn;
	
	@FindBy(name="assigned_group_id")
	private WebElement marketingGroupdropdown;
	
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[2]")
	private WebElement campsourcelookup;
	
	@FindBy(linkText="selltheproduct")
	private WebElement campname;
	
	@FindBy(name="sales_stage")
	private WebElement salesStageDropdown;
	
	@FindBy(xpath="//input[@name='button' and @type='submit']")
	private WebElement saveButton;
	
	//getters created
	public WebElement getOpporName() {
		return OpporName;
	}

	public WebElement getOrgDropDown() {
		return orgDropDown;
	}

	public WebElement getOrganizationLookUpPage() {
		return organizationLookUpPage;
	}
	
	public WebElement getOrgnamelink() {
		return orgnamelink;
	}

	public WebElement getAssignedtoRadiobtn() {
		return assignedtoRadiobtn;
	}

	public WebElement getMarketingGroupdropdown() {
		return marketingGroupdropdown;
	}

	public WebElement getCampsourcelookup() {
		return campsourcelookup;
	}

	public WebElement getCampname() {
		return campname;
	}

	public WebElement getSalesStageDropdown() {
		return salesStageDropdown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/**
	 * method is used to create a new opportunity with mandatory fields
	 * @param opname
	 */
	public void creatingnewopp(String opname) {
		OpporName.sendKeys(opname);
		
		Select s = new Select(orgDropDown); 
		s.selectByValue("Accounts");
		
		String parentWindowId = driver.getWindowHandle();
		organizationLookUpPage.click();
    	List<String> childWindowID = new ArrayList<String>(driver.getWindowHandles());
    	driver.switchTo().window(childWindowID.get(1));
    	orgnamelink.click();
    	driver.switchTo().window(parentWindowId);
    	
		assignedtoRadiobtn.click();
		Select s1= new Select(marketingGroupdropdown);
		s1.selectByVisibleText("Team Selling");	
		
		campsourcelookup.click();
		List<String> allwindowidlist1 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(allwindowidlist1.get(1));
		campname.click();
		
		driver.switchTo().window(parentWindowId);
		Select s2= new Select(salesStageDropdown);
		s2.selectByValue("Prospecting");
		
		saveButton.click();
		
	}
	
	public void createOppSalesStageQual(String opname) {
		OpporName.sendKeys(opname);
		
		Select s = new Select(orgDropDown); 
		s.selectByValue("Accounts");
		
		String parentWindowId = driver.getWindowHandle();
		organizationLookUpPage.click();
    	List<String> childWindowID = new ArrayList<String>(driver.getWindowHandles());
    	driver.switchTo().window(childWindowID.get(1));
    	orgnamelink.click();
    	driver.switchTo().window(parentWindowId);
    	
    	assignedtoRadiobtn.click();
		Select s1= new Select(marketingGroupdropdown);
		s1.selectByVisibleText("Team Selling");
    	
		campsourcelookup.click();
		List<String> allwindowidlist1 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(allwindowidlist1.get(1));
		campname.click();
		
		driver.switchTo().window(parentWindowId);
		Select s2= new Select(salesStageDropdown);
		s2.selectByValue("Qualification");
		
		saveButton.click();
	}
	
	public void createOppSalesStageAnalysis(String opname) {
		OpporName.sendKeys(opname);
		
		Select s = new Select(orgDropDown); 
		s.selectByValue("Accounts");
		
		String parentWindowId = driver.getWindowHandle();
		organizationLookUpPage.click();
    	List<String> childWindowID = new ArrayList<String>(driver.getWindowHandles());
    	driver.switchTo().window(childWindowID.get(1));
    	orgnamelink.click();
    	driver.switchTo().window(parentWindowId);
    	
    	assignedtoRadiobtn.click();
		Select s1= new Select(marketingGroupdropdown);
		s1.selectByVisibleText("Team Selling");
    	
		campsourcelookup.click();
		List<String> allwindowidlist1 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(allwindowidlist1.get(1));
		campname.click();
		
		driver.switchTo().window(parentWindowId);
		Select s2= new Select(salesStageDropdown);
		s2.selectByValue("Needs Analysis");
		
		saveButton.click();
	}
	
}
