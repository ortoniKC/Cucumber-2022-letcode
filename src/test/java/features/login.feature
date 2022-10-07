Feature: Bookcart Application tests

  Background: 
    Given User navigate to the BookCart application login
    And User clicks on the login button


#	@smoke @reg
  Scenario: Login should be success
    And User enter the username as "ortoni"
    And User enter the password as "Pass1234"
    When User click on the login button
    Then Login should be success

#	@reg
  Scenario: Login should not be success
    Given User enter the username as "koushik"
    Given User enter the password as "Passkoushik"
    When User click on the login button
    But Login should fail
