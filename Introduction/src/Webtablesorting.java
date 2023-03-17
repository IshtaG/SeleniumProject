import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Webtablesorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pcpower\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// click on the column

		driver.findElement(By.xpath("//tr/th[1]")).click();

		// capture webelements into new list

		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

		// capture text of all webelements into new list
		List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
		// sort in the list of step3-->sorted list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		// compare origina list with sorted list

		Assert.assertEquals(originalList, sortedList);
		
		List<String> price ;
	
		do {
			
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

		//scan the veg name column and get the text
	price = rows.stream().filter(s->s.getText().contains("Rice"))
			.map(s->getPriceVeggie(s)).collect(Collectors.toList());
		
		
		//if gets rice -> print price of Rice
	price.forEach(a->System.out.println(a));
	
	//Pagination
	
	if(price.size()<1)
	{
		driver.findElement(By.xpath("//ul/li[7]")).click();
	}

	}while(price.size()<1);

	}		
	
	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return pricevalue;
	}
	
	
	

}
