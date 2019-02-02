package com.ohrmtestscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.keyworddriven.Loginkeyword;

public class Logintest {
@Test
public void Login() throws IOException
{
	Loginkeyword keys=new Loginkeyword();
	FileInputStream file=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\shobha\\src\\com\\xlfiles\\ohrmkeyworddriven.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(file);
	XSSFSheet ws=wb.getSheet("Sheet1");
	Row r=null;
	int rowcount=ws.getLastRowNum();
	for(int i=1;i<=rowcount;i++)
	{
		r=ws.getRow(i);
		String runmode=r.getCell(4).getStringCellValue();
		if(runmode.equals("Y"))
		{
			String keyword=r.getCell(3).getStringCellValue();
			if(keyword.equals("Launch Browser"))
			{
				keys.launchbrowser();
			}
			else if(keyword.equals("Navigate"))
			{
				keys.navigate();
			}
			else if(keyword.equals("Enter username"))
			{
				keys.enterusername();
			}
			else if(keyword.equals("Enter password"))
			{
				keys.enterpassword();
			}
			else if(keyword.equals("Click login"))
			{
				keys.clicklogin();
			}
		}
	}
}
}
