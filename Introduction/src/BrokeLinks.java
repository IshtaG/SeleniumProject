import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokeLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pcpower\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//broken url
		
		//step 1 is to get all url of all links
		//Java methid to call urls and get status cod eif 404 then broken
		
		
		
		
	List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
	
	SoftAssert a = new SoftAssert();
	for(WebElement link:links)
	{
		String url = link.getAttribute("href");
		
		HttpURLConnection connection =(HttpURLConnection) new URL(url).openConnection();
		
		connection.setRequestMethod("HEAD");
		connection.connect();
		
		int respcode = connection.getResponseCode();
		
		System.out.println(respcode);
		
		a.assertTrue(respcode <400, "broken link" +respcode);
		
	}
	
	a.assertAll();

		
	//	String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
	
	

	}

}
