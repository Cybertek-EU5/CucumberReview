@calculator
Feature: Calculator app should be able to calculation

  Scenario: Adding two numbers 5 with 7
    Given I have calculator app open
    When I add 5 to 7
    Then I should get 12


  Scenario: Adding two numbers 10 with 8
    Given I have calculator app open
    When I add 10 to 8
    Then I should get 18