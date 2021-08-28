Feature: Contact page should display customer contact details

  @db
  Scenario: Contacts test with email
    Given the user is on the login page
    Given the user logged in as "salesManager"
    And the user navigates to "Customers", "Contacts"
    When the user clicks the "mbrackstone9@example.com" from contacts
    Then the information should be same with database

  @db
  Scenario: Vehicle model UI DB Comparison
    Given the user is on the login page
    Given the user logged in as "salesManager"
    And the user navigates to "Fleet", "Vehicles Models"
    When the user clicks the "Mazda" from List
    Then the Vehicle model information should be same with database