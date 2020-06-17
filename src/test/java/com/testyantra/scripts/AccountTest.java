package com.testyantra.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AccountTest {
	
	static {
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
	}
	
	
	@Test
	public void tc_01() throws InterruptedException {
		
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("https://www.ubuy.co.in/");
		 driver.findElement(By.xpath("//div[@class=\"newsletter-pop-up-v2 ub-newsletter-block in\"]/i")).click();
		 Actions act = new Actions(driver);
		WebElement Account = driver.findElement(By.xpath("//abbr[.='Account']"));
		Thread.sleep(2000);
		 act.moveToElement(Account).perform();
		 driver.findElement(By.xpath("//a[contains(.,'Sign in')]")).click();
		 driver.findElement(By.xpath("//input[@title='Email Address']")).sendKeys("srinidhi1071@gmail.com");
		 driver.findElement(By.xpath("//input[@title='Password']")).sendKeys("srinidhi123");
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		 Thread.sleep(3000);
		 driver.close();
		 
		 
		
	}

}
