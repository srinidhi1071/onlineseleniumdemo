package com.testyantra.scripts;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLinksTest {

	
	static {
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
	}
	
	
	@Test
	public void tc_01() throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/Srinidhi/Desktop/BrokenLinks.html");
		WebElement linkFirst = driver.findElement(By.xpath("//a[contains(.,'RESTFull services testing')]"));
	
		String urlFirst = linkFirst.getAttribute("href");
		URL u = new URL(urlFirst);
		HttpURLConnection conn = (HttpURLConnection)u.openConnection();
		
		if(conn.getResponseCode() == 200) {
			System.out.println("Link is Not Broken");
			System.out.println("The Response Code is:"+conn.getResponseCode());
			System.out.println("The MEssage is :"+conn.getResponseMessage());
		}
		else
		{
			System.out.println("Link is Broken");
			System.out.println("The Response Code is:"+conn.getResponseCode());
			System.out.println("The MEssage is :"+conn.getResponseMessage());

			
		}
		
		
		Thread.sleep(3000);
		
		driver.close();
		
		
	}
}
