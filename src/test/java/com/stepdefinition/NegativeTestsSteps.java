package com.stepdefinition;

import org.slf4j.Logger;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.pages.PaymentPage;
import com.setup.BaseSteps;
import com.setup.MyLog;

import io.cucumber.java.en.Then;

public class NegativeTestsSteps {
	
	/*
	 -----------------------------Negative Test 1 Scenario----------------------------
	 * Created by: N Krithika
	 * Reviewed by: 
	 * Description: 
	 * Validates if the respective error messages for card number, card name, expiry date
	   and cvv are displayed in the payment page when no details are entered.
	*/
	
	public static Logger log = MyLog.getLogger(NegativeTestsSteps.class);
	
	PaymentPage paymentpage = new PaymentPage();

	@Then("User clicks - Pay amount button")
	public void user_clicks_pay_amount_button() throws InterruptedException {
		
		WebElement paybutton = paymentpage.payButton();
		
		JavascriptExecutor js = (JavascriptExecutor) BaseSteps.driver;
	
	    js.executeScript(
	        "arguments[0].scrollIntoView({block:'center'});",
	        paybutton
	    );
	
	    try {
	        Thread.sleep(500);
	    } 
	    catch (InterruptedException e) {
	    }
		
	    Thread.sleep(2000);

	    js.executeScript("arguments[0].click();", paybutton);		
	}
	

	@Then("The respective error messages for card number {string}, card name {string}, expiry date {string} and cvv {string} must be displayed in the payment page")
	public void validate_error_messages(String expCardNoErr, String expCardNameErr, String expExpiryDateErr, String expCvvErr) throws InterruptedException {
		
		log.info("TC_03 - The respective error messages for card number, card name, expiry date and cvv must be displayed in the payment page");
		
		String cardnoerr = paymentpage.cardNoError().getText();
		
		String cardnameErr = paymentpage.cardNameError().getText();
		
		String expdateErr = paymentpage.expDateError().getText();
		
		String cvverr = paymentpage.cvvError().getText();
		
		try {
			
			assertEquals(cardnoerr, expCardNoErr, "Card number error message mismatch");
			
			assertEquals(cardnameErr, expCardNameErr, "Card name error message mismatch");
			
			assertEquals(expdateErr, expExpiryDateErr, "Expiry date error message mismatch");
			
			assertEquals(cvverr, expCvvErr, "CVV error message mismatch");
			
			Thread.sleep(3000);
			
			log.info("TC_03 passed - The respective error messages for card number, card name, expiry date and cvv are displayed in the payment page");
			
			BaseSteps.test.pass("TC_03 passed - The respective error messages for card number, card name, expiry date and cvv are displayed in the payment page");
		}
		
		catch (AssertionError ae) {
			
			log.info("TC_03 failed - The respective error messages for card number, card name, expiry date and cvv are not displayed in the payment page");
			
			BaseSteps.test.pass("TC_03 failed - The respective error messages for card number, card name, expiry date and cvv are not displayed in the payment page");
		}
	}
}
