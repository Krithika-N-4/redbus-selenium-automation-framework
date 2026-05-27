package com.setup;

import org.slf4j.Logger;

import org.testng.ITestListener;
import org.testng.ITestResult;

import io.cucumber.java.Scenario;

public class Listeners extends BaseSteps implements ITestListener {
	
	public static Logger log =  MyLog.getLogger(Listeners.class);
	
	public static Scenario scenario;
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		log.info("===============================================");
		log.info("Starting Test");
		log.info("===============================================");
		test = extent.createTest(result.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		log.info("Test Passed - " + result.getName());
		test.pass("Test Passed - " + result.getName());		
	}
	
	@Override
	public void onTestFailure(ITestResult result) 
	{
		Throwable throwable = result.getThrowable();
		
		String errmsg = throwable.getMessage();
		
		log.error("Test Failed - " + result.getName() + "\n" + errmsg);
		
	}
		
}
