@wip2
Feature: Different type of user should be able to login

#  Scenario: Driver should be able to login
#
#
#  Scenario: SalesManager should be able to login
#
#
#  Scenario: StoreManager should be able to login

  Scenario Outline: User types <userType> should be able to login
    Given the user is on the login page
    When the user logged in as "<userType>"
    Then the title should be "Dashboard"
    Examples:
      | userType      |
      | driver        |
      | storeManager |
      | salesManager |

