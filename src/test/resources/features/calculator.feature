Feature: Calculator app should be able to calculation

  Scenario: Adding two numbers
    Given I have calculator app open
    When I add 5 to 7
    Then I should get 12

