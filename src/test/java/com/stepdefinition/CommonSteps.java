package com.stepdefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.slf4j.Logger;

import com.aventstack.extentreports.util.Assert;
import com.pages.HomePage;
import com.pages.PaymentPage;
import com.pages.SearchPage;
import com.parameters.ExcelReader;
import com.setup.AgeException;
import com.setup.BaseSteps;
import com.setup.MyLog;
import com.setup.NoSeatException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonSteps {
	
	public static Logger log = MyLog.getLogger(CommonSteps.class);
	
	HomePage homepage = new HomePage();
	SearchPage searchpage = new SearchPage();
	PaymentPage paymentpage = new PaymentPage();
	
	Object[][] data;
	
	String frominput, toinput, date;
	String busname, seatno, boardingpt, droppingpt;
	String phoneno, emailid, state;
	String cardnumber, cardholdername, expirydate, cvv;
	
	@Given("The user is on RedBus website")
	public void the_user_is_on_red_bus_website() throws InterruptedException {
		
		//test = ExtentManager.getInstance().createTest("End to End Test");
		
	    assertTrue(homepage.checkTitle("redBus"), "RedBus page not loaded");
	    assertTrue(homepage.checkUrl("redbus"), "RedBus page not loaded");
	    
	    log.info("RedBus page loaded");
	    BaseSteps.test.pass("RedBus page loaded");
	}

	@When("User enters source city and click in the dropdown option")
	public void user_enters_source_city_as_chennai_and_click_in_the_dropdown_option() throws InterruptedException {
		
		try {
			
			BaseSteps.test.info("User enters source city and click in the dropdown option");
			
			data = ExcelReader.readExcelData(BaseSteps.exceldatapath, "Homepage");
			
			frominput = data[0][0].toString();
	        
			log.info("Clicking 'from' button");
			WebElement frombtn = homepage.fromButton();
			homepage.clickElement(frombtn);
			
			log.info("Typing 'from' location - Chennai");
			WebElement frominputbox = HomePage.driver.switchTo().activeElement();
			homepage.typeData(frominputbox, frominput);
			
			log.info("Clicking 'from' location - Chennai");
			WebElement fromselect = homepage.fromInput(frominput);
			
			homepage.clickElement(fromselect);
		}
		
		catch (InvalidFormatException iofe) {
			 log.info("Excel file cannot be read"); 
		}
		 
		catch (IOException io) {
			 log.info("Excel file cannot be read");
		}
	}

	@When("User enters destination city and click in the dropdown option")
	public void user_enters_destination_city_as_coimbatore_and_click_in_the_dropdown_option() throws InvalidFormatException, IOException, InterruptedException {
		
			BaseSteps.test.info("User enters destination city and click in the dropdown option");
		
			data = ExcelReader.readExcelData(BaseSteps.exceldatapath, "Homepage");
			
	        toinput = data[0][1].toString();
	      
			log.info("Clicking 'to' button");
			WebElement tobtn = homepage.toButton();
			homepage.clickElement(tobtn);
			
			log.info("Typing 'to' location - Trichy");
			WebElement toinputbox = HomePage.driver.switchTo().activeElement();
			homepage.typeData(toinputbox, toinput);
			
			log.info("Clicking 'to' location - Trichy");
			WebElement toselect = homepage.toInput(toinput);
			
			homepage.clickElement(toselect);
			
			BaseSteps.actions.sendKeys(Keys.HOME).perform();
			
			Thread.sleep(500);		
	}

	@When("User clicks date option and selects the journey date")
	public void user_clicks_date_option_and_selects_the_journey_date() throws InterruptedException, InvalidFormatException, IOException {
		
			BaseSteps.test.info("User clicks date option and selects the journey date");
			
			data = ExcelReader.readExcelData(BaseSteps.exceldatapath, "Homepage");
			
			date = data[0][2].toString();
	        
			log.info("Clicking date button");
			WebElement datebtn = homepage.dateButton();
			homepage.clickElement(datebtn);
			
			log.info("Clicking date arrow button");
			WebElement datearrow = homepage.dateArrow();
			homepage.clickElement(datearrow);
			
			log.info("Selecting date");
			WebElement dateinput = homepage.dateInput(date);
			
			Thread.sleep(500);
		
			BaseSteps.actions.moveToElement(dateinput).pause(Duration.ofMillis(300))
			.click().perform();			
	}

	@When("User toggles Booking for women toggle and closes the pop up")
	public void user_toggles_booking_for_women_toggle_and_closes_the_pop_up() throws InterruptedException {
		
		BaseSteps.test.info("User toggles Booking for Women toggle and closes the pop up");
	    
		log.info("Booking for women toggle");
		WebElement womentoggle = homepage.womenToggle();
		
		BaseSteps.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		homepage.clickElement(womentoggle);
		
		log.info("Closing booking for women popup");
		WebElement gotitbtn = homepage.gotItButton();
		
		homepage.clickElement(gotitbtn);
	}

	@Then("User clicks - search button")
	public void user_clicks_search_button() throws InterruptedException {
		
		BaseSteps.test.info("User clicks - search button");
	    
		log.info("Clicking search button");
		WebElement searchbtn = homepage.searchButton();
		
		homepage.clickElement(searchbtn);
	}

	@When("User selects a bus using view seats button")
	public void user_selects_a_bus_using_view_seats_button() throws InvalidFormatException, IOException, TimeoutException, InterruptedException {
		
		BaseSteps.test.info("User selects a bus using view seats button");
		
		data = ExcelReader.readExcelData(BaseSteps.exceldatapath, "Searchpage");
		
		busname = data[0][6].toString();
		
		log.info("Clicking view seats button of the preferred bus");
		WebElement viewseatsbtn = searchpage.viewSeatsButton(busname);
		
		Assert.notNull(viewseatsbtn, "View Seats button not found for bus: " + busname);

		BaseSteps.actions.scrollToElement(viewseatsbtn).perform();
		
		searchpage.clickElement(viewseatsbtn);
	}
	
	//CUSTOM NoSeatException IN PAGE CLASS
	@And("User selects an available seat")
	public void user_selects_an_available_seat() throws InvalidFormatException, IOException, InterruptedException, NoSeatException {
		
		BaseSteps.test.info("User selects an available seat");
			
		seatno = searchpage.emptySeat();
		
		log.info("Clicking seat input");
		WebElement seatinput = searchpage.seatInput(seatno);
		
		BaseSteps.actions.moveToElement(seatinput).perform();
		
		searchpage.clickElement(seatinput);	
	}
	
	@And("User clicks - Select boarding & dropping point button")
	public void user_clicks_on_the_button_select_boarding_dropping_point() throws InterruptedException {
				
		BaseSteps.test.info("User clicks - Select boarding & dropping point");
			    
		log.info("Clicking 'select boarding & dropping points' button");
		WebElement boarddropbtn = searchpage.boardDropButton();
		
		searchpage.clickElement(boarddropbtn);
	}

	@And("User selects boarding point and click Fill passenger details button")
	public void user_selects_boarding_point_and_dropping_point() throws InvalidFormatException, IOException, InterruptedException {
		
		BaseSteps.test.info("User selects boarding point and dropping point");
		
		data = ExcelReader.readExcelData(BaseSteps.exceldatapath, "Searchpage");
		
		boardingpt = data[0][7].toString();
		droppingpt = data[0][8].toString();
		
		log.info("Clicking boarding point - REDHILLS YBM YARD");
		WebElement boardpt = searchpage.boardPoint(boardingpt);
		
		searchpage.clickElement(boardpt);
		
		/*log.info("Clicking dropping point - Gandhipuram");
		WebElement droppt = searchpage.dropPoint(droppingpt);
		searchpage.clickElement(droppt);*/
		
		log.info("Clicking Fill passender details button");
		WebElement filldetailsbtn = searchpage.fillDetailsButton();
	
		searchpage.clickElement(filldetailsbtn);
	}

	@When("User enters contact details like Phone number, Email ID and State of Residence")
	public void user_enters_contact_details_like_phone_number_email_id_and_state_of_residence() throws InvalidFormatException, IOException, InterruptedException {
		
		BaseSteps.test.info("User enters contact details like Phone number, Email ID and State of Residence");
		
		data = ExcelReader.readExcelData(BaseSteps.exceldatapath, "Detailspage");
		
		phoneno = data[0][0].toString();
		emailid = data[0][1].toString();
		state = data[0][2].toString();
	    
		log.info("Typing phone number input");
		WebElement phoneinput = searchpage.phoneInput();
		searchpage.typeData(phoneinput, phoneno);
		
		log.info("Typing email input");
		WebElement emailinput = searchpage.emailInput();
		searchpage.typeData(emailinput, emailid);
		
		log.info("Clicking 'State of Residence' button");
		WebElement statebtn = searchpage.stateButton();
		homepage.clickElement(statebtn);
		
		log.info("Clicking 'State of Residence' input - 'Tamil Nadu'");
		WebElement stateinput = searchpage.stateInput(state);
		searchpage.clickElement(stateinput);
		
	}

	//CUSTOM AgeException and BOUNDARY VALUE TESTING in BaseSteps
	@When("User enters passenger details like Name {string}, Age {string} and Gender {string}")
	public void user_enters_passenger_details_like_name_age_and_gender(String name, String age, String gender) throws InterruptedException, AgeException {
		
		BaseSteps.test.info("User enters passenger details like Name, Age and Gender");
	    
		log.info("Typing name input");
		WebElement nameinput = searchpage.nameInput();
		searchpage.typeData(nameinput, name);
		
		log.info("Typing age input");
		WebElement ageinput = searchpage.ageInput();
		
		searchpage.validateAge(age);
		
		searchpage.typeData(ageinput, age);
		
		log.info("Clicking gender button");
		WebElement genderinput = searchpage.genderInput(gender);
		searchpage.clickElement(genderinput);
	
	}
	
	@When("User clicks - Continue booking button")
	public void user_clicks_continue_booking_button() throws InterruptedException {
		
		BaseSteps.test.info("User clicks - Continue booking button");
	    
		log.info("Clicking 'Continue booking' button");
		WebElement continuebtn = searchpage.continueButton();
		BaseSteps.actions.moveToElement(continuebtn).perform();

		searchpage.clickElement(continuebtn);		
	}
}
