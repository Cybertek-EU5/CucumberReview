@login
Feature: User should be able to login to Vytrack App

  Scenario: Driver should be able to login
    Given the user is on the login page
    When the user enters the driver information
    Then the user should be able to login

    @salesmanager
  Scenario: User should be able to login
    Given the user is on the login page
    When the user enters the "salesmanager101" and "UserUser123"
    Then the user should be able to login

            #homework
  Scenario: login as a user
    Given the user is on the login page
    When the user logged in as "storeManager"
    Then the user should be able to login
