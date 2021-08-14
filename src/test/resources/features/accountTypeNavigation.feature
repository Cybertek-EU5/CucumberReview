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
  | userType     | tabName    | moduleName      | title                                                              |
  | salesManager | Fleet      | Vehicles        | All - Car - Entities - System - Car - Entities - System            |
  | salesManager | Fleet      | Vehicles Model  | All - Vehicles Model - Entities - System - Car - Entities - System |
  | salesManager | Customers  | Accounts        | All - Accounts - Customers                                         |
  | salesManager | Customers  | Contacts        | All - Contacts - Customers                                         |
  | salesManager | Activities | Calendar Events | All - Calendar Events - Activities                                 |
  | salesManager | System     | Jobs            | All - Jobs - System                                                |
  | storeManager | Fleet      | Vehicles        | All - Car - Entities - System - Car - Entities - System            |
  | storeManager | Fleet      | Vehicles Model  | All - Vehicles Model - Entities - System - Car - Entities - System |
  | storeManager | Customers  | Accounts        | All - Accounts - Customers                                         |
  | storeManager | Customers  | Contacts        | All - Contacts - Customers                                         |
  | storeManager | Activities | Calendar Events | All - Calendar Events - Activities                                 |
  | storeManager | System     | Jobs            | All - Jobs - System                                                |
  | storeManager | System     | Menus           | All - Menus - System                                               |