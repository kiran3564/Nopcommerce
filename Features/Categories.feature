Feature: Validating the Categories module


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


Scenario: search category by name
Given user launch chrome browser
When user opens url "http://admin-demo.nopcommerce.com/login"
And user enters email as  "admin@yourstore.com" and password as "admin"
And click on login
Then click on the catalog
And click on the categories
And Enter category name 
Then click on the searchbutton
Then user should found category name in search table
And close browser



Scenario: Exporting the categories 
Given user launch chrome browser
When user opens url "http://admin-demo.nopcommerce.com/login"
And user enters email as  "admin@yourstore.com" and password as "admin"
And click on login
Then click on the catalog
And click on the categories
Then click on the export drop down 
And click on the export to excel
Then user should found the downloadedfile in the machine
And close browser
