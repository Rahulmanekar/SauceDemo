@tag
Feature: Products 
  

Scenario: To test user can able to see complete discription after click on product image
Given consumer webapp
When Click on product image
Then verify product dicription is display.

Scenario: To test user can able to navigate back to product page 
Given product description
When Click on back to product button
Then All product should be display.

Scenario: To test user can able to add product in to cart 
Given consumer webapp
When Click on add to cart 
Then Verify remove button is display

Scenario: To test user can able to remove product which is previously added
Given consumer webapp
When Click on remove button
Then Verify add to cart button is display

Scenario: To test consumer can able redirect on checkout after click on my cart icon
Given consumer webapp
When Click on add to cart 
And click on my cart icon
Then Verify checkout button should show

