package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Abstractcomponents.AbstractComponent;

public class Loginpage extends AbstractComponent{

	WebDriver driver;
	
	public Loginpage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement email = driver.findElement(By.xpath("//*[@id='userEmail']"));
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id ="login")
	WebElement submit;

	
	@FindBy(css ="[class*='flyInOut']")
	WebElement errorMessage;
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		errorMessage.getText();
		
		return errorMessage.getText();
	}
	
public void Loginapplication(String email,String password)


{
	userEmail.sendKeys(email);
	userPassword.sendKeys(password);
	submit.click();
}

public void goToURL()
{
	driver.get("https://rahulshettyacademy.com/client");

}

}

