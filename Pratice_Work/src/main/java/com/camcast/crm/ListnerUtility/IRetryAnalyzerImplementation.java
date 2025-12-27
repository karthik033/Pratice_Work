package com.camcast.crm.ListnerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryAnalyzerImplementation  implements IRetryAnalyzer{
int count =1;
int limitcount=5;
	@Override
	public boolean retry(ITestResult result) {
		if(count<=limitcount) {
			count++;
			return true;
		}
		return false;
	}

}
