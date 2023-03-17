import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Selenium4NewFeatures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pcpower\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
		
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		
		//below
		
		WebElement dateofbirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateofbirth)).click();
		
		//left
		
		WebElement icecreamLabel = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(icecreamLabel)).click();
		
		//right
		
		WebElement radio = driver.findElement(By.id("inlineRadio1"));
		
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radio)).getText());

	}

}
