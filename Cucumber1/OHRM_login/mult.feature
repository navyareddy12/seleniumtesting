Feature:OHRM login functionality
Scenario Outline:OHRM login functionality validation
Given open Chrome Browser and navigate to orangeHRM application
When user enters valid "<username>" and "<password>" and click on signin button
Then user should be able to succesfuly login to the application and take "<username>" and close the application
Examples:
| username | password |
| Admin    | admin123 |
| mouni    | admin   |
| username | admina    |