Feature: End to End Bus Ticket Booking on RedBus Website
	
	As a user
  	I want to search and book a bus ticket
  	So that I can travel from source to destination successfully
  
	Background:
		Given The user is on RedBus website
	
	@EndToEndTest
	Scenario: Positive TC_04 (E2E) - User books a bus ticket successfully
		When User enters source city and click in the dropdown option
		And User enters destination city and click in the dropdown option
		And User clicks date option and selects the journey date
		And User toggles Booking for women toggle and closes the pop up
		Then User clicks - search button
		Then The list of available buses should be displayed
		
		When User clicks - multiple filters like Primo Bus, Single Seats and AC
		And User clicks - Free Cancellation banner filter
		And User clicks - Special bus features filter button and clicks the Free date change option	
		Then All the selected filters are applied in the search list
	
		When User selects a bus using view seats button
		And User selects an available seat 
  		And User clicks - Select boarding & dropping point button
  		And User selects boarding point and dropping point 
  		And User enters contact details like Phone number, Email ID and State of Residence
  		And User enters passenger details like Name "<Name>", Age "<Age>" and Gender "<Gender>"
  		
  		And User clicks - Dont add Free Cancellation checkbox
  		And User clicks - Dont add Redbus Assurance checkbox
  		And User clicks - Continue booking button
  		Then User is navigated to the Payment page

  		When User clicks - Add credit/debit card button
  		And User enters card number, card holder name, expiry date and cvv 

    		Examples:
      		|   Name       |     Age     |    Gender    | 
      		|   Preshika   |     21      |    Female    | 


  		
  		
  		
  		
  		 

		
	

