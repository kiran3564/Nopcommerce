Feature: Getting the data inside the objects of the page

Scenario: Getting the data from the Nopcommerce
Given user launch chrome browser
When user opens url "http://admin-demo.nopcommerce.com/login"
And user enters email as  "admin@yourstore.com" and password as "admin"
And click on login
Then page source should contain "NopCommerce News"
And close browser

Scenario: Getting the data from the Nopcommerce and printing in console
Given user launch chrome browser
When user opens url "http://admin-demo.nopcommerce.com/login"
And user enters email as  "admin@yourstore.com" and password as "admin"
And click on login
And print the content of nopcommerce news in console/
Then click on logout
And close browser

Scenario: Getting the data from the Nopcommerce and saving in the txt file
Given user launch chrome browser
When user opens url "http://admin-demo.nopcommerce.com/login"
And user enters email as  "admin@yourstore.com" and password as "admin"
And click on login
And get the data and save it in the text file
Then click on logout
And close browser


Scenario: check wether order total is present in dashboard or not
Given user launch chrome browser
When user opens url "http://admin-demo.nopcommerce.com/login"
And user enters email as  "admin@yourstore.com" and password as "admin"
And click on login
Then page source should contained the text " Order totals"
Then click on logout

Scenario: Getting the orders data and printing in the excel sheet
Given user launch chrome browser
When user opens url "http://admin-demo.nopcommerce.com/login"
And user enters email as  "admin@yourstore.com" and password as "admin"
And click on login
Then Get the orders data and save in the excel
Then click on logout


Scenario: Getting the latest orders data and printing in the excel sheet
Given user launch chrome browser
When user opens url "http://admin-demo.nopcommerce.com/login"
And user enters email as  "admin@yourstore.com" and password as "admin"
And click on login
Then Get the latest orders data and save in the excel
Then click on logout


Scenario: Getting the latest order details based on the serial no
Given user launch chrome browser
When user opens url "http://admin-demo.nopcommerce.com/login"
And user enters email as  "admin@yourstore.com" and password as "admin"
And click on login
Then Get the latest order data based on serial no
Then click on logout


Scenario: Getting the count of popular search keyword
Given user launch chrome browser
When user opens url "http://admin-demo.nopcommerce.com/login"
And user enters email as  "admin@yourstore.com" and password as "admin"
And click on login
Then Get the count of popular search keyword if item not there do pagination
Then click on logout


Scenario: Verifying the scroller functionality
Given user launch chrome browser
When user opens url "http://admin-demo.nopcommerce.com/login"
And user enters email as  "admin@yourstore.com" and password as "admin"
And click on login
Then Scroll down and click on the upward arrow
Then click on logout


Scenario: Verifying the search functionality
Given user launch chrome browser
When user opens url "http://admin-demo.nopcommerce.com/login"
And user enters email as  "admin@yourstore.com" and password as "admin"
And click on login
Then enter the searchword as "customers" in the search menu and click on enter
Then Url should be changed
Then click on logout




