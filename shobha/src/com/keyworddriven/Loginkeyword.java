package com.keyworddriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Loginkeyword {
	WebDriver driver=null;
	String url="https://opensource-demo.orangehrmlive.com/";
	public void launchbrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\eclipse-workspace\\shobha\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void navigate()
	{
		driver.get(url);
	}
	public void enterusername()
	{
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	}
	public void enterpassword()
	{
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	}
	public void clicklogin()
	{
		driver.findElement(By.name("Submit")).click();
	}
}
