package com.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.setup.BaseSteps;
import com.setup.NoSeatException;
import com.uistore.SearchPageLocators;

public class SearchPage extends BaseSteps {

	public WebElement Filter1(String filter1) {
		
		return wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@role='button' and contains(@aria-label, '" + filter1 + "')]")));
		
	}
	
	public WebElement Filter2(String filter2) {
			
			return wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[@role='button' and contains(@aria-label, '"+ filter2 + "')]")));
		}
	
	public WebElement Filter3(String filter3) {
		
		return wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@role='button' and contains(@aria-label, '" + filter3 + "')]")));
	}
	
	public WebElement bannerFilter(String bannerfilter) {
		
		wait.until(ExpectedConditions
				.presenceOfElementLocated(SearchPageLocators.bannerelmt));
			
		return wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//img[contains(@data-src,'" + bannerfilter + "')]/ancestor::div[contains(@class,'searchBannerTile')])[2]")));
	}
		
	public WebElement specialFeaturesBtn(String otherfilter) {
		
		return wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//h3[text() = '" + otherfilter + "']")));
	}
	
	public WebElement specialFeaturesInput(String otherfilteropt) {
		
		return wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[contains(@class,'listHeader') and text() = '" + otherfilteropt + "']")));
	}
	
	public List <WebElement> appliedFilters() {
		
		return wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(SearchPageLocators.appliedfilters));
	}
	
	public WebElement viewSeatsButton(String busname) {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@aria-label, '" + busname + "')]")));
		
		return wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[contains(@aria-label, '" + busname + "')]")));
	}
	
	public List <WebElement> popupClose() {
		
		return driver.findElements(SearchPageLocators.popupclose);
	}
	
	public String emptySeat() throws NoSeatException {
		
		List <WebElement> emptyseats = wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(SearchPageLocators.allemptyseats));
		

		if (emptyseats == null || emptyseats.isEmpty()) {
		    throw new NoSeatException("No empty seats available for the selected bus");
		}


		List<String> seatIds = new ArrayList<>();

		for (WebElement seat : emptyseats) {
			seatIds.add(seat.getAttribute("id"));
		}
		
		Random random = new Random();
		
		String emptyseat = seatIds.get(random.nextInt(seatIds.size()));
		
		return emptyseat;

	}
	
	public WebElement seatInput(String seatno) {
		
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//span[@role = 'button' and @id = '" + seatno + "']")));
		
		return wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[@role = 'button' and @id = '" + seatno + "']")));
	}
	
	public WebElement seatPrice(String seatno) {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@role = 'button' and @id = '" + seatno + "']")));
		
		return driver.findElement(By.xpath("//span[@id='" + seatno + "']//span[contains(@class,'sleeperPrice')]"));
	}
	
	public WebElement boardDropButton() {
		
		return wait.until(ExpectedConditions
				.elementToBeClickable(SearchPageLocators.boarddropbtn));
	}
	
	public WebElement boardPoint(String boardingpt) {
		
		return wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[text()='" + boardingpt + "']")));
	}
	
	public WebElement dropPoint(String droppingpt) {
	
	return wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//div[text()='" + droppingpt + "']")));
	}
	
	/*public WebElement fillDetailsButton() {
		
		wait.until(ExpectedConditions
				.presenceOfElementLocated(SearchPageLocators.filldetailsbtn));
		
		return wait.until(ExpectedConditions
				.elementToBeClickable(SearchPageLocators.filldetailsbtn));
	}*/
	
	
	public WebElement phoneInput() {
		
		return wait.until(ExpectedConditions
				.presenceOfElementLocated(SearchPageLocators.phoneinput));
	}
	
	public WebElement emailInput() {
		
		return wait.until(ExpectedConditions
				.presenceOfElementLocated(SearchPageLocators.emailinput));
	}
	
	public WebElement stateButton() {
		
		return wait.until(ExpectedConditions
				.elementToBeClickable(SearchPageLocators.statebtn));
	}
	
	public WebElement stateInput(String state) {
		
		wait.until(ExpectedConditions
				.presenceOfElementLocated(SearchPageLocators.statedialogbox));
		
		return wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[text() = '"+ state + "']")));
				
	}
	
	public WebElement nameInput() {
		
		return wait.until(ExpectedConditions
				.presenceOfElementLocated(SearchPageLocators.nameinput));
	}	
	
	public WebElement ageInput() {
		
		return wait.until(ExpectedConditions
				.presenceOfElementLocated(SearchPageLocators.ageinput));
		
	}
	
	public WebElement genderInput(String gender) {
		
		if(gender.equals("Male")) {
			return wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("(//div[contains(@class, 'toggleBtn')])[1]")));
		} else {
		
		return wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[contains(@class, 'toggleBtn')])[2]")));
		}
	}
	
	public WebElement noFreeCanBtn() {
		
		return wait.until(ExpectedConditions
				.elementToBeClickable(SearchPageLocators.nofcbtn));
		
	}
	
	public WebElement noBusInsBtn() {
		
		return wait.until(ExpectedConditions
				.elementToBeClickable(SearchPageLocators.nobibtn));
		
	}
	
	public WebElement redCareToggle() {
		
		return wait.until(ExpectedConditions
				.presenceOfElementLocated(SearchPageLocators.redcaretoggle));
		
	}
	
	public WebElement continueButton() {
		
		return wait.until(ExpectedConditions
				.elementToBeClickable(SearchPageLocators.continuebtn));
		
	}

}
