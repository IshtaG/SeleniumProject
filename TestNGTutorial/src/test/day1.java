package test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class day1 {

@BeforeClass
public void beforeClass()
{
	System.out.println("I will execute before all the methods in this class");
}

@AfterClass
public void afterClass()
{
	System.out.println("I will execute after all the methods in this class");
	System.out.println("I will execute after all the methods in this class");

}


@Parameters({"URL","UserName"})
@Test(groups = {"Smoke"})

	public void Demo(String URL,String UserName)
	{
	
	System.out.println(URL);

System.out.println(UserName);
}



@Test
public void secondTest()
{
	//Assert.assertTrue(false);
	System.out.println("bye");
}


@BeforeTest
public void delete()
{
	System.out.println("delete data");
}

@AfterTest
public void aftertst()
{
	System.out.println("execute last");
	
}

@BeforeSuite
public void beforeSuite()
{
	System.out.println("runs first");
}

@AfterSuite

public void afterSuite()
{
	System.out.println("prints after suits");
}

@BeforeMethod
public void beforeMethod()
{
	System.out.println("I will execute before every methods in this class");
}

@AfterMethod
public void aftermethod()
{
	System.out.println("I will execute after every methods in this class");
}



}
