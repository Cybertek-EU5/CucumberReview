@wip
Feature: Sales manager navigation

  Background:
    # These below two steps repeating in both scenario
    # so instead of keep typing them again and again
    # we can extract these repeating steps in the backgroud section
    # background steps will run before each scenario
    Given the user is on the login page
    When the user logged in as "salesManager"

  Scenario: Navigating Fleet -- Vehicles

    And the user navigates to "Fleet", "Vehicles"
    Then the title should be "All - Car - Entities - System - Car - Entities - System"

#  @navigation
  Scenario: Navigating Fleet -- Marketing
    And the user navigates to "Marketing", "Campaigns"
    Then the title should be "All - Campaigns - Marketing"


