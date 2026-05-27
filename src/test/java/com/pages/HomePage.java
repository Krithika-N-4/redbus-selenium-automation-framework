package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.setup.BaseSteps;

import com.uistore.HomePageLocators;

public class HomePage extends BaseSteps {
	
	public WebElement fromButton() {
		return driver.findElement(HomePageLocators.frombtn); 
	}
	
	public WebElement fromInput(String frominput) {
		
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(HomePageLocators.fromsuggestions)); 
		
		return wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@aria-label='" + frominput + "']")));
	}
	
	public WebElement toButton() {
		return driver.findElement(HomePageLocators.tobtn); 
	}
	
	public WebElement toInput(String toinput) {
		
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(HomePageLocators.tosuggestions)); 
		
		return wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@aria-label='" + toinput + "']")));
	}
	
	public WebElement dateButton() {
		return driver.findElement(HomePageLocators.datebtn); 
	}
	
	public WebElement dateArrow() {
		return wait.until(ExpectedConditions
				.presenceOfElementLocated(HomePageLocators.datearrow)); 
	}
	
	public WebElement dateInput(String date) {
		
		/*wait.until(ExpectedConditions
				.invisibilityOfElementLocated(HomePageLocators.calendarOverlay));*/
		
		return wait.until(ExpectedConditions
				.elementToBeClickable(
						By.xpath("//div[@role='button' and contains(@aria-label,'" + date + "')]")));
				
	}
	
	public WebElement womenToggle() {
		
		return wait.until(ExpectedConditions
				.presenceOfElementLocated(HomePageLocators.womentoggle));
				 
	}
	
	public WebElement gotItButton() {
		return wait.until(ExpectedConditions
				.elementToBeClickable(HomePageLocators.gotitbtn));
	}
	
	public WebElement searchButton() {
		return wait.until(ExpectedConditions
				.elementToBeClickable(HomePageLocators.searchbutton));
				 
	}
	
	/*public List <WebElement> preferenceBanner() {
		
		return driver.findElements(HomePageLocators.preferencebanner);
	}
	
	public WebElement proceedButton() {
		return wait.until(ExpectedConditions
				.elementToBeClickable(HomePageLocators.proceedbtn));
				 
	}*/

}
