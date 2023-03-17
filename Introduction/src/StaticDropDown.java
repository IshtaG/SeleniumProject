import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 */

/**
 * @author x-PC
 *
 */
public class StaticDropDown {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pcpower\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//dropdown with select tag
		WebElement staticdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticdropdown);
		
		dropdown.selectByIndex(3);
		
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//selecting by visible text
		
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//selecting by value
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());

		

		
		
	}

}
