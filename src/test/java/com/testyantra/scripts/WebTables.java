package com.testyantra.scripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTables {
	
	static {
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
	}

	@Test
	public void tc_01() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
//		1st Approach 
		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr"));
		System.out.println("The Number of Rows are :"+tableRows.size());
		
		List<WebElement> tableColumns = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[1]/th"));
		System.out.println("The Number of Columns are :"+tableColumns.size());
		
//		2nd Approach
//		WebElement table = driver.findElement(By.xpath("//table[@id=\"customers\"]/tbody"));
//		List<WebElement> tableRows = table.findElements(By.tagName("tr"));
//		System.out.println("The number of Rows are :"+tableRows.size());
//		
//		List<WebElement> tableColumns = tableRows.get(0).findElements(By.tagName("th"));
//		System.out.println("The number of Columns are :"+tableColumns.size());
		
//      3rd Approach
		
//		int rowSize = driver.findElement(By.xpath("//table[@id='customers']/tbody")).findElements(By.tagName("th")).size();
		
//		--------------------------------------------------------------------------------------------------
		for(int i=0;i<tableColumns.size();i++) {
			System.out.print(tableColumns.get(i).getText()+" ||");
		}
		
		System.out.println();
		for(int i=2;i<=tableRows.size();i++) {
			for(int j=1;j<=tableColumns.size();j++) {
				WebElement colData = driver.findElement(By.xpath("//table[@id=\"customers\"]/tbody/tr["+i+"]/td["+j+"]"));
				System.out.print(colData.getText()+"   ||");
			}
			System.out.println("");
		}
		
		
		
		
		
		
		driver.close();
		
		
		
	}
}
