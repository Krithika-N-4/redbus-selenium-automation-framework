package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.setup.BaseSteps;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import com.setup.ExtentManager;
import com.setup.ScreenshotUtil;

public class Hooks extends BaseSteps {
	
	@Before  
	public static void setUp(Scenario sc) {
		
		extent = ExtentManager.getInstance();
		
		try 
		{	
			launchBrowser();
			loadBaseUrl();
		} 
		catch (FileNotFoundException fnfe) 
		{
			log.info("File is not found in the given path.");		
		} 
		catch (IOException ioe) 
		{
			log.info("File could not be opened.");
		}
		catch(Exception e) 
		{
			log.info("Oops something went wrong!");
		}
		
		initializeHelpers();
		
		log.info("=======================================================================");
		
		test = extent.createTest(sc.getName());
	
	}
	
	@After
	public void navigateHome(Scenario scenario) {
		
		if(scenario.isFailed())
		{
			String screenshotPath = ScreenshotUtil.captureScreenshot(driver, scenario.getName());
			
			test.fail("Scenario Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
        		
        	driver.navigate().to(baseurl);
            
        	closeBrowser();
            
        	log.info("Browser closed for scenario: " + scenario.getName());
        
	}
	
	@AfterAll
	public static void tearDown() {
		
		if(extent != null) {
			
			extent.flush();
			log.info("Extent Test Report created");
			log.info("=======================================================================");
		}
	  }

}
