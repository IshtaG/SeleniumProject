import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\pcpower\\Desktop\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
			js.executeScript("window.scrollBy(0,600)");
			
			int countRow = driver.findElements(By.xpath("//table[@name='courses'] /tbody/tr")).size();
			
			System.out.println(countRow);
			
			int countCol = driver.findElements(By.xpath("//table[@name='courses'] /tbody/tr/th")).size();
			
			System.out.println(countCol);
			
			String s1 = driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[3]/td")).getText();
			
		
			String s2 = driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[3]/td[2]")).getText();
		
			String s3 = driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[3]/td[3]")).getText();
			
			System.out.println(s1 + " "+ s2 + " " +s3);

	}

}
