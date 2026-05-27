package com.setup;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.slf4j.Logger;

public class ScreenshotUtil {

//	public static String captureScreenshot(WebDriver driver, String testName) 
//	{
//		Logger log = MyLog.getLogger(ScreenshotUtil.class);
//		
//		String timestamp = new SimpleDateFormat("ddMMyyyy HHmmss").format(new Date());
//		
//		String screenshotPath = "screenshots/" + testName + " " + timestamp + ".png";
//		
//		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		
//		String destPath = System.getProperty("user.dir") + "/" + screenshotPath;
//		
//		File destFile = new File(destPath);
//		
//		try 
//		{
//			FileHandler.copy(scrFile, destFile);
//		}
//		catch (IOException ioe)
//		{
//			log.info("File not found!");
//		}
//		
//		return destPath;
//	}
	
	public static String captureScreenshot(WebDriver driver, String testName) 
	{
		Logger log = MyLog.getLogger(ScreenshotUtil.class);
		
		String timestamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
		
		String testname = testName.split("-")[0];
		
		String screenshotPath = "screenshots/" + testname + "_" + timestamp + ".png";
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String destPath = System.getProperty("user.dir") + "/" + screenshotPath;
		
		File destFile = new File(destPath);
		
		try 
		{
			destFile.getParentFile().mkdirs();
			
			FileHandler.copy(scrFile, destFile);
			
			log.info("Screenshot captured successfully");
		}
		catch (IOException ioe)
		{
			log.error("Screenshot capture failed!");
		}
		
		return destPath;
	}
	
}
