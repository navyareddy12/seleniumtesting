package com.autoit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Uploadimage {

	WebDriver driver=null;
	String url="https://imgur.com";
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\eclipse-workspace\\shobha\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
@Test(priority=0)
public void uploadfile()
{
	driver.findElement(By.className("Button-label")).click();
}
@Test(priority=1)
public void browser() throws IOException
{
	driver.findElement(By.className("browse-btn")).click();
	java.lang.Runtime.getRuntime().exec("C:\\Users\\user\\eclipse-workspace\\shobha\\auto\\autoit.exe");
}
}