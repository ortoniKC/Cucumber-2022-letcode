Feature: Bookcart Application tests

  Scenario: 
    Login should be success

    Given User navigate to the BookCart application
    And User clicks on the login button
    And User enter the username as ortoni
    And User enter the password as Pass1234
    When User click on the login button
    Then Login should be success
  
  
  
  
  #Scenario: 
    #Login should not be success
    #Given User navigate to the BookCart application
    #Given User clicks on the login button
    #Given User enter the username as ortoni
    #Given User enter the password as Pass21
    #When User click on the login button
    #But Login should fail
