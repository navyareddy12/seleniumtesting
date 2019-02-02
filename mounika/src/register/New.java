package register;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class New {
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
	@Test(priority=0)
	public void register()
	{
		driver.findElement(By.linkText("REGISTER")).click();
	}
@Test(priority=1)
public void newuser() throws IOException, InterruptedException
{
	FileInputStream file=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\mounika\\src\\register\\mnd.xlsx");
XSSFWorkbook workbook= new XSSFWorkbook(file);
XSSFSheet sheet=workbook.getSheet("sheet1");
int rowcount =sheet.getLastRowNum();
for(int i=1;i<=rowcount;i++)
	//<input maxlength="60" name="firstName" size="20">
	////*[@id="email"]
	//<input name="userName" id="userName" size="35" maxlength="64">
{
	Row r=sheet.getRow(i);
	driver.findElement(By.name("firstName")).sendKeys(r.getCell(0).getStringCellValue());
	driver.findElement(By.name("lastName")).sendKeys(r.getCell(1).getStringCellValue());
	double d=r.getCell(2).getNumericCellValue();
	Long x=(long)d;
	String pn=Long.toString(x);
	driver.findElement(By.name("phone")).sendKeys(pn);
	driver.findElement(By.name("userName")).sendKeys(r.getCell(3).getStringCellValue());
	driver.findElement(By.name("address1")).sendKeys(r.getCell(4).getStringCellValue());
	driver.findElement(By.name("city")).sendKeys(r.getCell(5).getStringCellValue());
	driver.findElement(By.name("state")).sendKeys(r.getCell(6).getStringCellValue());
	double p=r.getCell(7).getNumericCellValue();
	Long y=(long)p;
	///html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[11]/td[2]/input
	String pc=Long.toString(y);
	driver.findElement(By.name("postalCode")).sendKeys(pc);
	driver.findElement(By.name("country")).sendKeys(r.getCell(8).getStringCellValue());
	driver.findElement(By.name("email")).sendKeys(r.getCell(9).getStringCellValue());
	driver.findElement(By.name("password")).sendKeys(r.getCell(10).getStringCellValue());
	driver.findElement(By.name("confirmPassword")).sendKeys(r.getCell(11).getStringCellValue());
	driver.findElement(By.name("register")).click();
	String exp=r.getCell(9).getStringCellValue();
	System.out.println(exp);
	String act=driver.findElement(By.xpath("//*[@id=\'email\']")).getText();
	////*[@id="email"]
	System.out.println(act);
	if(act.contains(exp))
	{
		System.out.println("pass");
		r.createCell(12).setCellValue("pass");
	}
	else
	{
		System.out.println("fail");
		r.createCell(12).setCellValue("fail");
	}

FileOutputStream file1=new FileOutputStream("C:\\Users\\user\\eclipse-workspace\\mounika\\src\\register\\mnd23.xlsx");	
workbook.write(file1);
driver.navigate().back();

}

}



}

