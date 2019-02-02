package com.ohrmapplication;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OHRM_logintest {
	
	WebDriver driver=null;
	String url="https://opensource-demo.orangehrmlive.com/";
	String un="admin";
	String pw="password123";
	
	@Given("^open Chrome Browser and navigate to orangeHRM application$")
	public void open_Chrome_Browser_and_navigate_to_orangeHRM_application() 
	{
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\Cucumber1\\drivers\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^user enters valid username and password and click on signin button$")
	public void user_enters_valid_username_and_password_and_click_on_signin_button() 
	{
		driver.findElement(By.id("txtUsername")).sendKeys(un);
		driver.findElement(By.id("txtPassword")).sendKeys(pw);
		driver.findElement(By.id("btnLogin")).click();
	}

	@Then("^use should be able to succesfuly login to the application and close the application$")
	public void use_should_be_able_to_succesfuly_login_to_the_application_and_close_the_application() throws IOException
	{
		try
		{
			String et="welcome_admin";
			System.out.println(et);
			String at=driver.findElement(By.id("welcome")).getText();
			System.out.println(at);
			if(at.contains(et))
			{
			System.out.println("pass");	
			//<span id="spanMessage">Invalid credentials</span>
			}
	}
catch(Exception e) 
		{
	if(driver.findElement(By.id("spanMessage")).getText().equals("Invalid credentials"))
	{
		File sh=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
	FileUtils.copyFile(sh, new File("C:\\Users\\user\\eclipse-workspace\\Cucumber1\\sceen\\image.png"));
	System.out.println("fail");
	driver.close();
	}
}
		
	
}
}
