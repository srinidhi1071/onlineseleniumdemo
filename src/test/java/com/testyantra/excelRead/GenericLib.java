package com.testyantra.excelRead;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class GenericLib {

	public static String readFromExcel(String filePath,String sheetName,int rowNum,int cellNum) {
		String data="";
		try {
		FileInputStream fin = new FileInputStream(filePath);
		Workbook workbook = WorkbookFactory.create(fin);//Object of the file
		Sheet sheet = workbook.getSheet(sheetName);
		data=sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	public static void saveScreenShot(WebDriver driver,String screenShotPath) {
		
		try {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File desc = new File(screenShotPath);
		Files.copy(src, desc);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
