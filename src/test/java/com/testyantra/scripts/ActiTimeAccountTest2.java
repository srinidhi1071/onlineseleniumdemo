package com.testyantra.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ActiTimeAccountTest2 {
	static {
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
	}
	
	@Test
	public void tc_01() throws InterruptedException {
	 WebDriver driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 SoftAssert s = new SoftAssert();
	 driver.get("https://demo.actitime.com/login.do");
	 String e1 = "actiTIME";
	 String a1 = driver.getTitle();
	 s.assertEquals(a1, e1);//<----(1)
	 Thread.sleep(4000);
	driver.findElement(By.id("username")).sendKeys("admin");
	
	driver.findElement(By.name("pwd")).sendKeys("manager");
	driver.findElement(By.xpath("//div[.='Login ']")).click();
	Thread.sleep(4000);
	
	String dashPageTileexpected = "actiTIME - Enter Time-Track" ;
	String dashPageTitleactual = driver.getTitle();
	
	s.assertEquals(dashPageTitleactual, dashPageTileexpected);//<----(2)
	Thread.sleep(4000);
	
	 driver.close();
	 
	 s.assertAll();
	
	}
}
