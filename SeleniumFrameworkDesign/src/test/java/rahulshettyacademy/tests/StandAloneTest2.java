package rahulshettyacademy.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CheckCartProducts;
import rahulshettyacademy.pageobjects.Loginpage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class StandAloneTest2 extends BaseTest{
	String productName = "ZARA COAT 3";
	@Test(dataProvider = "getData" , groups = {"purchaseOrder"})
	
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		

		//Loginpage login = lauchApplication();

		//Loginpage loginpage = new Loginpage(driver);

		// hit url
		//loginpage.goToURL();

		// login to application
		login.Loginapplication(input.get("email"), input.get("password"));

		// get List of products appeared
		ProductCatalogue prodcatalogue = new ProductCatalogue(driver);

		List<WebElement> products = prodcatalogue.getProductList();

		prodcatalogue.addProductToCart(input.get("productName"));

		CheckCartProducts checkCart = new CheckCartProducts(driver);

		checkCart.clickCartButton();

		Boolean match = checkCart.checkProductAdded(input.get("productName"));

		Assert.assertTrue(match);
		checkCart.checkout();

		checkCart.checkoutPage();

		String text = checkCart.getText();

		Assert.assertEquals(text, "THANKYOU FOR THE ORDER.");

	}
	
	//verify if zara coat 3 product is displayed in orders tab
	
	@Test(dependsOnMethods = {"submitOrder"})
	public void OrderHistoryTest()
	{
		login.Loginapplication("ishita.gt@email.com", "Ishi*2512719");
		OrderPage orderpage = login.goToOrdersPage();
		Assert.assertTrue(orderpage.verifyOrderDisplayed(productName));
		

	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		//HashMap<String,String> map = new HashMap<String,String>();
		
		/*
		 * map.put("email", "ishita.gt@email.com"); map.put("password", "Ishi*2512719");
		 * map.put("productName", "ZARA COAT 3");
		 * 
		 * HashMap<String,String> map1 = new HashMap<String,String>();
		 * 
		 * map1.put("email", "shetty@gmail.com"); map1.put("password", "Iamking@000");
		 * map1.put("productName", "ADIDAS ORIGINAL");
		 */
		
		List<HashMap<String,String>> data = getJsonDataToMap("C:\\Users\\pcpower\\Desktop\\SeleniumTraining\\SeleniumFrameworkDesign\\src\\test\\java\\rahulshettyacademy\\data\\Purchaseorder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}

	public String getScreenShot(String testCaseName) throws IOException
	{
		 TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		 File dest = new File(System.getProperty("user.dir") + "//reports" + testCaseName + ".png");
		 FileUtils.copyFile(source, dest);
		 
		 return System.getProperty("user.dir") + "//reports" + testCaseName + ".png";
				
	}
	
	//Extent Reports
	
}
