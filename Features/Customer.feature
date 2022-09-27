Feature: Customers

Scenario: Add a customer
Given user launch chrome browser
When user opens url "http://admin-demo.nopcommerce.com/login"
And user enters email as  "admin@yourstore.com" and password as "admin"
And click on login
Then user can view dashboard
When user click on customers menu
And click on the customers menu item
And click on add new button
Then user can view add new customer page
When user enters customer info
And click on save button
Then user can view confirmation message "The new customer has been added successfully"
And close browser

Scenario: Search a customer by emailid
Given user launch chrome browser
When user opens url "http://admin-demo.nopcommerce.com/login"
And user enters email as  "admin@yourstore.com" and password as "admin"
And click on login
Then user can view dashboard
When user click on customers menu
And click on the customers menu item
Then enter customer email
And click on the search button
Then user should found email in search table
And close browser

Scenario: Search Customer by Name
Given user launch chrome browser
When user opens url "http://admin-demo.nopcommerce.com/login"
And user enters email as  "admin@yourstore.com" and password as "admin"
And click on login
Then user can view dashboard
When user click on customers menu
And click on the customers menu item
And enter customer firstname
And enter customer lastname
And click on the search button
Then user should found name in search table
And close browser


