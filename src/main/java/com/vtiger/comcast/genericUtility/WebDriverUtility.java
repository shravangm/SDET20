package com.vtiger.comcast.genericUtility;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	/**
	 * method used to maximize
	 * @param driver
	 */
	public void toMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * this method is used for 20 seconds page loading
	 * @param driver
	 */
	public void waitUntilPageLoad(WebDriver driver)
	   {
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   
	   }
	   
	/**
	 * This method is used for element visibility (explicit wait)   
	 * @param driver
	 * @param element
	 */
	public void waitForElementVisibility(WebDriver driver,WebElement element)
	   {
		  WebDriverWait wait = new WebDriverWait(driver, 20);
		  wait.until(ExpectedConditions.visibilityOf(element));
	   }

	/**
	 * this method is used for custom wait. It will wait for element click (avoid elementClickInterceptedException)
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException
	   {
		   int count = 0;
	       while(count<20) {
		    	   try {
		    	       element.click();
		    	       break;
		    	   }catch(Throwable e){
		    		   Thread.sleep(1000);
		    		   count++;
		    	   }
	       }
	       
	   }
		
	/**
	 * this method is used to handle dropdown list using visible text  
	 * @param element
	 * @param option
	 */
	public void select(WebElement element, String option)
	   {
		   Select select=new Select(element);
		   select.selectByVisibleText(option);
		   
	   }
	   
	/**
	 * this method is used to handle dropdown list using index  
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index)
	   {
		   Select select=new Select(element);
		   select.selectByIndex(index);   
	   }

	/**
	 * this method is used to mouse hover actions   
	 * @param driver
	 * @param element
	 */
	public void mouseOver(WebDriver driver,WebElement element)
	   {
		   Actions act = new Actions(driver);
		   act.moveToElement(element).perform();
		   
	   }
	/**
	 * method used to perform right click
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	   {
		   Actions act = new Actions(driver);
		   act.contextClick(element).perform();
	   }
	
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	   {
		   Set<String> window = driver.getWindowHandles();
		   Iterator<String> it = window.iterator();
		   while(it.hasNext())
		   {
			   String winId=it.next();
			   String title=driver.switchTo().window(winId).getTitle();
	           if(title.contains(partialWinTitle))
	           {
	        	   break;
	           }
			   
		   }
		   
	   }

	/**
	 * method is used to accept the alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	   {
		   driver.switchTo().alert().accept();
	   }

	/**
	 * method used to cancel the alert
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	   {
		   driver.switchTo().alert().dismiss();
	   }

	/**
	 * methos is used to do scrolling actions
	 * @param driver
	 * @param element
	 */
	public void scrollToWebElement(WebDriver driver, WebElement element) {
		  JavascriptExecutor jse=(JavascriptExecutor)driver;
		  int y= element.getLocation().getY();
		  jse.executeScript("window.scrollBy(0,"+y+")", element);
	   }

    /**
     * method used to switch to a frame using index
     * @param driver
     * @param index
     */
	public void switchFrame(WebDriver driver,int index) {
    	driver.switchTo().frame(index);
    }  

	/**
	 * method is used to switch to an element in a frame
	 * @param driver
	 * @param element
	 */
	public void switchFrame(WebDriver driver,WebElement element) {
    	driver.switchTo().frame(element);
    } 

	/**
	 *method is used to switch to a frame using id or name 
	 * @param driver
	 * @param idOrName
	 */
	public void switchFrame(WebDriver driver,String idOrName) {
    	driver.switchTo().frame(idOrName);
    } 

	/**
	 * method is used to take screenshots
	 * @param driver
	 * @param screenshotName
	 * @throws Throwable
	 */
	public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	File src=ts.getScreenshotAs(OutputType.FILE);
    	File dest=new File("./screenshot/"+screenshotName+".PNG");
    	Files.copy(src, dest);
    }

	/**
	 * method used to press enter key into the Browser
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver) {
		   Actions actions = new Actions(driver);
		   actions.sendKeys(Keys.ENTER).perform();
	   } 

	
}
