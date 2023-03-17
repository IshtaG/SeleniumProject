import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class FilterWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//filter the webtable
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pcpower\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.id("search-field")).sendKeys("Rice");

	List<WebElement> items	= driver.findElements(By.xpath("//tr/td[1]"));
	
	List<WebElement> riceItems = items.stream().filter(s->s.getText().contains("Rice"))
			.collect(Collectors.toList());
	
	Assert.assertEquals(items.size(), riceItems.size());
	}

}
