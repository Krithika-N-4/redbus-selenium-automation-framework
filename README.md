# RedBus Automation Testing Framework

An end-to-end UI Automation Testing Framework developed for the RedBus website using Selenium WebDriver, Java, Cucumber BDD, TestNG, Maven, and Extent Reports.

The framework supports:
- End-to-end testing
- Positive & negative test scenarios
- Data-driven testing using Excel
- Screenshot capture on failures
- Logging
- Custom exception handling
- Reusable automation components using Page Object Model (POM)

## Tech Stack

- Java
- Selenium WebDriver
- Cucumber BDD
- TestNG
- Maven
- Apache POI (Excel Data Handling)
- Extent Reports
- SLF4J Logging
- Page Object Model (POM)

## Framework Features

- BDD framework using Cucumber feature files
- Page Object Model for reusable page handling
- Common reusable step definitions
- Data-driven testing using Excel files
- Automatic screenshot capture for failed scenarios
- Extent Report integration
- Logging using SLF4J
- Custom exception handling
- Boundary Value Testing implementation
- Positive, Negative, and End-to-End test coverage

## Project Structure

```text
src/test/java
 ├── com.stepdefinition
 ├── com.pages
 ├── com.setup
 ├── com.exceptions
 └── com.testrunner

src/test/resources
 ├── Features
 ├── TestData
 └── ConfigFiles
```

---

## Feature Files

### EndToEndTest.feature
Complete end-to-end RedBus booking flow validation.

### PositiveTests.feature
Positive validation scenarios:
1. Validate selected source, destination, and bus details on payment page
2. Validate fare calculation:
   - Base Fare + GST Fare = Expected Total Amount

### NegativeTests.feature
Negative validation scenario:
- Attempt payment without entering card details

## Custom Exceptions Implemented

### AgeException
Thrown when:
- Age is less than 1
- Age is greater than 100

Used for Boundary Value Testing validation.

### NoSeatException
Thrown when no seats are available for booking.

## Reporting & Logging

The framework generates:
- Extent Reports
- Execution Logs
- Failure Screenshots

Failed scenarios automatically capture screenshots and attach them to the Extent Report.

## Sample Validations Covered

- Bus booking flow validation
- Fare calculation validation
- Boarding & dropping point validation
- Payment page validations
- Negative payment validation
- Seat availability validation
- Boundary value validations

## How to Run the Project

### Clone Repository

```bash
git clone https://github.com/Krithika-N-4/redbus-selenium-automation-framework.git
```

### Run Tests

```bash
mvn test
```

## Screenshots

### Extent Report
<img width="1919" height="915" alt="image" src="https://github.com/user-attachments/assets/e9f45b0a-9095-449c-a6cd-1289583d7156" />

### Failed Scenario Screenshot
The below screenshot was automatically captured during test failure when the expected bus name provided in the Excel test data was not available in the search results.
<img width="1910" height="859" alt="Positive TC_01 _27-05-2026_13-38-02" src="https://github.com/user-attachments/assets/9804812d-81fb-492d-a31e-7b71fcbd774b" />

### Execution Logs
<img width="1539" height="859" alt="image" src="https://github.com/user-attachments/assets/aebd2142-31a0-4659-9d0e-41b883c5a4e7" />

 ## Author
 N Krithika
