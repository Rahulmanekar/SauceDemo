@tag
Feature: Checkout 


Scenario: To test checkout button should redirect on Your Information 
Given Your cart page
When Click on checkout
Then Verify Your Information section open

Scenario: To test should not allow to place order without fill first name 
Given  Your Information textbox
When Enter first name as ""
When  Click on continue button
Then verify message as "Error: First Name is required"

Scenario: To test should not allow to place order without fill last name  
Given  Your Information textbox
When Enter first name as "jay"
When Enter last name as ""
When  Click on continue button
Then verify message as "Error: Last Name is required"

Scenario: To test should not allow to place order without fill pincode   
Given  Your Information textbox
When Enter first name as "jay"
When Enter last name as "sharma"
When  Click on continue button
Then verify message as "Error: Postal Code is required"

Scenario: To test user can able to place order 
Given  Your Information textbox
When Enter first name as "jay"
When Enter last name as "sharma"
And Enter pincode as "652642"
And Click on continue button
And Click on finish button
Then Verify successfully place order message as "hdggf"