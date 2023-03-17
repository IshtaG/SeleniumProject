import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Cookiesmximize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pcpower\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
			

		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
	//	driver.manage().deleteCookieNamed("sessionkey");
		
		driver.get("https://google.com/");

		
		

		//screen-shot
	}

}
