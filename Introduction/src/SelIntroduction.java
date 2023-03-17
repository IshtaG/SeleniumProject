import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 */

/**
 * @author x-PC
 *
 */
public class SelIntroduction  {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//optional in selenium 4.0 or more
		//managed internally by new package in jars in SeleniumManager 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pcpower\\Desktop\\chromedriver.exe");
		//Invoking Browser
		//Chrome - ChromeDriver-->Methods
		
		//Firefox
		//geckodriver
		//webdriver.gecko.driver
		
		//microsoftEdge
		//msedgedriver
		//webdriver.edge.driver
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println("title"+" " +driver.getCurrentUrl());
		driver.close();
		//driver.quit();
	}

		
	

}
