Feature: User Authentication tests

  Background: 
    And User click on the login link

  @smoke @reg
  Scenario: Login should be success
    And User enter the username as "ortoni"
    And User enter the password as "Pass1234"
    When User click on the login button
    Then Login should be success

  @smoke @reg
  Scenario: Login should not be success
    Given User enter the username as "koushik"
    Given User enter the password as "Passkoushik"
    When User click on the login button
    But Login should fail
