package com.stepdefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.slf4j.Logger;

import com.pages.PaymentPage;
import com.pages.SearchPage;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;

import com.setup.MyLog;

import io.cucumber.java.en.Then;

public class PositiveTestsSteps {
	
	/*
	 -----------------------------Positive Test 1 Scenario----------------------------
	 * Created by: N Krithika
	 * Reviewed by: 
	 * Description: 
	 * Validates if the selected bus name, boarding and dropping points are 
	   displayed correctly on the Payment page.
	   
	 -----------------------------Positive Test 2 Scenario----------------------------
	 * Created by: N Krithika
	 * Reviewed by: 
	 * Description: 
	 * Validates if the correct total amount is displayed in the Payment page.	   
    */
	
	public static Logger log = MyLog.getLogger(PositiveTestsSteps.class);
	
	SearchPage searchpage = new SearchPage();
	PaymentPage paymentpage = new PaymentPage();
	
	Object[][] data;
	
	String filter1;
	
	String busname, seatno, boardingpt, droppingpt;
	
	@Then("The selected bus name, boarding and dropping points must be displayed correctly on the Payment page")
	public void busname_boardingpt_droppingpt_validation() throws InterruptedException {
		
		try {
			
			log.info("TC_01 - The selected bus name, boarding and dropping points must be displayed correctly on the Payment page");
			
			data = ExcelReader.readExcelData(BaseSteps.exceldatapath, "Searchpage");
			
			busname = data[0][6].toString();
			boardingpt = data[0][7].toString();
			droppingpt = data[0][8].toString();
			
			String actualbusname = paymentpage.busName().getText();
			
			String actualboardingpt = paymentpage.boardingPoint().getText();
			
			String actualdroppingpt = paymentpage.droppingPoint().getText();
			
			try  {
				
				assertTrue(actualbusname.contains(busname), "Busname did not match");
				
				assertTrue(actualboardingpt.contains(boardingpt), "Boarding point did not match");
				
				assertTrue(actualdroppingpt.contains(droppingpt), "Dropping point did not match");
				
				Thread.sleep(3000);
				
				log.info("TC_01 passed - The selected bus name, boarding and dropping points are displayed correctly on the Payment page");
				
				BaseSteps.test.pass("TC_01 passed - The selected bus name, boarding and dropping points are displayed correctly on the Payment page");
				
			}
			
			catch (AssertionError ae) {
				
				log.info("TC_01 failed - The selected bus name, boarding and dropping points are not displayed correctly on the Payment page");
				
				BaseSteps.test.fail("TC_01 failed - The selected bus name, boarding and dropping points are not displayed correctly on the Payment page");
				
			}
			
		}
		
		catch (InvalidFormatException iofe) {
			 log.info("Excel file cannot be read");
			 
		}
		 
		catch (IOException io) {
			 log.info("Excel file cannot be read");
		}
	}
	
	@Then("The correct total amount must be displayed in the Payment page")
	public void correct_total_amount_must_be_displayed_in_the_payment_page() throws InterruptedException {
		
		
		float basefare = paymentpage.getAmountAsFloat(paymentpage.baseFare().getText());
			
		log.info("Base fare = " + basefare);
			
		float gstfare = paymentpage.getAmountAsFloat(paymentpage.gstFare().getText());
			
		log.info("gst fare = " + gstfare);
		
		float exptotal = basefare + gstfare;
			
		log.info("Expected total = " + exptotal);
			
		float actualtotal = paymentpage.getAmountAsFloat(paymentpage.totalFare().getText());
			
		log.info("Actual total = " + actualtotal);
			
		try {
				
			assertEquals(actualtotal, exptotal, "Total amount calculation mismatch!");
			
			Thread.sleep(3000);
				
			log.info("TC_02 passed - Correct total amount is displayed");
				
			BaseSteps.test.pass("TC_02 passed - Correct total amount is displayed");
		}
			
		catch (AssertionError ae) {
				
			log.info("TC_02 failed - Correct total amount is not displayed");
				
			BaseSteps.test.fail("TC_02 failed - Correct total amount is not displayed");
		}					
	}
}	