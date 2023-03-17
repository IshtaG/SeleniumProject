package rahulshettyacademy.pageobjects;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Abstractcomponents.AbstractComponent;

public class CheckCartProducts extends AbstractComponent {
	
WebDriver driver;
	
	public CheckCartProducts(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(css=".cartSection h3")
	List<WebElement> products;
	
	//@FindBy(css="[routerlink*='cart']")
	 //WebElement cartPoduct;
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	 WebElement cartPoduct;
	
	
	@FindBy(css=".totalRow button")
	 WebElement checkout;
	
	@FindBy(css="[placeholder='Select Country']")
	 WebElement country;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	 WebElement countrymatch;
	
	@FindBy(css=".action__submit")
	 WebElement submit;
	
	@FindBy(css=".hero-primary")
	WebElement text;
	
	By result = By.cssSelector(".ta-results");
	
	public void clickCartButton()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", cartPoduct);
		//cartPoduct.click();
		
	}
	
	public void checkout()
	{

		checkout.click();

	}
	

	public List<WebElement> getProductList()
	{
		
		return products;
	}
	
	public Boolean checkProductAdded(String productName)
	{

		//List <WebElement> cartProd = products;
		Boolean match = getProductList().stream().anyMatch(product->product.getText().equals(productName));
		
		return match;
	}

	public void checkoutPage() throws InterruptedException {
		
		Actions a = new Actions(driver);	

		a.sendKeys(country, "India").build().perform();
				 
		 waitForElementToAppear(result);
		
		countrymatch.click();
		
		submit.click();
		
		
	}
	
	
	
	
	
	
	public String getText()
	{
		String text1 = text.getText();
		
		return text1;
	}
	
	
	
}
