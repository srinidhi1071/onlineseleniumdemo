package com.testyantra.listenerdemo;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

public class MyListeners implements ITestListener{
	
	  public void onTestStart(ITestResult result) {
		   System.out.println("Test "+result.getName()+" Started");
		   Reporter.log(result.getName());
		   System.out.println(result.getName());
		   
		  }

		  /**
		   * Invoked each time a test succeeds.
		   *
		   * @param result <code>ITestResult</code> containing information about the run test
		   * @see ITestResult#SUCCESS
		   */
		   public void onTestSuccess(ITestResult result) {
		    System.out.println("Test"+result.getName()+" Completed Successfully");
		  }

		  /**
		   * Invoked each time a test fails.
		   *
		   * @param result <code>ITestResult</code> containing information about the run test
		   * @see ITestResult#FAILURE
		   */
		  public  void onTestFailure(ITestResult result) {
		   System.out.println("Test "+result.getName()+" Failed");
		   	
		   	 WebDriver driver = (WebDriver)result.getTestContext().getAttribute("driver");
		   
		   TakesScreenshot ts =(TakesScreenshot) driver;
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
		   String timeCurrent = LocalDateTime.now().format(dtf);
		   
		 	File src = ts.getScreenshotAs(OutputType.FILE);
		 	File desc = new File("C:\\Users\\Srinidhi\\Desktop\\ScreenShots\\"+result.getName()+timeCurrent+"_Failed.png");
		 	try {
				Files.copy(src, desc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }

		
		  /**
		   * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt; tag
		   * and calling all their Configuration methods.
		   */
		  public void onStart(ITestContext context) {
		   System.out.println("Test Suite Started");
		  }

		  /**
		   * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have run
		   * and all their Configuration methods have been called.
		   */
		  public void onFinish(ITestContext context) {
		    System.out.println("Test Suite Completed");
		  }

	
}
