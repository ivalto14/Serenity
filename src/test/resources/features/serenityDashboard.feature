Feature: Serenity Dashboard Navigation

  Scenario: The user navigates and verifies Administration visibility
    Given the user opens the login page
    When the user attempts to log in with credentials
      | admin   | serenity |
    And the user navigates through the dashboard
    Then the user should see all the dashboard sections
