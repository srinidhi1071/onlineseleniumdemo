package com.testyantra.scripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class UrbanLadderMenuItems {

	static {
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
	}

	@Test
	public void tc_verifyMenuItems() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.urbanladder.com/");
		driver.findElement(By.xpath(
				"//div[@id='authentication_popup']/div/div/div[@class='popup-text text-center vert large-6 columns']/a[contains(.,'Close')]"))
				.click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@class='topnav bodytext']/li/span"));
		for (WebElement menuItem : menuItems) {
			act.moveToElement(menuItem).perform();
			System.out.println(menuItem.getText());
			System.out.println("*********************************");
			Thread.sleep(2000);
			List<WebElement> subMenuItems = driver.findElements(By.xpath("//span[contains(.,'"+menuItem.getText()+"')]/parent::li/descendant::div[@class='taxontype']/a "));
			for(WebElement subMenuItem:subMenuItems) {
				System.out.println(subMenuItem.getText());
				System.out.println("------------------------------");
			}
		
		}
		
		driver.close();

		

	}

}
