package com.testyantra.parallelscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParallelExecutionDemo1 {
	

	static {
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
	}
			
		@Test
		public void tc_01() throws InterruptedException {
			
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.selenium.dev/");
			System.out.println(driver.getTitle());
			Thread.sleep(5000);
			driver.close();
			
		}
		
		@Test
		public void tc_02() throws InterruptedException {
			
			WebDriver driver = new ChromeDriver();
			driver.get("https://testng.org/doc/");
			System.out.println(driver.getTitle());
			Thread.sleep(5000);
			driver.close();
			
		}

}
