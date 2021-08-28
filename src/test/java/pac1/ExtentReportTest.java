package pac1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mysql.cj.jdbc.Driver;

public class ExtentReportTest {
	WebDriver driver;
	ExtentHtmlReporter reporter;
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeSuite
	public void configBS() {
		
		reporter= new ExtentHtmlReporter("../SeleniumSDET20/ExtentReportsSDET20/EXTENT.html");
		reporter.config().setDocumentTitle("SDET");
		reporter.config().setTheme(Theme.DARK);
		
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		
		
		
		System.out.println("====Executed before suite====");
	}
	
	@BeforeClass
	public void configBC() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void configBM() {
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
	}
	
	@Test
	public void extentReportHomepageTitle() {
		reports.createTest("extentReportHomepageTitle");
		String ExpectedTitle = "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
		String actualTitle = driver.getTitle();
		
		System.out.println("Expected Title is "+ExpectedTitle);
		System.out.println("actual Title is "+actualTitle);
		
		/*
		 * if(actualTitle.equals(ExpectedTitle)) {
		 * System.out.println("PASS: the title is correct"); }else
		 * System.out.println("FAIL: the title is incorrect");
		 */
		Assert.assertEquals(actualTitle, ExpectedTitle);
	}
	
	@Test
	public void extentReportOrgnPageTitle() {
		reports.createTest("extentReportOrgnPageTitle");
		driver.findElement(By.linkText("Organizations")).click();
		String ExpectedTitle="Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM";
		String ActualTitle = driver.getTitle();
		
		System.out.println("Expected Title is "+ExpectedTitle);
		System.out.println("Actual Title is "+ActualTitle);
		
		/*
		 * if(ActualTitle.equals(ExpectedTitle)) {
		 * System.out.println("PASS: title is correct"); }else
		 * System.out.println("FAIL- title is incorrect");
		 */		
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	@AfterMethod
	public void configAM() {
		Actions actions= new Actions(driver);
		WebElement administratorImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		actions.moveToElement(administratorImg).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	}
	
	@AfterClass
	public void configAC() {
		driver.quit();
	}
	
	@AfterSuite
	public void configAS() {
		reports.flush();
		System.out.println("====Execute afer suite====");
	}
	
}
