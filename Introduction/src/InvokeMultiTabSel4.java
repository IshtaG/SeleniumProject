import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InvokeMultiTabSel4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pcpower\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		
	Set <String> handles = 	driver.getWindowHandles();
	
	 Iterator<String> it = handles.iterator();
	 
	 String parentTabId = it.next();
	 
	 String chilTab = it.next();
	 
	 driver.switchTo().window(chilTab);
	 
	 driver.get("https://rahulshettyacademy.com/");
	 
	String coursename =  driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(3).getText();
	 
	 driver.switchTo().window(parentTabId);
	 
	 WebElement name = driver.findElement(By.cssSelector("[name='name']"));
	 
	 name.sendKeys(coursename);
	 
	
	 //screen shot of name textbox
	 File file = name.getScreenshotAs(OutputType.FILE);
	 
	 
	 FileUtils.copyFile(file, new File("logo.png"));
	// driver.quit();
	 
	 //Get height and Width
	 
	System.out.println(name.getRect().getDimension().getHeight());
	
	System.out.println(name.getRect().getDimension().getWidth());

	}

}
