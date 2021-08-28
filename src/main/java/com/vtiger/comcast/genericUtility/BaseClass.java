package com.vtiger.comcast.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.vtiger.comcast.pomrepositorylib.HomePage;
import com.vtiger.comcast.pomrepositorylib.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	public FileUtility flib= new FileUtility();
	public JavaUtility jlib= new JavaUtility();
	public WebDriverUtility wdlib= new WebDriverUtility();
	public ExcelUtility exlib= new ExcelUtility();
	public int ranDomNum= jlib.getRanDomNumber();
	
	//@Parameters("browser")
	@BeforeClass (groups = {"smokeTest","regressionTest"})
	public void ConfigureBeforeClass() throws Throwable {
		
		String browser=flib.getPropertyKeyValue("browser");
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if (browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}else if (browser.equals("ie")) {
			driver=new InternetExplorerDriver();
		}else
			driver=new ChromeDriver();
		sdriver=driver;
		wdlib.toMaximize(driver);
		wdlib.waitUntilPageLoad(driver);
	}
	
	@BeforeMethod (groups = {"smokeTest","regressionTest"})
	public void ConfigBeforeMethod() throws Throwable {
		String Browser = flib.getPropertyKeyValue("browser");
		String URL = flib.getPropertyKeyValue("url");
		String UN = flib.getPropertyKeyValue("username");
		String Pwd = flib.getPropertyKeyValue("password");
		driver.get(URL);
		
		LoginPage loginpage= new LoginPage(driver);
		loginpage.LoginToApp(UN,Pwd);
	}
	
	@AfterMethod (groups = {"smokeTest","regressionTest"})
	public void ConfigAfterMethod() {
		HomePage homepage= new HomePage(driver);
		homepage.Logout();
	}
	
	@AfterClass (groups = {"smokeTest","regressionTest"})
	public void ConfigAfterClass() {
		driver.quit();
	}
}
