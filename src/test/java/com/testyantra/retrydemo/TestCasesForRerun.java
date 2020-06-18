package com.testyantra.retrydemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCasesForRerun {
	
	static {
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
	}

		
	@Test
	public void tc_01() throws InterruptedException {
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("https://demo.actitime.com/login.do");
		 System.out.println(driver.getTitle());
//		 Assert.assertEquals(driver.getTitle(), "acti");
		 Thread.sleep(4000);
		 driver.close();
	}
	
	@Test(retryAnalyzer = MyRetry.class)
	public void tc_02() throws InterruptedException {
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("https://selenium.dev/");
		 System.out.println(driver.getTitle());
		 Assert.assertEquals(driver.getTitle(), "SeleniumHQ ");
		 Thread.sleep(4000);
		 driver.close();
	}

}
