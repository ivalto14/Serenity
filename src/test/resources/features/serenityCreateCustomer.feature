Feature: Customer Creation

  Scenario: Create a new customer

    Given the user opens the login page
    When the user attempts to log in with credentials
      | admin   | serenity |
    And the user creates a new customer with details
      | SoftWorks   | Jane Smith    | Manager       | 456 Oak | South  | 11111 | 444444 | 44444 | 08/05/2026 | jane@example.com |
    And the customer should be created successfully
    Then the customer's name should be correctly displayed


