package rahulshettyacademy.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.Loginpage;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	String productName = "ZARA COAT 3";
	
	WebDriverManager.firefoxdriver().setup();
	
	WebDriver driver = new FirefoxDriver();

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.manage().window().maximize();
	driver.get("https://rahulshettyacademy.com/client");
	
	Loginpage loginpage = new Loginpage(driver);

	
	driver.findElement(By.xpath("//*[@id='userEmail']")).sendKeys("ishita.gt@email.com");
	
	driver.findElement(By.id("userPassword")).sendKeys("Ishi*2512719");
	
	driver.findElement(By.cssSelector("#login")).click();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

	
	List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	WebElement prod = products.stream().filter(product->
	product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	
	prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	//explicit wait
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	
	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));	
	
	driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

	List <WebElement> cartProd = driver.findElements(By.cssSelector(".cartSection h3"));
	Boolean match = cartProd.stream().anyMatch(product->product.getText().equals(productName));
	
	Assert.assertTrue(match);
	driver.findElement(By.cssSelector(".totalRow button")).click();
	
	
Actions a = new Actions(driver);	

a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();

driver.findElement(By.cssSelector(".action__submit")).click();

String text = driver.findElement(By.cssSelector(".hero-primary")).getText();

Assert.assertEquals(text, "Thankyou for the order.");

	}

}
