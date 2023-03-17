import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	

		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pcpower\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://google.com");//selinium will wait untill page load
		
		driver.navigate().to("https://rahulshettyacademy.com");
		
		driver.navigate().back();
		
		driver.navigate().forward();
	}

}
