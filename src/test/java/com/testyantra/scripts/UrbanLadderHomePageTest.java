package com.testyantra.scripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class UrbanLadderHomePageTest {
	
	static {
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
	}
	
	@Test
	public void tc_verifyMenuItems() throws InterruptedException {
		
		
		 WebDriver driver = new ChromeDriver();
		 Reporter.log("Launching the Browser");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("https://www.urbanladder.com/");
		 Reporter.log("Loading the AUT");
		 driver.findElement(By.xpath("//div[@id='authentication_popup']/div/div/div[@class='popup-text text-center vert large-6 columns']/a[contains(.,'Close')]")).click();
		 Reporter.log("Closing the Welcome-Pop Up window");
		 String e1 = "Furniture Online: Buy Home Wooden Furniture Online In India At Best Price - Urban Ladder - Urban Ladder";
		 String a1 = driver.getTitle();
		 
		 Assert.assertEquals(a1, e1);
		 Reporter.log("Verifying the Tile of the page");
		 
		 List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@class=\"topnav bodytext\"]/li/span"));
		
		 List<String> menuItemsExpected = Arrays.asList("Sale","Living","Bedroom","Dining","Storage","Study","Mattresses","Decor","New","Collections");
		 List<String> menuItemsActual = new ArrayList<String>();
		 
		 for(WebElement menuItem:menuItems) {
			 menuItemsActual.add(menuItem.getText());
		 }
		 
		 Assert.assertEquals(menuItemsActual, menuItemsExpected);
		 Reporter.log("Verifying the Menu Items");
		 Thread.sleep(5000);
		 driver.close();
		 Reporter.log("Closing the Browser");
	}

}
