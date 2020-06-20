package com.testyantra.excelRead;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadExcelDataDemo {
	static {
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
	}

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		
//		FileInputStream fin = new FileInputStream("C:\\Users\\Srinidhi\\Desktop\\ManualBatch 08_06_2020\\Book1.xlsx");
//		Workbook workbook = WorkbookFactory.create(fin);//Object of the file
//		Sheet sheet = workbook.getSheet("Sheet1");
//		String username = sheet.getRow(1).getCell(1).getStringCellValue();
//		String password = sheet.getRow(1).getCell(2).getStringCellValue();
//		System.out.println("The Username is :"+username );
//		System.out.println("The Password is :"+password );
		
//		String filePath = "C:\\Users\\Srinidhi\\Desktop\\ManualBatch 08_06_2020\\Book2.xlsx";
//		System.out.println("The Username is :"+GenericLib.readFromExcel(filePath, "Sheet1",1,1));
//		System.out.println("The Username is :"+GenericLib.readFromExcel(filePath, "Sheet1",1,2));
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		GenericLib.saveScreenShot(driver, "C:\\Users\\Srinidhi\\Desktop\\ManualBatch 08_06_2020\\ss1.png");
		driver.close();
	}
}
