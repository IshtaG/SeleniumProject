import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumPractise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pcpower\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		WebDriverWait w = new  WebDriverWait(driver,Duration.ofSeconds(5));

		
		//implicit wait
		//driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(5)));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		String[] itemsNeeded = {"Cucumber", "Brocolli","Beetroot","Carrot"};
		Thread.sleep(3000);

		addItems(driver,itemsNeeded);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));

		
		
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.className("promoBtn")).click();
		
		//explicit wait
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		
		
		
	}

	
	public static void addItems(WebDriver driver,String[] itemsNeeded)
	{

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		int j = 0;

		for (int i = 0; i < products.size(); i++) {
			String name = products.get(i).getText();	

			// split string

			String[] arrName = name.split("-");
			String formattedName = arrName[0].trim();

			// format it to proper product name

			// check if name present in itemsneeded list

			// convert array into arraylists

			List itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(formattedName)) {
				j++;
				// add to cart

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == itemsNeeded.length) {
					break;
				}
			}
		}


	}
}
