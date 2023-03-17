import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 * 
 */

/**
 * @author x-PC
 *
 */
public class e2e {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pcpower\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

		driver.findElement(By.cssSelector("a[value='DEL']")).click();

		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();

		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("calendar is disabled");

			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);

		}

		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();

		driver.findElement(By.id("divpaxinfo")).click();

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		Thread.sleep(2000);

		for (int i = 1; i < 3; i++) {

			driver.findElement(By.id("hrefIncAdt")).click();

		}
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		driver.findElement(By.id("btnclosepaxoption")).click();

		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "3 Adult");

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		WebElement dropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select options = new Select(dropdown);

		options.selectByValue("USD");

		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

	}

}
