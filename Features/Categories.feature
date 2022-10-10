Feature: Validating the Categories module

@smoke
Scenario: Adding the new category in the category module
Given user launch chrome browser
When user opens url "http://admin-demo.nopcommerce.com/login"
And user enters email as  "admin@yourstore.com" and password as "admin"
And click on login
Then click on the catalog
And click on the categories
And click on Add new
And enter the name as "Graphic card"
Then choose category
And click on the save button
And close browser