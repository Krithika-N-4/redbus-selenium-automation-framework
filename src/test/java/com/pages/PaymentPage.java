package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.setup.BaseSteps;

import com.uistore.PaymentPageLocators;


public class PaymentPage extends BaseSteps {

	public WebElement cardButton() {
		
		return wait.until(ExpectedConditions
				.presenceOfElementLocated(PaymentPageLocators.cardbutton));
		
	}
	
	public WebElement cardNoInput() {
		
		return wait.until(ExpectedConditions
				.presenceOfElementLocated(PaymentPageLocators.cardnoinput));
		
	}
	
	public WebElement cardNameButton() {
		
		return wait.until(ExpectedConditions
				.elementToBeClickable(PaymentPageLocators.nameinput));
		
	}
	
	public WebElement expDateInput() {
		
		return wait.until(ExpectedConditions
				.presenceOfElementLocated(PaymentPageLocators.expdateinput));
		
	}
	
	public WebElement cvvInput() {
		
		return wait.until(ExpectedConditions
				.presenceOfElementLocated(PaymentPageLocators.cvvinput));
		
	}
	
	public WebElement busName() {
		
		return wait.until(ExpectedConditions
				.presenceOfElementLocated(PaymentPageLocators.busname));
		
	}
	
	public WebElement boardingPoint() {
		
		return wait.until(ExpectedConditions
				.presenceOfElementLocated(PaymentPageLocators.boardingpt));
		
	}
	
	public WebElement droppingPoint() {
		
		return wait.until(ExpectedConditions
				.presenceOfElementLocated(PaymentPageLocators.droppingpt));
		
	}
	
	public WebElement baseFare() {
		
		return wait.until(ExpectedConditions
				.presenceOfElementLocated(PaymentPageLocators.basefare));
	}

	public WebElement gstFare() {
		
		return wait.until(ExpectedConditions
				.presenceOfElementLocated(PaymentPageLocators.gstfare));
	}
	
	public WebElement discountAmt() {
		
		return wait.until(ExpectedConditions
				.presenceOfElementLocated(PaymentPageLocators.discount));
	}
	
	
	public WebElement totalFare() {
		
		return wait.until(ExpectedConditions
				.presenceOfElementLocated(PaymentPageLocators.totalfare));
	}
	

	public float getAmountAsFloat(String amountText) {
		
		amountText = amountText
                .replace("₹", "")
                .replace(",", "")
                .replace(" ", "")  
                .trim();

		return Float.parseFloat(amountText);
	}
	
	public WebElement payButton() {
		
		wait.until(ExpectedConditions
				.presenceOfElementLocated(PaymentPageLocators.paybutton));
		
		return wait.until(ExpectedConditions
				.elementToBeClickable(PaymentPageLocators.paybutton));
	}

	public WebElement cardNoError() {
		
		return wait.until(ExpectedConditions
				.presenceOfElementLocated(PaymentPageLocators.cardnoerror));
	}
	
	public WebElement cardNameError() {
		
		return wait.until(ExpectedConditions
				.presenceOfElementLocated(PaymentPageLocators.cardnameError));
	}
	
	public WebElement expDateError() {
		
		return wait.until(ExpectedConditions
				.presenceOfElementLocated(PaymentPageLocators.expdateError));
	}
	
	public WebElement cvvError() {
		
		return wait.until(ExpectedConditions
				.presenceOfElementLocated(PaymentPageLocators.cvverror));
	}
}
