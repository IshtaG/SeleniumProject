import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FirefoxOptions options = new FirefoxOptions();
		
		options.setAcceptInsecureCerts(true);
		
		Proxy proxy = new Proxy();

		proxy.setHttpProxy("ipaddress:4444");

		options.setCapability("proxy", proxy);

		Map<String, Object> prefs = new HashMap<String, Object>();
		
		prefs.put("download.default_directory", "/directory/path");
		
		// 	options.setExperimentalOption("prefs", prefs);
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pcpower\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver(options);
		
		driver.get("https://expired.badssl.com/");
		
		System.out.println(driver.getTitle());
	}

}
