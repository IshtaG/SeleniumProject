package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Abstractcomponents.AbstractComponent;

public class OrderPage extends AbstractComponent{
	
WebDriver driver;

@FindBy(css = "tr td:nth-child(3)")
List<WebElement> productList;

	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public Boolean verifyOrderDisplayed(String productName)
	{
		Boolean match = productList.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		return match;
	}
}
