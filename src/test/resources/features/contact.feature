Feature: Contacts page

#  @wip
  Scenario: Menu Options Driver
    Given the user is on the login page
    When the user logged in as "driver"
    Then the user should see following options
      | Fleet      |
      | Customers  |
      | Activities |
      | System     |

#    @wip
    Scenario: login as a given user
      Given the user is on the login page
      When the user logs in using following credentials
        | username  | user10      |
        | password  | UserUser123 |
        | firstname | Brenden     |
        | lastname  | Schneider   |
      Then the user should be able to login