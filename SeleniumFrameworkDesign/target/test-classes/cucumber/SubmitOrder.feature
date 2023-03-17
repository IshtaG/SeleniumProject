
@tag
Feature: Purhase the order from Ecommerce Website
  I want to use this template for my feature file

  Background:
	Given I landed on Ecommerce page

  @Regression
  Scenario Outline: Positive test on submitting order
    Given Logged in with username<name> and password<password>	
    When I add the product <productName> to cart 
    And chckout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message displayed on confirmation page

    Examples: 
      | name 			 				  |	password 		 | productName |
      | ishita.gt@email.com |	Ishi*2512719 | ZARA COAT 3 |
      