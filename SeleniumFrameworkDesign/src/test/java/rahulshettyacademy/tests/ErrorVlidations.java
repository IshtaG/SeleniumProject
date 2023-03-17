package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CheckCartProducts;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ErrorVlidations extends BaseTest {
	
	
	
	
	//wrong emailid and password
	@Test(groups= {"ErrorHandling"})
	public void LoginErrorValidation()
	{
		String productName = "ZARA COAT 3";
		login.Loginapplication("ishita.gt@email.com", "Ishi*25119");
		
	String	errmsg = login.getErrorMessage();
		
		Assert.assertEquals("Incorrect email or password.",errmsg );

	}
	
@Test
	
	public void ProductErrorValidation() throws IOException
	{
		// TODO Auto-generated method stub
		String productName = "ZARA COAT 3";

		//Loginpage login = lauchApplication();

		//Loginpage loginpage = new Loginpage(driver);

		// hit url
		//loginpage.goToURL();

		// login to application
		login.Loginapplication("ishita.gt@email.com", "Ishi*2512719");

		// get List of products appeared
		ProductCatalogue prodcatalogue = new ProductCatalogue(driver);

		List<WebElement> products = prodcatalogue.getProductList();

		prodcatalogue.addProductToCart(productName);

		CheckCartProducts checkCart = new CheckCartProducts(driver);

		//WebDriverWait(driver, 20).until(EC.element_to_be_clickable((By.CSS_SELECTOR, "label[for$='_StateNetDB_ckBxAllTopics']"))).click();

		checkCart.clickCartButton();

		Boolean match = checkCart.checkProductAdded("ZARA COAT 33");

		Assert.assertFalse(match);
		
	}



}
