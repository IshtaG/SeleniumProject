import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RSATEST {

@Test
public void HomePageCheck() throws MalformedURLException
{
	DesiredCapabilities ds = new DesiredCapabilities();
	ds.setBrowserName("chrome");
	WebDriver driver = new RemoteWebDriver(new URL("http://10.0.0.16:4444"),ds);
	driver.get("https://rahulshettyacademy.com");
	//driver.findElement(By.name("q")).sendKeys("Ishita Gupta");
	
	System.out.println(driver.getTitle());

}
}