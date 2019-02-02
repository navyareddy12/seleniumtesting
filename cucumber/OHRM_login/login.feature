Feature: OHRM login functionality
Scenario: OHRM login functionality validation
Given open chrome browser and navigate to orangeHRM application
When user enters valid username and password and click on signin button
Then user should be able to successfully login to the application and close the application