package com.setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseSteps {
	
	public static String browser, baseurl;
	public static String exceldatapath, jsontestfile;
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Actions actions;
		
	public static Logger log =  MyLog.getLogger(BaseSteps.class);

	public static ExtentReports extent;
	public static ExtentTest test;

	//To read config.properties file
	public static void readConfigProperties() throws FileNotFoundException, IOException {
		
		InputStream file = new FileInputStream("src/test/resources/PropertyFiles/config.properties");
		
		Properties prop = new Properties();
		
		prop.load(file);
		
		browser = prop.getProperty("browser");
		
		baseurl = prop.getProperty("baseurl");
		
		exceldatapath = prop.getProperty("exceldatapath");
	
	}
	
	//Initialize variables
	public static void initializeHelpers() {
		
		wait = new WebDriverWait(driver, Duration.ofMillis(25000));
		actions = new Actions(driver);
	}
	
	//Launch Browser
	public static void launchBrowser() throws FileNotFoundException, IOException {
		
		readConfigProperties();
		
		switch(browser.toLowerCase()) {
		
		case "edge":
			driver = new EdgeDriver();
			break;
		
		case "chrome":	
			driver = new ChromeDriver();
			break;
			
		default:
			log.info("Unsupported browser. \n Defaulting to Edge!");
			driver = new EdgeDriver();
			break;
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}
	
	//Load baseurl - https://www.redbus.in
	public static void loadBaseUrl() throws FileNotFoundException, IOException {
		
		driver.get(baseurl);
	}
	
	//Common Actions
	public void clickElement(WebElement elmt) {
		
		elmt.click();
	}
	
	public void typeData(WebElement elmt, String data) {
		
		elmt.clear();
		elmt.sendKeys(data);
	}

	public boolean checkTitle(String title) {
		
		return driver.getTitle().contains(title);
	}
	
	public boolean checkUrl(String url) {
		
		return driver.getCurrentUrl().contains(url);
	}
	
	public void invisibilityCheck(WebElement elmt) {
		
		wait.until(ExpectedConditions.invisibilityOf(elmt));
	}
	
	public boolean visibilityCheck(WebElement elmt) {
		
		try {
		        wait.until(ExpectedConditions.visibilityOf(elmt));
		        return true;
		    } catch (Exception e) {
		        return false;
		    }
	
	}
	
	public void clickableCheck(WebElement elmt) {
		
		wait.until(ExpectedConditions.elementToBeClickable(elmt));
	}
	
	public static void closeBrowser() {
		
		driver.quit();
	}
	
	//BOUNDARY VALUE TEST
	public void validateAge(String age) throws AgeException {

	    int ageValue;

	    try {
	        ageValue = Integer.parseInt(age);
	    } 
	    catch (NumberFormatException e) {
	        throw new IllegalArgumentException("Age must be a numeric value");
	    }

	    if (ageValue < 1 || ageValue > 100) {
	        throw new AgeException("Invalid age entered: " + age + ". Age must be between 1 and 100.");
	    }
	}
}
