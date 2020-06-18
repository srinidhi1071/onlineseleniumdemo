package com.testyantra.rough;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class UrbanLadder {

	static {
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
	}
	
	
	@Test
	public void urbanLadderTest() throws InterruptedException {
		ChromeOptions co = new ChromeOptions();
//		co.addArguments("--headless");
		WebDriver driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.urbanladder.com/");
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='authentication_popup']/div/div/div[@class='popup-text text-center vert large-6 columns']/a[contains(.,'Close')]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='authentication_popup']/div/div/div[@class='popup-text text-center vert large-6 columns']/a[contains(.,'Close')]"))).click();
		Thread.sleep(2000);
		List<WebElement> menuItems = driver.findElements(By.xpath("//div[@id='topnav_wrapper']/ul/li/span"));
		Actions act = new Actions(driver);
		for(WebElement menuItem:menuItems) {
			System.out.println(menuItem.getText().trim());
			act.moveToElement(menuItem).perform();
			Thread.sleep(2000);
			System.out.println("***************************************");
			List<WebElement> subMenuItems = driver.findElements(By.xpath("//span[contains(.,'"+menuItem.getText().trim()+"')]/parent::li/descendant::div[@class='taxontype']/a"));
				for(WebElement subMenuItem:subMenuItems) {
					System.out.println(subMenuItem.getText());
					System.out.println("----------------------------------");
				}
		}
		
		driver.close();
	}

}
