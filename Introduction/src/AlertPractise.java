import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertPractise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String name= "ishita";
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pcpower\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(1000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		
		driver.findElement(By.id("name")).sendKeys(name);

		driver.findElement(By.id("confirmbtn")).click();
		
		Thread.sleep(1000);

		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();




	}

}
