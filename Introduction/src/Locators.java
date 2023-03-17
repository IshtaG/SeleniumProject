import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locators {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//implicit wait
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\pcpower\\Desktop\\chromedriver.exe");
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pcpower\\Desktop\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("ishita");
		
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("ishita.gt@aol.com");
		
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("ishita.gt@hotmail.com");
		
		//driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("6566662955");
		
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("6566662955");
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("ishita");
		
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.id("chkboxOne")).click();
		
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click(); //xpath regular exp
	
	//div[@class='forgot-pwd-btn-container']/button[1]
	}
	

}
