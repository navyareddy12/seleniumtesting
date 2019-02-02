package com.OHRMlogintest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.sourceforge.cobertura.javancss.ccl.FileUtil;

public class OHRM_logintest {

	WebDriver driver=null;
	String url="https://opensource-demo.orangehrmlive.com/";
	String username="Admin";
	String password="admin";
	
	
	@Given("^open chrome browser and navigate to orangeHRM application$")
	public void open_chrome_browser_and_navigate_to_orangeHRM_application() { 
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\eclipse-workspace\\shobha\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^user enters valid username and password and click on signin button$")
	public void user_enters_valid_username_and_password_and_click_on_signin_button() { 
	
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.name("Submit")).click();
	}

	@Then("^user should be able to successfully login to the application and close the application$")
	public void user_should_be_able_to_successfully_login_to_the_application_and_close_the_application() throws IOException { 
	
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
				FileUtils.copyFile(screenshot, new File("C:\\Users\\user\\eclipse-workspace\\cucumberframework\\screenshots\\image.png"));
			System.out.println("fail");
			driver.quit();
		}
		
		
	}
		driver.quit();
	}

	
}
