import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class demo2 {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pcpower\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(8)));

		
		//count number of links 
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//count number of links in footer
		
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		 WebElement footerDriverColumn = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));

		 System.out.println(footerDriverColumn.findElements(By.tagName("a")).size());
		 
		 //check the links are working
		 
		 for(int i=1;i<footerDriverColumn.findElements(By.tagName("a")).size();i++)
			 
		 {
			 String clickonlinktab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			 
			 footerDriverColumn.findElements(By.tagName("a")).get(i).sendKeys(clickonlinktab);
			 
			 Thread.sleep(5000L);
			 
		 }
			 
			Set<String> windowstab =  driver.getWindowHandles();
			
			Iterator<String> it = windowstab.iterator();
			
			while(it.hasNext())
			{
				driver.switchTo().window(it.next());
				
				System.out.println(driver.getTitle());
			}
			
			 
			 
			 
		 }
	}


