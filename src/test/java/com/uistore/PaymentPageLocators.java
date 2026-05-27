package com.uistore;

import org.openqa.selenium.By;

public class PaymentPageLocators {

	public static By cardbutton = By.xpath("//div[text() = 'Add credit/debit card']");
	
	public static By cardnoinput = By.id("cardNumber-input");
	
	public static By nameinput = By.id("cardHoldersName-input");
	
	public static By expdateinput = By.id("expiryDate-input");
	
	public static By cvvinput = By.id("cvv-input");
	
	public static By busname = By.xpath("//h2[contains(@class, 'travelsName')]");
	
	public static By boardingpt = By.xpath("(//span[contains(@class, 'bpDpName')])[1]");
	
	public static By droppingpt = By.xpath("(//span[contains(@class, 'bpDpName')])[2]");
	
	public static By basefare = By.xpath("(//div[contains(@class,'paxItemRight___')])[1]");
	
	public static By gstfare = By.xpath("(//div[contains(@class,'paxItemRight___')])[2]");
		
	public static By totalfare = By.xpath("//div[contains(@class, 'totalText__')]/following-sibling::div");
	
	public static By paybutton = By.xpath("//button[contains(@class, 'primaryButton___') and @aria-label = 'Pay']");
	
	public static By cardnoerror = By.id("cardNumber-input-supporting-text");
	
	public static By cardnameError = By.id("cardHoldersName-input-supporting-text");
	
	public static By expdateError = By.id("expiryDate-input-supporting-text");
	
	public static By cvverror = By.id("cvv-input-supporting-text");
}
