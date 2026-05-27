package com.uistore;

import org.openqa.selenium.By;

public class SearchPageLocators {
	
	public static By bannerelmt = By.xpath("//div[contains(@class, 'carouselWrap')]");
	
	public static By freecanbanner = By.xpath("(//img[contains(@data-src,'FreeCancelCard_Main')]/ancestor::div[contains(@class,'searchBannerTile')])[2]");
	
	public static By popupclose = By.xpath("(//button[@aria-label = 'Close'])[2]");
	
	public static By appliedfilters = By.xpath("//div[contains(@class,'active')]/i/following-sibling::div");
	
	public static By allemptyseats = By.xpath("//span[@role='button' and contains(@aria-label,'seat status available') and not(contains(@aria-label,'reserved for female'))]");
	
	public static By boarddropbtn = By.xpath("//button[@aria-label = 'Select boarding & dropping points']");
	
	public static By filldetailsbtn = By.xpath("//button[@aria-label = 'Fill passenger details']");
	
	public static By phoneinput = By.name("Phone *");
	
	public static By emailinput = By.xpath("//input[@placeholder = 'Enter email id']");
	
	public static By statebtn = By.id("0_201");
	
	public static By statedialogbox = By.xpath("//div[@data-autoid = 'bottom-sheet']");
	
	public static By nameinput = By.xpath("//input[@aria-label = 'Name *']");
	
	public static By ageinput = By.xpath("//input[@placeholder = 'Enter Age']");
	
	public static By nofcbtn = By.xpath("//div[@data-autoid = 'fcNo']");
	
	public static By nobibtn = By.id("insuranceRejectText");
	
	public static By Detailspage = By.id("custInfoFooter");
	
	public static By redcaretoggle = By.id("redCare");
	
	public static By continuebtn = By.xpath("//button[text() = 'Continue booking']");
	
}
