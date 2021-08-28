package pac1;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SelectDateMakeMyTripTest {

	public static void main(String[] args) {
		String date="31";
		String monthYear="December 2021";
				
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		Actions action= new Actions(driver);
		WebElement flighticon = driver.findElement(By.xpath("//span[text()='Flights']"));
		action.moveToElement(flighticon).click().perform();
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();

		String dateXpath = "//div[text()='"+monthYear+"']/ancestor::div[@class='DayPicker-Month']//p[text()='"+date+"']";
		String arrowXpath = "//span[@aria-label='Next Month']";
		
		for(;;) {
			try {
				driver.findElement(By.xpath(dateXpath)).click();
			} catch (Exception e) {
				driver.findElement(By.xpath(arrowXpath));
			}
		}
	}
}
