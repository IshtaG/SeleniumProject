import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pcpower\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("checkBoxOption1")).click();
		
		System.out.println(driver.findElement(By.id("checkBoxOption1")).getAttribute("value"));
		String option = driver.findElement(By.id("checkBoxOption1")).getAttribute("value");
		
		WebElement list = driver.findElement(By.id("dropdown-class-example"));
		
		Select dropdown = new Select(list);
		
		dropdown.selectByValue(option);
		
		driver.findElement(By.id("name")).sendKeys(option);

		driver.findElement(By.id("alertbtn")).click();
		
		System.out.println(driver.switchTo().alert().getText());
		
		if(driver.switchTo().alert().getText().contains(option))
			
		{
			System.out.println("present");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);

		}
		
		driver.switchTo().alert().accept();


		
	}

}
