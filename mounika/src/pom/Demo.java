package pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo {
	WebDriver driver=null;
	String url="http://www.newtours.demoaut.com/";
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\mounika\\driver1\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	@Test
	public void homepage() throws IOException
	{
		New wmt=PageFactory.initElements(driver, New.class);
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
		FileInputStream file=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\mounika\\src\\pom\\loginmultipledata.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet ws=wb.getSheet("sheet1");
		int rowcount=ws.getLastRowNum();
				for(int i=1;i<=rowcount;i++)
				{
					Row r=ws.getRow(i);
					wmt.login(r.getCell(0).getStringCellValue(), r.getCell(1).getStringCellValue());
					String exp="Find";
					String act=driver.getTitle();
					if(act.contains(exp))
					{
						r.createCell(2).setCellValue("pass");
					}
					else
					{
						r.createCell(2).setCellValue("fail");
					}
					driver.navigate().back();
					FileOutputStream file1=new FileOutputStream("C:\\Users\\user\\eclipse-workspace\\mounika\\src\\pom\\loginmultipledata1.xlsx");
					wb.write(file1);
				}
		
	}
}
