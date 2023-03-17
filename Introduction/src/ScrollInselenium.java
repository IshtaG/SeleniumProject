import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class ScrollInselenium {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pcpower\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		
		 List<WebElement> value = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		 
		 int sum = 0;
		 for(int i =0;i<value.size();i++)
		 {
			 System.out.println(Integer.parseInt(value.get(i).getText()));
			 
			 sum = sum  + Integer.parseInt(value.get(i).getText());
		 }
		 
		 System.out.println(sum);
		 
		 String s = driver.findElement(By.cssSelector(".totalAmount")).getText();
		 
		 String [] arr = s.split(":");
		 
		 arr[1].trim();
		 
		 System.out.println(arr[1]);
		 
		 int total = Integer.parseInt(arr[1].trim());
		 
		 Assert.assertEquals(sum, total);
		 
		 System.out.println("passed");
		 
		 
	}
	
	

}
