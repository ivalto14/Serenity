Feature: Customer Creation

  Scenario: Create a new customer

    Given the user opens the login page
    When the user attempts to log in with credentials
      | admin | serenity |
    And the user creates a new customer with details
      | SoftWorks | Jane Smith | Manager | Janet |456 Oak| Argentina | Buenos Aires | South | 11111 | 444444 | 44444 | 08/05/2026 | Janet |jane@example.com |
    And the customer should be created successfully
    Then the customer's name should be correctly displayed
      | Jane Smith |

  Scenario: Attempt to create a customer with missing required fields
    Given the user opens the login page
    When the user attempts to log in with credentials
      | admin | serenity |
    And the user attempts to create a new customer with invalid details
      |  | Jane Smith | Manager | Janet | "456 Oak" | Argentina | Buenos Aires | South | 11111 | 444444 | 44444 | 08/05/2026 | Janet | jane@example.com |
    Then the system should display a customer creation error message



