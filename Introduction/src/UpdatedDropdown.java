import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class UpdatedDropdown {
//TestNG is one of the testing framework
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pcpower\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();

		System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

		// System.out.println("calendar"+driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		// System.out.println("calendar"+driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		// count the number of checkboxes
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

		driver.findElement(By.id("divpaxinfo")).click();

		Thread.sleep(2000);
		int i = 1;

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		while (i < 5) {
			driver.findElement(By.id("hrefIncAdt")).click();// 4 adults selected
			i++;
		}

		driver.findElement(By.id("btnclosepaxoption")).click();

		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

	}

}
