import java.io.File;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import net.bytebuddy.implementation.bytecode.ShiftLeft;

public class actionsDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pcpower\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.com/");

		
		System.out.println(driver.findElement(By.xpath("//div[@class='a-row a-text-center']/img")).getAttribute("src"));
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);

		//File scr = img.getScreenshotAs(OutputType.FILE);
		
		//System.out.println(scr);
		
		//String path = "C:\\Users\\pcpower\\Desktop\\SeleniumTraining\\Introduction\\src\\captcha\\capcha.png";
		
		//driver.findElement(By.id("captchacharacters")).sendKeys(driver.findElement(By.xpath("//div[@class='a-row a-text-center']/img")).getAttribute("src"));
		Actions a = new Actions(driver);
		
		WebElement move = driver.findElement(By.id("nav-link-accountList"));
		
		
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		a.moveToElement(move).contextClick().build().perform();
		
		
		
	}

}
