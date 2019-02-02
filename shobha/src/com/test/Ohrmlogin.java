package com.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ohrmlogin {
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
/*public void login() {
	driver.findElement(By.id("txtUsername")).sendKeys("admin");
	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	driver.findElement(By.name("Submit")).click();
}*/
@Test
public void login() throws IOException, InterruptedException
{
	FileInputStream file=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\shobha\\src\\com\\test\\loginvaliddata.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(file);
	XSSFSheet ws=wb.getSheet("Sheet1");
	FileInputStream file2=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\shobha\\src\\com\\test\\Ohrm.properties");
	Properties p=new Properties();
	p.load(file2);
	Row r=ws.getRow(1);
	Thread.sleep(5000);
	driver.findElement(By.id(p.getProperty("user"))).sendKeys(r.getCell(0).getStringCellValue());
	Thread.sleep(3000);
	driver.findElement(By.id(p.getProperty("password"))).sendKeys(r.getCell(1).getStringCellValue());
	driver.findElement(By.name(p.getProperty("submit"))).click();
	String exp_result="Welcome Admin";
	System.out.println(exp_result);
	String actual_result=driver.findElement(By.id("welcome")).getText();
	System.out.println(actual_result);
	if(actual_result.equals(exp_result))
	{
		System.out.println("pass");
		r.createCell(2).setCellValue("pass");
	}
	else
	{
		System.out.println("fail");
		r.createCell(2).setCellValue("fail");
	}
	FileOutputStream file1=new FileOutputStream("C:\\Users\\user\\eclipse-workspace\\shobha\\src\\com\\test\\loginvalidresultdata.xlsx");
	wb.write(file1);
	driver.findElement(By.id("welcome")).click();
	driver.findElement(By.linkText("Logout")).click();
}
@AfterTest
public void teardown()
{
	driver.close();
}
}
