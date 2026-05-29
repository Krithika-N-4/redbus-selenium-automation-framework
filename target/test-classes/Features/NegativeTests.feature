Feature: Negative Tests on RedBus Website
	
	As a user
  	I want to search and book a bus ticket
  	So that I can travel from source to destination successfully
  
	Background:
		Given The user is on RedBus website
	
	@NegativeTest1
	Scenario: Negative TC_03 - To validate error messages for missing card details on the Payment page
		
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
  
  		When User clicks - Add credit/debit card button
  		Then User clicks - Pay amount button
  		
  		Then The respective error messages for card number "<cardnumberError>", card name "<cardnameError>", expiry date "<expirydateError>" and cvv "<cvvError>" must be displayed in the payment page
  		
  		Examples:
  			
			 | Name     | Age | Gender | cardnumberError           | cardnameError                       | expirydateError                | cvvError               |
  			 | Preshika | 21  | Female | Enter valid card number   | Please enter valid card holder name | Please enter valid expiry year | Please enter valid cvv |

      		
      		