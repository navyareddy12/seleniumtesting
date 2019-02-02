package orhm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class TestScripts {
	@Test
	public void login() throws IOException
	{
		Login keys=new Login();
		FileInputStream file=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\mounika\\src\\orhm\\ohrmkeyworddriven.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet ws=wb.getSheet("sheet1");
		Row r=null;
		int rowcount=ws.getLastRowNum();
		for(int i=1;i<=rowcount;i++)
		{
			r=ws.getRow(i);
			String runmode=r.getCell(4).getStringCellValue();
			if(runmode.equals("y"))
			{
				String keyword=r.getCell(3).getStringCellValue();
				if(keyword.equals("Lanch Browser"))
				{
					keys.lauchbroswer();
					
				}
				else if(keyword.equals("Navigate"))
				{
					keys.navigate();
				}
				else if(keyword.equals("Enter Username"))
				{
			
				}
				else if(keyword.equals("Enter password"))
				{
					keys.enterpassword();
				}
				else if(keyword.equals("Click Login"))
				{
					keys.clicklogin();
				}
			}
		}
	}
}
	


