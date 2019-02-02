package com.navya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logingmail {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=null;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\eclipse-workspace\\shobha\\drivers\\chromedriver.exe");
		   driver=new ChromeDriver();
			driver.get("https://www.gmail.com");
			driver.manage().window().maximize();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\'identifierId\']")).sendKeys("navyaaileni027");
			driver.findElement(By.xpath("//*[@id=\'identifierNext\']/content/span")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\'password\']/div[1]/div/div[1]/input")).sendKeys("frootyreddy12");
		driver.findElement(By.xpath("//*[@id=\'passwordNext\']/content/span")).click();
		driver.close();
	}

}
