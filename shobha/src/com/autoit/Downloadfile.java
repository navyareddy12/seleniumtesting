package com.autoit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Downloadfile {
WebDriver driver=null;
String url="https://www.seleniumhq.org/download/";

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
public void filedownload() throws IOException
{
	driver.findElement(By.xpath("//*[@id=\'mainContent\']/p[3]/a")).click();
	java.lang.Runtime.getRuntime().exec("C:\\Users\\user\\eclipse-workspace\\shobha\\auto\\filedownload.exe");
}
}
