Feature: Login

Scenario: Successful Login with valid Credentials
Given user launch chrome browser
When user opens url "http://admin-demo.nopcommerce.com/login"
And user enters email as  "admin@yourstore.com" and password as "admin"
And click on login
Then page title should be "Dashboard / nopcommerce administration"
When user click on log out link
Then page title should be "your store. Login"
And close browser

Scenario Outline: Login Data Driven
Given user launch chrome browser
When user opens url "http://admin-demo.nopcommerce.com/login"
And user enters email as  "<email>" and password as "<password>"
And click on login
Then page title should be "Dashboard / nopcommerce administration"
When user click on log out link
Then page title should be "your store. Login"
And close browser

Examples:

           | email               | password |
           | admin@yourstore.com | admin    |
           | kiran@yorstore.co   | admin    |
