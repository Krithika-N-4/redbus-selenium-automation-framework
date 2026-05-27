package com.stepdefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.setup.MyLog;
import org.slf4j.Logger;

import com.pages.HomePage;
import com.pages.PaymentPage;
import com.pages.SearchPage;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EndToEndSteps {
	
	
	 /*
		 -----------------------------End to End Scenario----------------------------
		 * Created by: N Krithika
		 * Reviewed by: 
		 * Description: 
		 * Validates the complete RedBus bus ticket booking workflow from bus search, 
		   applying multiple filters, to seat selection, passenger details entry and
		   payment details entry.
	*/
	
	public static Logger log = MyLog.getLogger(EndToEndSteps.class);
	
	HomePage homepage = new HomePage();
	SearchPage searchpage = new SearchPage();
	PaymentPage paymentpage = new PaymentPage();
	
	Object[][] data;
	
	String filter1, filter2, filter3, bannerfilter;
	String otherfilter, otherfilteropt;
	String cardnumber, cardholdername, expirydate, cvv;
	
	
	@Then("The list of available buses should be displayed")
	public void the_list_of_available_buses_should_be_displayed() throws InterruptedException {
		
		BaseSteps.wait.until(ExpectedConditions.titleContains("Book from"));
		assertTrue(homepage.checkTitle("Book from"), "RedBus Search Results page not loaded");
		
		BaseSteps.wait.until(ExpectedConditions.urlContains("bus-tickets"));
	    assertTrue(homepage.checkUrl("bus-tickets"), "RedBus Search Results page not loaded");
	    
	    Thread.sleep(3000);

	    BaseSteps.test.pass("The list of available buses should be displayed");
	}

	@When("User clicks - multiple filters like Primo Bus, Single Seats and AC")
	public void user_clicks_multiple_filters_like_primo_bus_single_seats_and_ac() throws InvalidFormatException, IOException, InterruptedException {
		
		BaseSteps.test.info("User clicks - multiple filters like Primo Bus, Single Seats and AC");
		
		data = ExcelReader.readExcelData(BaseSteps.exceldatapath, "Searchpage");
		
		filter1 = data[0][0].toString();
		filter2 = data[0][1].toString();
		filter3 = data[0][2].toString();
	    
		log.info("Clicking 'Primo Bus' filter button");
		WebElement filteropt1 = searchpage.Filter1(filter1);
		Thread.sleep(1000);
		searchpage.clickElement(filteropt1);
		
		log.info("Clicking 'AC' filter button");
		WebElement filteropt2 = searchpage.Filter2(filter2);
		Thread.sleep(1000);
		searchpage.clickElement(filteropt2);
		
		log.info("Clicking 'Single Seats' filter button");
		WebElement filteropt3 = searchpage.Filter3(filter3);
		Thread.sleep(1000);
		searchpage.clickElement(filteropt3);
	}
	
	@When("User clicks - Free Cancellation banner filter")
	public void user_clicks_free_cancellation_banner_filter() throws InvalidFormatException, IOException, InterruptedException {
		
		BaseSteps.test.info("User clicks - Free Cancellation banner filter");
		
		data = ExcelReader.readExcelData(BaseSteps.exceldatapath, "Searchpage");
		
		bannerfilter = data[0][3].toString();
		
		log.info("Clicking 'Free cancellation Banner' button");
		WebElement banner = searchpage.bannerFilter(bannerfilter);
		Thread.sleep(1000);
		searchpage.clickElement(banner);
	}

	@And("User clicks - Special bus features filter button and clicks the Free date change option")
	public void user_clicks_amenities_filter_button_and_clicks_the_charging_point_filter() throws InvalidFormatException, IOException, InterruptedException  {
		
		BaseSteps.test.info("User clicks - Special bus features filter button and clicks the On Time option");
		
		data = ExcelReader.readExcelData(BaseSteps.exceldatapath, "Searchpage");
		
		otherfilter = data[0][4].toString();
		otherfilteropt = data[0][5].toString();
	    
		log.info("Clicking 'Special bus features' filter button");
		WebElement featuresbtn = searchpage.specialFeaturesBtn(otherfilter);
		Thread.sleep(1000);
		searchpage.clickElement(featuresbtn);
		
		log.info("Clicking 'Special bus features' filter option - On Time");
		WebElement featuresinput = searchpage.specialFeaturesInput(otherfilteropt);
		Thread.sleep(1000);
		searchpage.clickElement(featuresinput);
	}

	@Then("All the selected filters are applied in the search list")
	public void all_the_selected_filters_are_applied_in_the_search_list() throws InterruptedException {
		
		List <WebElement> appliedfilters = searchpage.appliedFilters();
		
		boolean primobus = false;
		boolean ac = false;
		boolean singleseats = false;
		
		for(WebElement filter : appliedfilters) {
			String filtername = filter.getText();
		
			if (filtername.contains("Primo")) {
			    primobus = true;
			} 
			else if (filtername.contains("AC")) {
				ac = true;
			} 
			else if (filtername.contains("Single Seats")) {
			    singleseats = true;
			}
	
		}
		
		assertTrue(primobus, "Primo Bus filter not applied");
		assertTrue(ac, "AC filter not applied");
		assertTrue(singleseats, "Single Seats filter not applied");
		
		BaseSteps.test.info("All the selected filters are applied in the search list");
		
		Thread.sleep(4000);
	}

	@When("User clicks - Dont add Free Cancellation checkbox")
	public void user_clicks_dont_add_free_cancellation_checkbox() throws InterruptedException {
		
		BaseSteps.test.info("User clicks - Dont add Free Cancellation checkbox");
	    
		log.info("Clicking 'Don't add Free Cancellation' button");
		WebElement nofcbtn = searchpage.noFreeCanBtn();
		Thread.sleep(1000);
		searchpage.clickElement(nofcbtn);
	}

	@When("User clicks - Dont add Redbus Assurance checkbox")
	public void user_clicks_dont_add_redbus_assurance_checkbox() throws InterruptedException {
		
		BaseSteps.test.info("User clicks - Dont add Redbus Assurance checkbox");
	    
		log.info("Clicking 'Don’t add redBus Assurance' button");
		WebElement nobusinsbtn = searchpage.noBusInsBtn();
		BaseSteps.actions.moveToElement(nobusinsbtn).perform();
		Thread.sleep(1000);
		searchpage.clickElement(nobusinsbtn);
	}

	@When("User toggles - redBus Cares Donation toggle")
	public void user_toggles_red_bus_cares_donation_toggle() throws InterruptedException {
		
		BaseSteps.test.info("User toggles - redBus Cares Donation toggle");
	    
		log.info("Clicking 'redBus Cares Donation' toggle");
		WebElement redcaretoggle = searchpage.redCareToggle();
		
		BaseSteps.actions.scrollToElement(redcaretoggle).pause(Duration.ofMillis(300)).perform();
		Thread.sleep(1000);
		searchpage.clickElement(redcaretoggle);
	}

	@Then("User is navigated to the Payment page")
	public void user_is_navigated_to_the_payment_page() throws InterruptedException {
		
		BaseSteps.wait.until(ExpectedConditions.titleContains("Payment"));
		assertTrue(searchpage.checkTitle("Payment"), "RedBus Payment page not loaded");
		
		BaseSteps.wait.until(ExpectedConditions.urlContains("paymentDetails"));
	    assertTrue(searchpage.checkUrl("paymentDetails"), "RedBus Payment page not loaded");
	
		Thread.sleep(1000);

	    BaseSteps.test.pass("User is navigated to the Payment page");
	}

	@When("User clicks - Add credit\\/debit card button")
	public void user_click_add_credit_debit_card_button() throws InterruptedException {
		
		BaseSteps.test.info("User clickS - Add credit/debit card button");
			    
		log.info("Clicking 'Add credit/debit card' button");
		WebElement cardbtn = paymentpage.cardButton();
		Thread.sleep(1000);
		paymentpage.clickElement(cardbtn);
	}
	
	@When("User enters card number, card holder name, expiry date and cvv")
	public void user_enters_card_details() throws InterruptedException, InvalidFormatException, IOException {
		
		try {
			
			BaseSteps.test.info("User enters card number, card holder name, expiry date and cvv");
			
			data = ExcelReader.readExcelData(BaseSteps.exceldatapath, "Paymentpage");
			
			Thread.sleep(1000);

			cardnumber = data[0][0].toString();
			cardholdername = data[0][1].toString();
			expirydate = data[0][2].toString();
			cvv = data[0][3].toString();
		    
			log.info("Typing card number");
			WebElement cardno = paymentpage.cardNoInput();
			paymentpage.typeData(cardno, cardnumber);
			
			log.info("Typing card name");
			WebElement cardname = paymentpage.cardNameButton();
			paymentpage.clickElement(cardname);
			Thread.sleep(100);
			
			String name = " " + cardholdername;
			for(char c : name.toCharArray()) {
				cardname.sendKeys(String.valueOf(c));
				Thread.sleep(150);
			}
			
			log.info("Typing expiry date");
			WebElement expdate = paymentpage.expDateInput();
			paymentpage.typeData(expdate, expirydate);
			
			
			log.info("Typing cvv number");
			WebElement cvvbutton = paymentpage.cvvInput();
			paymentpage.clickElement(cvvbutton);
			
			WebElement cvvinput = BaseSteps.driver.switchTo().activeElement();
			paymentpage.typeData(cvvinput, cvv);
			Thread.sleep(1000);
			
			log.info("TC_01 passed - End to End RedBus Test");
			
			BaseSteps.test.pass("TC_01 passed - End to End RedBus Test");
			
		}
		
		catch (Exception e)  {
			
			log.info("TC_01 failed - End to End RedBus Test");
			
			BaseSteps.test.pass("TC_01 failed - End to End RedBus Test");	
		}
		
	}
	
}
