package com.setup;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	public static ExtentReports extent;
	public static DateTimeFormatter dateformat 
						= DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
		public static synchronized ExtentReports getInstance() 
	{
		
		if (extent == null) {
			extent = new ExtentReports();
			String reportPath = "target/reports/ExtentReport_" 
			+ LocalDateTime.now().format(dateformat) + ".html";
			
			ExtentSparkReporter sparkReporter = 
										new ExtentSparkReporter(reportPath);
			
			extent.attachReporter(sparkReporter);
			
			sparkReporter.config().setTheme(Theme.DARK);
			sparkReporter.config().setDocumentTitle("RedBus Test Report");
			sparkReporter.config().setReportName("RedBus Test Execution");
			
		}
		
		return extent;
	}
}
