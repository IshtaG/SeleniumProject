import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pcpower\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(5)));

		driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.cssSelector("a.blinkingText")).click();
		
		Set<String> windows = driver.getWindowHandles();//gets parenID and childID of window.
		
		Iterator<String> it = windows.iterator();
		
		String parentID = it.next();
		
		String childID = it.next();
		
		driver.switchTo().window(childID);
		
		System.out.println(driver.findElement(By.cssSelector("p.im-para.red a")).getAttribute("href"));
		
		String emailID = driver.findElement(By.cssSelector("p.im-para.red a")).getAttribute("href").split(":")[1].trim();
		
		System.out.println(emailID);
		
		driver.switchTo().window(parentID);//switch to parent window tab
		
		driver.findElement(By.id("username")).sendKeys(emailID);
		
	}
	
	

}
