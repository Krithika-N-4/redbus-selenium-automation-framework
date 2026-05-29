Feature: Positive Tests on RedBus Website
	
	As a user
  	I want to search and book a bus ticket
  	So that I can travel from source to destination successfully
  
	Background:
		Given The user is on RedBus website
	
	@PositiveTest1
	Scenario Outline: Positive TC_01 - To validate busname, boarding point and dropping point in Payment page
		
		When User enters source city and click in the dropdown option
		And User enters destination city and click in the dropdown option
		And User clicks date option and selects the journey date
		And User toggles Booking for women toggle and closes the pop up
		Then User clicks - search button
		
		When User clicks - multiple filters like Primo Bus, Single Seats and AC
		And User clicks - Free Cancellation banner filter
		And User selects a bus using view seats button
		And User selects an available seat
  		And User clicks - Select boarding & dropping point button
  		And User selects boarding point and dropping point
  		And User enters contact details like Phone number, Email ID and State of Residence
  		And User enters passenger details like Name "<Name>", Age "<Age>" and Gender "<Gender>"
  		And User clicks - Dont add Free Cancellation checkbox
  		And User clicks - Dont add Redbus Assurance checkbox
  		
  		And User clicks - Continue booking button
  		Then User is navigated to the Payment page
  		
  		Then The selected bus name, boarding and dropping points must be displayed correctly on the Payment page
  		
  			
  		Examples:
      		 |    Name     | Age | Gender |   
  			 |  Preshika   | 21  | Female | 
  		
  	@PositiveTest2
     Scenario Outline: Positive TC_02 - To validate that the correct total amount displayed in the Payment page 
     	
     	When User enters source city and click in the dropdown option
		And User enters destination city and click in the dropdown option
		And User clicks date option and selects the journey date
		And User toggles Booking for women toggle and closes the pop up
		Then User clicks - search button
		
		When User clicks - multiple filters like Primo Bus, Single Seats and AC
		And User clicks - Free Cancellation banner filter
		And User selects a bus using view seats button
		And User selects an available seat 
  		And User clicks - Select boarding & dropping point button
  		And User selects boarding point and dropping point
  		And User enters contact details like Phone number, Email ID and State of Residence
  		And User enters passenger details like Name "<Name>", Age "<Age>" and Gender "<Gender>"
  		And User clicks - Dont add Free Cancellation checkbox
  		And User clicks - Dont add Redbus Assurance checkbox
  		
  		And User clicks - Continue booking button
  		Then User is navigated to the Payment page
  		
  		Then The correct total amount must be displayed in the Payment page 
     		
  		Examples:
      		 |    Name     | Age | Gender |   
  			 |  Preshika   | 21  | Female | 
      
