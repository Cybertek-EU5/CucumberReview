Feature: Contact page should display customer contact details

  @db
  Scenario: Contacts test with email
    Given the user logged in as "sales manager"
    And the user navigates to "Customers", "Contacts"
    When the user clicks the "mbrackstone9@example.com" from contacts
    Then the information should be same with database