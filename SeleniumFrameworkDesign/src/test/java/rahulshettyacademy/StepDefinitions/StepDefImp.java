package rahulshettyacademy.StepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CheckCartProducts;
import rahulshettyacademy.pageobjects.Loginpage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class StepDefImp extends BaseTest{
	
	public Loginpage login;
	public CheckCartProducts checkCart;
	@Given ("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException
	
	{
		login = lauchApplication();
	}
	
	@Given("^Logged in with username(.+) and password(.+)$")
	public void Logged_in_with_username_and_pwd(String username, String password) {
		login.Loginapplication(username, password);
	}
	
	@When("^I add the product (.+) to cart$")
	public void I_add_the_product_to_cart(String productName)
	{
		ProductCatalogue prodcatalogue = new ProductCatalogue(driver);
		List<WebElement> products = prodcatalogue.getProductList();
		prodcatalogue.addProductToCart(productName);
	}
	
	
	@When("^chckout (.+) and submit the order$")
	public void chckout_productName_and_submit_the_order(String productName) throws InterruptedException
	{
		checkCart = new CheckCartProducts(driver);

		checkCart.clickCartButton();
		Boolean match = checkCart.checkProductAdded(productName);
		Assert.assertTrue(match);
		checkCart.checkout();
		checkCart.checkoutPage();
		
	}
	
    @Then("{string} message displayed on confirmation page")
    public void message_displayed_on_confirmation_page(String string)
    {
    	String text = checkCart.getText();
		Assert.assertEquals(text, string);
		driver.close();
    }
    
    
    @Then("{string} message is displayed")
    public void message_is_displayed(String string)
    {
    		
    	Assert.assertEquals(string,login.getErrorMessage() );

    }
}
