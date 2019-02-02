package register;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ohrm {
	WebDriver driver=null;
	String url="https://opensource-demo.orangehrmlive.com/";
@BeforeTest()
public void setup()
{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\mounika\\driver1\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
}
@Test
public void login() throws IOException
{
	FileInputStream file=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\mounika\\src\\register\\ss.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(file);
	XSSFSheet sheet=workbook.getSheet("sheet1");
	FileInputStream file2=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\mounika\\property");
	Properties p= new Properties();
	p.load(file2);
	Row r=sheet.getRow(1);
	driver.findElement(By.id(p.getProperty("username"))).sendKeys(r.getCell(0).getStringCellValue());
	driver.findElement(By.id(p.getProperty("password"))).sendKeys(r.getCell(1).getStringCellValue());
	driver.findElement(By.id(p.getProperty("submit"))).click();;
	String exp="welcome_Admin";
	System.out.println();
	String act=driver.findElement(By.id("welcome")).getText();
	System.out.println();
	if(act.contains(exp))
	{
		System.out.println("pass");
		r.createCell(2).setCellValue("pass");
		
	}
	
	else
	{
		System.out.println("fail");
		r.createCell(2).setCellValue("fail");
	}
FileOutputStream file1=new FileOutputStream("C:\\Users\\user\\eclipse-workspace\\mounika\\src\\register\\ss1.xlsx");
workbook.write(file1);
}
}
