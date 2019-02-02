package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Gmaillogin {
	WebDriver driver=null;
	String url="https://accounts.google.com/signin/v2/sl/pwd?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
@Test(priority=0)
public void setup()
{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\eclipse-workspace\\shobha\\drivers\\chromedriver.exe");
	  ChromeDriver driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
@Test(priority=1)
public void login()
{
	driver.findElement(By.className("whsOnd zHQkBf")).sendKeys("navyaaileni027");
	driver.findElement(By.className("RveJvd snByac")).click();
	driver.findElement(By.className("whsOnd zHQkBf")).sendKeys("frootyreddy12");
driver.findElement(By.className("RveJvd snByac")).click();
}
@AfterTest
public void teardown()
{
	driver.quit();
}

}
