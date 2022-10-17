Feature: Manufacturers adding and deleting

@smoke
Scenario: Add manufacturer
Given user launch chrome browser
When user opens url "http://admin-demo.nopcommerce.com/login"
And user enters email as  "admin@yourstore.com" and password as "admin"
And click on login
Then click on the catalog
And click on the Manufacturers
Then click on addnew
And Enter all the details
And click on save
Then user should found manfacturer message added in the browser
And close browser
