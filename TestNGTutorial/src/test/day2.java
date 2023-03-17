package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class day2 {

@BeforeClass
public void beforeClass1()
{
	System.out.println("I will execute before all the methods in this class");
}

@AfterClass(timeOut = 4000)//wait 40 sec before failing 
public void afterClass1()
{
	System.out.println("I will execute after all the methods in this class");
}

@Test(dependsOnMethods = {"secondTest1"})
	public void Demo1()
{
System.out.println("hi");
}

@Test(dataProvider = "getData")
public void secondTest1(String usrname,String password)
{
	System.out.println("bye");
	System.out.println(usrname);
	System.out.println(password);

}

@Test(enabled = true)
public void ThirdTest1()
{
	System.out.println("enable");
}
@BeforeTest
public void delete1()
{
	System.out.println("delete data");
}

@AfterTest
public void aftertst1()
{
	System.out.println("execute last");
	
}

@BeforeSuite
public void beforeSuite1()
{
	System.out.println("runs first");
}

@AfterSuite

public void afterSuite1()
{
	System.out.println("prints after suits");
}

@BeforeMethod
public void beforeMethod1()
{
	System.out.println("I will execute before every methods in this class");
}

@AfterMethod
public void aftermethod1()
{
	System.out.println("I will execute after every methods in this class");
}

@DataProvider
public Object[][] getData()
{
	//1st combination is testing with username and password---good credit history
	//2nd --username and password--no credit history
	//3rd username and password--fraudelent credit hitory
	
	Object[][] data = new Object [3][2];
	
	data[0][0]="firstusername";
	data[0][1]="firstpassword";
	
	data[1][0] = "secondusername";
	data[1][1] = "secondpassword";
	
	data[2][0] = "Thirdusername";
	data[2][1] = "Thirdpassword";

return data;
	
}

}
