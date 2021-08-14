@wip2
Feature: Each account type should see different menu items when logging in

Scenario Outline: Login with different accounts <userType>
Given the user logged in as "<userType>"
When the user navigates to "<tab>", "<module>"
Then  the title should be "<title>"

Examples:
  | userType      | tab        | module          | title                                                              |
  | driver        | Fleet      | Vehicles Model  | Vehicles Model - Entities - System - Car - Entities - System       |
  | driver        | Customers  | Accounts        | Accounts - Customers                                               |
  | driver        | Customers  | Contacts        | Contacts - Customers                                               |
  | driver        | Activities | Calendar Events | Calendar Events - Activities                                       |
  | driver        | System     | Jobs            | Jobs - System                                                      |
  | sales manager | Fleet      | Vehicles        | All - Car - Entities - System - Car - Entities - System            |
  | sales manager | Fleet      | Vehicles Model  | All - Vehicles Model - Entities - System - Car - Entities - System |
  | sales manager | Customers  | Accounts        | All - Accounts - Customers                                         |
  | sales manager | Customers  | Contacts        | All - Contacts - Customers                                         |
  | sales manager | Activities | Calendar Events | All - Calendar Events - Activities                                 |
  | sales manager | System     | Jobs            | All - Jobs - System                                                |
  | store manager | Fleet      | Vehicles        | All - Car - Entities - System - Car - Entities - System            |
  | store manager | Fleet      | Vehicles Model  | All - Vehicles Model - Entities - System - Car - Entities - System |
  | store manager | Customers  | Accounts        | All - Accounts - Customers                                         |
  | store manager | Customers  | Contacts        | All - Contacts - Customers                                         |
  | store manager | Activities | Calendar Events | All - Calendar Events - Activities                                 |
  | store manager | System     | Jobs            | All - Jobs - System                                                |
  | store manager | System     | Menus           | All - Menus - System                                               |
