import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GoogleTest {

@Test
public void HomePageCheck() throws MalformedURLException
{
	DesiredCapabilities ds = new DesiredCapabilities();
	ds.setBrowserName("firefox");
	WebDriver driver = new RemoteWebDriver(new URL("http://10.0.0.16:4444"),ds);
	driver.get("https://www.google.com/?gws_rd=ssl");
	driver.findElement(By.name("q")).sendKeys("Ishita Gupta");
	
	System.out.println(driver.getTitle());

}
}