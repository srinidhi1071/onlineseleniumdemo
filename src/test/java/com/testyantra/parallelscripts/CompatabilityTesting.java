package com.testyantra.parallelscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CompatabilityTesting {

	static {
		System.setProperty("webdriver.gecko.driver", "./softwares/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
		
	}
	
	
	@Test
	@Parameters({"browser"})
	public void tc_01(String browser) {
		WebDriver driver;
		if(browser.equals("chrome"))
		{
			 driver = new ChromeDriver();
		}
		else {
		 driver = new FirefoxDriver();
		}
		
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
	}
	
}
