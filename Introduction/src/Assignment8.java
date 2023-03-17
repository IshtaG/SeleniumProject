import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pcpower\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		
		Thread.sleep(3000);
		
	List<WebElement> options = driver.findElements(By.cssSelector("ul[id='ui-id-1'] li"));
	
	//int f = options.size();
	
	for (WebElement option : options)
	{
		if(option.getText().equalsIgnoreCase("India"))
			
		{
			option.click();
			break;
		}
	}
		
		
	}

}
