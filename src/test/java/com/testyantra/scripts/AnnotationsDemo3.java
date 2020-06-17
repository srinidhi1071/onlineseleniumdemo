package com.testyantra.scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class AnnotationsDemo3 {

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class Executed");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class Executed");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test Executed");
	}
	
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test Executed");
	}
	
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite Execuited");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("Before Suite Execuited");
	}
}
