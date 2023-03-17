import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pcpower\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		System.out.println(driver.findElement(By.tagName("frame")).getSize());
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']"))).switchTo().frame("frame-middle");
		//System.out.println("middle");
		System.out.println(driver.findElement(By.id("content")).getText());
		
	}

}
