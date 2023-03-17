import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pcpower\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(5)));

		driver.findElement(By.xpath("//a[@href='/windows']")).click();

		driver.findElement(By.xpath("//a[@href='/windows/new']")).click();

		// String parentText =
		// driver.findElement(By.xpath("//div[@class='example']/h3")).getText();

		Set<String> windows = driver.getWindowHandles();// gets parenID and childID of window.

		Iterator<String> it = windows.iterator();

		String parentID = it.next();

		String childID = it.next();

		driver.switchTo().window(childID);

		String chilDtext = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();

		System.out.println(chilDtext);

		driver.switchTo().window(parentID);

		String parentText = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();

		System.out.println(parentText);

	}

}
