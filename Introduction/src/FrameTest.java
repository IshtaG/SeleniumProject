import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pcpower\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://jqueryui.com/droppable/");
		
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		driver.findElement(By.id("draggable")).click();

		Actions a = new Actions(driver);
		
		WebElement src = driver.findElement(By.id("draggable"));
		
		WebElement target = driver.findElement(By.id("droppable"));

		
		a.dragAndDrop(src, target).build().perform();
		
		driver.switchTo().defaultContent();
	}

}
