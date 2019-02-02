package Ohrmlogin.mymavenproject;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OHRMlogin {
	WebDriver driver=null;
	String url="https://opensource-demo.orangehrmlive.com/";
@BeforeTest
public void setup()
{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\eclipse-workspace\\shobha\\drivers\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
@Test
public void login()
{
	driver.findElement(By.id("txtUsername")).sendKeys("ggggg");
	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	driver.findElement(By.name("Submit")).click();
	
}
@AfterTest
public void teardown() throws IOException
{
	try {
		String exp_result="Welcome Admin";
		System.out.println(exp_result);
		String actual_result=driver.findElement(By.id("welcome")).getText();
		System.out.println(actual_result);
		if(actual_result.equals(exp_result))
		{
			System.out.println("pass");
		}
		}
		catch(Exception e)
		{
			if(driver.findElement(By.id("spanMessage")).getText().equals("Invalid credentials"))
			{
				File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File("C:\\Users\\user\\eclipse-workspace\\mymavenproject\\screenshots\\image.png"));
			System.out.println("fail");
			driver.quit();
		}
		
		
	}
		driver.quit();
	}

}


