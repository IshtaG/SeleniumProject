package rahulshettyacademy.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.Loginpage;

public class BaseTest {

	public WebDriver driver;
	
	public Loginpage login;

	public WebDriver Initializedriver() throws IOException {

		// properties class can read global properties

		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\pcpower\\Desktop\\SeleniumTraining\\SeleniumFrameworkDesign\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties");

		prop.load(file);

		String browserNme = prop.getProperty("browser");

		if (browserNme.contains("firefox")) {
			
			FirefoxOptions options = new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();
			
			if(browserNme.equalsIgnoreCase("headless"))
			{
			options.addArguments("headless");
			}
			driver = new FirefoxDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();
		
		return driver;
	}
	
	public List<HashMap<String,String>> getJsonDataToMap(String filePath) throws IOException
	{
		//read json to string
	String jsonContent=FileUtils.readFileToString(new File(filePath),
			StandardCharsets.UTF_8);
	
	//Convert String to hashmap jacksondataBind
	
	ObjectMapper mapper = new ObjectMapper();
	
	List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>() 
	
	{
		
	});
	return data;
	}
	@BeforeMethod(alwaysRun = true)
	public Loginpage lauchApplication() throws IOException
	{
		driver = Initializedriver();
		login = new Loginpage(driver);
		login.goToURL();
		return login;
	}
	
	public String getScreenShot(String testCaseName,WebDriver driver) throws IOException
	{
		 TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		 File dest = new File(System.getProperty("user.dir") + "//reports" + testCaseName + ".png");
		 FileUtils.copyFile(source, dest);
		 
		 return System.getProperty("user.dir") + "//reports" + testCaseName + ".png";
				
	}
}
