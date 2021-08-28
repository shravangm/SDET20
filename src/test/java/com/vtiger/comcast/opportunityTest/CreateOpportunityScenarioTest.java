package com.vtiger.comcast.opportunityTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericUtility.BaseClass;
import com.vtiger.comcast.genericUtility.ExcelUtility;
import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.JavaUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;
import com.vtiger.comcast.pomrepositorylib.ContactsPage;
import com.vtiger.comcast.pomrepositorylib.CreateContactPage;
import com.vtiger.comcast.pomrepositorylib.CreateNewOpportunityPage;
import com.vtiger.comcast.pomrepositorylib.CreateOrganizationPage;
import com.vtiger.comcast.pomrepositorylib.HomePage;
import com.vtiger.comcast.pomrepositorylib.LoginPage;
import com.vtiger.comcast.pomrepositorylib.OpportunitiesPage;
import com.vtiger.comcast.pomrepositorylib.OpportunitydetailsPage;
import com.vtiger.comcast.pomrepositorylib.OrganizationsPage;

//@Listeners(com.vtiger.comcast.genericUtility.ListenerImpClass.class)
public class CreateOpportunityScenarioTest extends BaseClass {

	@Test (groups = "smokeTest")
	public void createOpportunityTest() throws Throwable {				
				
		String orgname = exlib.getDataFromExcel("Sheet1", 3, 2);
		String LastNameCnct = exlib.getDataFromExcel("Sheet1", 8, 1)+ranDomNum;
		String Organizationname = exlib.getDataFromExcel("Sheet1", 13, 1)+ranDomNum;

		HomePage homepage= new HomePage(driver);
		// for creating Contact and Orgn before getting into Opportunities
		
		/*
		 * homepage.getContactsLink().click(); ContactsPage cp= new
		 * ContactsPage(driver); cp.getCreateContactBtn().click(); CreateContactPage
		 * createcontpage= new CreateContactPage(driver);
		 * createcontpage.createContactWithLastname(LastNameCnct);
		 * homepage.getHomeBtnImg().click();
		 * 
		 * homepage.getOrganizationLink().click(); 
		 * OrganizationsPage OrgPage= new
		 * OrganizationsPage(driver); 
		 * OrgPage.getCreateOrgBtn().click();
		 * CreateOrganizationPage CreateOrgPage= new CreateOrganizationPage(driver);
		 * CreateOrgPage.CreateorgForOpp(Organizationname);
		 * CreateOrgPage.getHomeBtnInOrgDetails().click();
		 * 
		 * //homepage.getHomeBtnImg().click();
		 * 
		 * //now the contact and Orgn will be created before we create opportunities
		 * homepage= new HomePage(driver);
		 */
		homepage.getOpportunitiesLink().click();
		
		OpportunitiesPage opportunitiespage= new OpportunitiesPage(driver);
		opportunitiespage.getCreateOppBtn().click();
		
		CreateNewOpportunityPage createnewopportunity= new CreateNewOpportunityPage(driver);
		createnewopportunity.creatingnewopp(orgname);
		
		//for verification
		OpportunitydetailsPage oppinfopage= new OpportunitydetailsPage(driver);
		String actualsuccessmsg = oppinfopage.getSuccessMsg().getText();
		/*
		 * if(actualsuccessmsg.contains(orgname)) {
		 * System.out.println(orgname+"==> created successfully"); }else {
		 * System.out.println("FAIL: "+orgname+"=> not created successfully"); }
		 */
		boolean verifySuccessMsg = (actualsuccessmsg.contains(orgname));
		Assert.assertTrue(verifySuccessMsg);
		
	}
	
	@Test (groups = {"smokeTest","regressionTest"})
	public void CreateOppSalesStageQualTest() throws Throwable {
		String orgname = exlib.getDataFromExcel("Sheet1", 2, 2);
		String LastNameCnct = exlib.getDataFromExcel("Sheet1", 9, 1);
		String Organizationname = exlib.getDataFromExcel("Sheet1", 14, 1);
		
		HomePage homepage= new HomePage(driver);
		
		// for creating Contact and Orgn before getting into Opportunities
		/*
		 * homepage.getContactsLink().click(); ContactsPage cp= new
		 * ContactsPage(driver); cp.getCreateContactBtn().click(); CreateContactPage
		 * createcontpage= new CreateContactPage(driver);
		 * createcontpage.createContactWithLastname(LastNameCnct);
		 * homepage.getHomeBtnImg().click();
		 * 
		 * homepage.getOrganizationLink().click(); OrganizationsPage OrgPage= new
		 * OrganizationsPage(driver); OrgPage.getCreateOrgBtn().click();
		 * CreateOrganizationPage CreateOrgPage= new CreateOrganizationPage(driver);
		 * CreateOrgPage.CreateorgForOpp(Organizationname);
		 * homepage.getHomeBtnImg().click();
		 */
				
		//now the contact and Orgn will be created before we create opportunities
		
		homepage.getOpportunitiesLink().click();
		
		OpportunitiesPage opportunitiespage= new OpportunitiesPage(driver);
		opportunitiespage.getCreateOppBtn().click();
		
		CreateNewOpportunityPage createNewOpp= new CreateNewOpportunityPage(driver);
		createNewOpp.createOppSalesStageQual(orgname);
		
		OpportunitydetailsPage OppDetailspage= new OpportunitydetailsPage(driver);
		String actualmsg = OppDetailspage.getSuccessMsg().getText();
		/*
		 * if(actualmsg.contains(orgname)) {
		 * System.out.println(orgname+"==>Created successfully"); }else {
		 * System.out.println(orgname+"==>not created successfully"); }
		 */
		boolean successMsg = (actualmsg.contains(orgname));
		Assert.assertTrue(successMsg);
	}
	
	@Test (groups = {"regressionTest"})
	public void createNewOppSalesStageAnalysisTest() throws Throwable {
		String orgname = exlib.getDataFromExcel("Sheet1", 5, 2);
		String LastNameCnct = exlib.getDataFromExcel("Sheet1", 10, 1);
		String Organizationname = exlib.getDataFromExcel("Sheet1", 15, 1);
		
		HomePage homepage= new HomePage(driver);
		
		// for creating Contact and Orgn before getting into Opportunities
		/*
		 * homepage.getContactsLink().click(); ContactsPage cp= new
		 * ContactsPage(driver); cp.getCreateContactBtn().click(); CreateContactPage
		 * createcontpage= new CreateContactPage(driver);
		 * createcontpage.createContactWithLastname(LastNameCnct);
		 * homepage.getHomeBtnImg().click();
		 * 
		 * homepage.getOrganizationLink().click(); OrganizationsPage OrgPage= new
		 * OrganizationsPage(driver); OrgPage.getCreateOrgBtn().click();
		 * CreateOrganizationPage CreateOrgPage= new CreateOrganizationPage(driver);
		 * CreateOrgPage.CreateorgForOpp(Organizationname);
		 * homepage.getHomeBtnImg().click();
		 */
		//now the contact and Orgn will be created before we create opportunities
		
		homepage.getOpportunitiesLink().click();
		
		OpportunitiesPage opportunitiespage= new OpportunitiesPage(driver);
		opportunitiespage.getCreateOppBtn().click();
		
		CreateNewOpportunityPage createNewOpp= new CreateNewOpportunityPage(driver);
		createNewOpp.createOppSalesStageAnalysis(orgname);
		
		OpportunitydetailsPage OppDetailspage= new OpportunitydetailsPage(driver);
		String actualmsg = OppDetailspage.getSuccessMsg().getText();
		/*
		 * if(actualmsg.contains(orgname)) {
		 * System.out.println(orgname+"==>Created successfully"); }else {
		 * System.out.println(orgname+"==>not created successfully"); }
		 */
		boolean MsgSuccess = (actualmsg.contains(orgname));
		Assert.assertTrue(MsgSuccess);
	}

	
}