package com.testyantra.excelRead;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DashBoardTest {

	FileInputStream fin = new FileInputStream("C:\\Users\\Srinidhi\\Desktop\\ManualBatch 08_06_2020\\Book1.xlsx");
	Workbook workbook = WorkbookFactory.create(fin);//Object of the file
	Sheet sheet = workbook.getSheet("Sheet1");
	String username = sheet.getRow(1).getCell(1).getStringCellValue();
	String password = sheet.getRow(1).getCell(2).getStringCellValue();
	System.out.println("The Username is :"+username );
	System.out.println("The Password is :"+password );
	
}
