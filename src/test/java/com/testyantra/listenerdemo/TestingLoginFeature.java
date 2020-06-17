package com.testyantra.listenerdemo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.common.io.Files;

@Listeners(com.testyantra.listenerdemo.MyListeners.class)
public class TestingLoginFeature {
	
	static {
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
	}

	@Test
	public void tc_01(ITestContext context) throws InterruptedException, IOException {
		 WebDriver driver = new ChromeDriver();
		 context.setAttribute("driver", driver);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("https://demo.actitime.com/login.do");
		 System.out.println(driver.getTitle());
		 Assert.assertEquals(driver.getTitle(), "Selenium training");
		 Thread.sleep(4000);
		 driver.close();
		
	}
	
//	@Test
//	public void tc_02() throws InterruptedException {
//		
//		 WebDriver driver = new ChromeDriver();
//		 driver.manage().window().maximize();
//		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		 driver.get("https://selenium.dev/");
//		 System.out.println(driver.getTitle());
//		 Assert.assertEquals(driver.getTitle(), "SeleniumHQ");
//		 Thread.sleep(4000);
//		 driver.close();
//		
//	}

}
