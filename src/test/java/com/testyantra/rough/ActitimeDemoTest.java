package com.testyantra.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActitimeDemoTest {
	static {
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
	}
	
	@Test
	public void tc_01() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.get("https://demo.actitime.com/login.do");
		  
		  String e1 = "actiTIME - Login";
		  String a1 = driver.getTitle();
		  Assert.assertEquals(a1, e1);
		  Thread.sleep(4000);
		  
		  driver.findElement(By.id("username")).sendKeys("admin");
		  driver.findElement(By.name("pwd")).sendKeys("manager");
		  driver.findElement(By.xpath("//div[.='Login ']")).click();
		
	}
}
