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

@smoke
Scenario: check wether order total is present in dashboard or not
Given user launch chrome browser
When user opens url "http://admin-demo.nopcommerce.com/login"
And user enters email as  "admin@yourstore.com" and password as "admin"
And click on login
Then page source should contained the text " Order totals"
Then click on logout


