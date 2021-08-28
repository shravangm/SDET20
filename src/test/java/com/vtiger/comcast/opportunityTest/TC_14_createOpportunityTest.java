package com.vtiger.comcast.opportunityTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericUtility.ExcelUtility;
import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.JavaUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;
import com.vtiger.comcast.pomrepositorylib.CreateNewOpportunityPage;
import com.vtiger.comcast.pomrepositorylib.HomePage;
import com.vtiger.comcast.pomrepositorylib.LoginPage;
import com.vtiger.comcast.pomrepositorylib.OpportunitiesPage;
import com.vtiger.comcast.pomrepositorylib.OpportunitydetailsPage;

public class TC_14_createOpportunityTest {
	
	@Test
	public void CreateOppSalesstage() throws Throwable {
		
		FileUtility flib= new FileUtility();
		WebDriverUtility wdlib= new WebDriverUtility();
		ExcelUtility exlib= new ExcelUtility();
		JavaUtility jlib= new JavaUtility();
		
		String Browser = flib.getPropertyKeyValue("browser");
		String URL = flib.getPropertyKeyValue("url");
		String UN = flib.getPropertyKeyValue("username");
		String Pwd=flib.getPropertyKeyValue("password");
		
		WebDriver driver= new ChromeDriver();
		wdlib.toMaximize(driver);
		wdlib.waitUntilPageLoad(driver);
		driver.get(URL);
		
		String orgname = exlib.getDataFromExcel("Sheet1", 4, 2);
		
		LoginPage loginpage= new LoginPage(driver);
		loginpage.LoginToApp(UN, Pwd);
		
		HomePage homepage= new HomePage(driver);
		homepage.getOpportunitiesLink().click();
		
		OpportunitiesPage opportunitiespage= new OpportunitiesPage(driver);
		opportunitiespage.getCreateOppBtn().click();
		
		CreateNewOpportunityPage createNewOpp= new CreateNewOpportunityPage(driver);
		createNewOpp.createOppSalesStageQual(orgname);
		
		OpportunitydetailsPage OppDetailspage= new OpportunitydetailsPage(driver);
		String actualmsg = OppDetailspage.getSuccessMsg().getText();
		if(actualmsg.contains(orgname)) {
			System.out.println(orgname+"==>Created successfully");
		}else {
			System.out.println(orgname+"==>not created successfully");
		}
		
		homepage.Logout();
		driver.quit();		
	}
}
