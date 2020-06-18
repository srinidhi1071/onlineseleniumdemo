package com.testyantra.retrydemo;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetry implements IRetryAnalyzer {
	
	int retryCount = 0;
	final int maxRetryCount =3;

	@Override
	public boolean retry(ITestResult result) {
		
		if(retryCount<maxRetryCount) {
			retryCount++;
			return true;
		}
		
		return false;
	}

	

}
