package com.POMframework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Newtourshomepagetesting {
	WebDriver driver=null;
	String url="http://www.newtours.demoaut.com/";
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
	public void homepage() throws IOException
	{
		Welcomemercurytoursobjectrepository wmt=PageFactory.initElements(driver, Welcomemercurytoursobjectrepository.class);
		List<WebElement>Links=driver.findElements(By.tagName("a"));
		int links_count=Links.size();
		System.out.println(links_count);
		for(int k=0;k<links_count;k++)
		{
			String linkname=Links.get(k).getText();
			System.out.println(linkname);
		}
		wmt.signon();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println();
		driver.navigate().back();
		wmt.register();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println();
		driver.navigate().back();
		FileInputStream file=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\shobha\\src\\com\\xlfiles\\loginmultipledata.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet ws=wb.getSheet("Sheet1");
		int rowcount=ws.getLastRowNum();
		for(int i=1;i<=rowcount;i++)
		{
			Row r=ws.getRow(i);
			wmt.login(r.getCell(0).getStringCellValue(), r.getCell(1).getStringCellValue());
			String exp_title="Find";
			String actual_title=driver.getTitle();
			if(exp_title.contains(actual_title))
			{
				r.createCell(2).setCellValue("pass");
			}
			else
			{
				r.createCell(2).setCellValue("fail");
			}
			driver.navigate().back();
			FileOutputStream file1=new FileOutputStream("C:\\Users\\user\\eclipse-workspace\\shobha\\src\\com\\xlfiles\\loginmultipleresultdata.xlsx");
			wb.write(file1);
		}
		wmt.support();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println();
		driver.navigate().back();
		wmt.contact();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println();
		driver.navigate().back();
		wmt.home();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println();
		driver.navigate().back();
		wmt.flights();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println();
		driver.navigate().back();
		wmt.hotels();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println();
		driver.navigate().back();
		wmt.car();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println();
		driver.navigate().back();
		wmt.c();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println();
		driver.navigate().back();
		wmt.d();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println();
		driver.navigate().back();
		wmt.vac();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println();
		driver.navigate().back();
		wmt.your();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println();
		driver.navigate().back();
		wmt.f();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println();
		driver.navigate().back();
		wmt.here();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println();
		driver.navigate().back();
		wmt.business();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println();
		driver.navigate().back();
		wmt.salon();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println();
		driver.navigate().back();
	}
}