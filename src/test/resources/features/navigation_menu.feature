@wip3
Feature: Navigation Menu

  Scenario: Navigating Fleet -- Vehicles
    Given the user is on the login page
    When the user logged in as "salesManager"
    And the user navigates to "Fleet", "Vehicles"
    Then the title should be "All - Car - Entities - System - Car - Entities - System"

  @navigation
  Scenario: Navigating Fleet -- Marketing
    Given the user is on the login page
    When the user logged in as "salesManager"
    And the user navigates to "Marketing", "Campaigns"
    Then the title should be "All - Campaigns - Marketing"


