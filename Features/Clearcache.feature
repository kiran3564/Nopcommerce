Feature: clearing the cache in the admin
Scenario: clearing the cache


Background: Below are the common steps

Given user launch chrome browser
When user opens url "http://admin-demo.nopcommerce.com/login"
And user enters email as  "admin@yourstore.com" and password as "admin"
And click on login
Then user can view dashboard
And click on the settings
And click on the clear cache button
Then user can alert message as "For security purposes, the feature you have requested is not available on the demo site."
