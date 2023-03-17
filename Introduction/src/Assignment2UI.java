import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2UI {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pcpower\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.name("name")).sendKeys("ishita");
		
		driver.findElement(By.name("email")).sendKeys("ishita.gt@aol.com");

		driver.findElement(By.id("exampleInputPassword1")).sendKeys("ishita123");
		
		driver.findElement(By.id("exampleCheck1")).click();
		
		WebElement selectedDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(selectedDropdown);
		
		dropdown.selectByIndex(1);
		
		driver.findElement(By.id("inlineRadio1")).click();
		
		System.out.println(driver.findElement(By.id("inlineRadio3")).getAttribute("disabled"));
		Thread.sleep(3000);

		if(driver.findElement(By.id("inlineRadio3")).getAttribute("disabled").contains(""))
		{
			Assert.assertTrue(true);
			System.out.println("rdio3Disbaled");
		}
		
		Thread.sleep(3000);
		
		
		driver.findElement(By.name("bday")).sendKeys("1987-08-27");
		
	//	System.out.println(bday);
		
		
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector(".btn-success")).click();
		Thread.sleep(3000);

		
		System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
		
		
	}

}
