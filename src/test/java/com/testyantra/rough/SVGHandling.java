package com.testyantra.rough;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.javafx.binding.SelectBinding.AsLong;

public class SVGHandling {
	
	static {
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
	}
	
	@Test
	public void tc_01() {
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("https://www.urbanladder.com/");
		 driver.findElement(By.xpath("//div[@id=\"authentication_popup\"]/div/div/div/a[contains(.,'Close')]")).click();
		 List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@class=\"topnav bodytext\"]/li/span"));
		 List<String> menuItemsActual  = new ArrayList<String>();
		 for(WebElement ele : menuItems) {
			 menuItemsActual.add(ele.getText());
		 }
		 List<String> menuItemsExpected = Arrays.asList("Sale","Living","Bedroom","Dining","Storage","Study","Mattresses","Decor","New","Collections");
		 
		 Assert.assertEquals(menuItemsActual, menuItemsExpected);
	
	}

}
