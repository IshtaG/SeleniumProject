package rahulshettyacademy;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDemo {
	
@Test
public void titleCheck() throws MalformedURLException
{
	
	//DesiredCapabilities caps = new DesiredCapabilities();
	
	MutableCapabilities caps = new MutableCapabilities();

	WebDriver driver = new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"),caps);
	
	driver.get("https://www.google.com");
	
	Assert.assertTrue(driver.getTitle().matches("Google"));
}	
	

	
	

}
