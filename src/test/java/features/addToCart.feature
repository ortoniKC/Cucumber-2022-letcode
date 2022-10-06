Feature: Bookcart Application tests

  Background: 
    Given User navigate to the BookCart application

  Scenario Outline: Add to cart
    And user login into the application with "<username>" and "<password>"
    And user search for a "<book>"
    When user add the book to the cart
    Then the cart badge should get updated

    Examples: 
      | username | password | book            |
      | ortoni   | pass1234 | Roomies         |
      | ortonikc | pass1234 | The Simple Wild |
