# My Testing Framework

This is a testing framework designed for automating tests for the Final Project. It utilizes the Page Object pattern to create maintainable and readable tests.

## Getting Started

These instructions will help you set up and run the tests on your local machine.

### Prerequisites

- Java JDK 17 or higher
- Maven
- Chrome or Firefox browser (based on your configuration)

### Installation

1. Clone this repository to your local machine.
2. Running Tests
To run the tests, use the following command:
mvn clean test
3. Configuration
You can configure the test execution by modifying the pom.xml file. 
Parameters like browser, resolution, and thread count can be adjusted there.
   mvn clean test -Dbrowser=EDGE
   mvn clean test -Dbrowser=FIREFOX
   mvn clean test -Dbrowser=SAFARI
   mvn clean test -Dbrowser=CHROME
4. Reporting
This framework uses Allure for reporting. After running tests,
you can generate and view the Allure report using the following
command:
mvn allure::serve
5. Test Cases
   The following test cases are implemented:
 - Subscribe with invalid email
 - Check languages
 - Registration with valid data
 - Registration with invalid data
 - Check categories
 - Check popular products
 - Price drop check
 - Sorting check
 - Adding to cart
 - Checkout end-to-end
Bugs and Issues
If you encounter any bugs or issues, please report them 
in the Issues section of this repository.
