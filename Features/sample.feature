Feature: Validating the Categories module

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