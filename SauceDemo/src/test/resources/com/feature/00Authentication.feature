#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Authetication-(Login) 
  

Scenario: Check title of website
Given Launch consumer webapp
Then verify the title of website as "Swag Labs"

Scenario Outline:  To Test Login with different invalid credential 
Given  consumer webapp Login page
When Consumer enter "<Username>" and "<Password>"
And Click on Login button
Then verify message as "<message>"

Examples:
  |  Username    |Password     | message                             |
  |              |             | Epic sadface: Username is required  |
  | Wronguser    | WrongPass   | Epic sadface: Username and password do not match any user in this service |
  | standard_user| 6566566     | Epic sadface: Username and password do not match any user in this service |
  |  testUser    | secret_sauce| Epic sadface: Username and password do not match any user in this service |
  |locked_out_user|secret_sauce |Epic sadface: Sorry, this user has been locked out.|
  
Scenario: To test user can able to login with valid credential
Given  consumer webapp Login page
When Consumer enter "standard_user" and "secret_sauce"
And Click on Login button 
Then Verify products page is appear


