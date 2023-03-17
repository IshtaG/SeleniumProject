import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentExplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pcpower\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");
		
		WebDriverWait w = new  WebDriverWait(driver,Duration.ofSeconds(10));

		

		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.id("password")).sendKeys("learning");
		
		driver.findElement(By.cssSelector("input[value='user']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='You will be limited to only fewer functionalities of the app. Proceed?']")));

		System.out.println(driver.findElement(By.xpath("//p[text()='You will be limited to only fewer functionalities of the app. Proceed?']")).getText());

		
		driver.findElement(By.id("okayBtn")).click();
		
		WebElement options = driver.findElement(By.cssSelector("select.form-control"));
		
		Select dropDown = new Select(options);
		
		dropDown.selectByValue("consult");
		
		driver.findElement(By.id("terms")).click();
		
		driver.findElement(By.id("signInBtn")).click();

		w.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/angularpractice/shop"));


	
		String [] products = {"iphone X","Samsung Note 8","Nokia Edge","Blackberry"};
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));
		
		List<WebElement> productslist = driver.findElements(By.xpath("//div[@class='card-body']//a"));

		
		List productList = Arrays.asList(products);
		int j = 0;
		for(int i = 0;i<productslist.size();i++)
		{
			if(productList.contains(productslist.get(i).getText()))
					{
				j++;
				driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
					}
			
			if(j==products.length)
			{
				break;
			}
			
		}
		
		driver.findElement(By.partialLinkText("Checkout")).click();
		
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();

		
	}


		
		
}


