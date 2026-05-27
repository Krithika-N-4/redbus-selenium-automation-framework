package com.uistore;

import org.openqa.selenium.By;

public class HomePageLocators {
	
	public static By frombtn = By.xpath("//div[contains(@class, 'srcDestWrapper')]");
	
	public static By fromsuggestions = By.xpath("//div[contains(@class, 'suggestionsWrapper')]");
	
	public static By tosuggestions = By.xpath("//div[contains(@class, 'suggestionsWrapper')]");

	public static By tobtn = By.xpath("(//div[contains(@class, 'srcDestWrapper')])[2]");
	
	public static By datebtn = By.xpath("//div[@role='combobox' and contains(@aria-label,'Date of Journey')]");
	
	//public static By calendarOverlay = By.cssSelector("div.mainCard___ef4cf2");
	
	public static By datearrow = By.xpath("//i[contains(@class, 'arrow___') and contains(@class, 'right___')]");
	
	public static By womentoggle = By.xpath("//div[@aria-label = 'Booking for Women']");//By.className("switchInput___2c0030");
	
	public static By gotitbtn = By.xpath("//button[text() = 'Got it']");
	
	public static By searchbutton = By.xpath("//button[text() = 'Search buses']");
	
	public static By preferencebanner = By.xpath("//div[contains(@class, 'bottomSheetContainer')]");
	
	public static By proceedbtn = By.xpath("//button[text() = 'Proceed']");
}
