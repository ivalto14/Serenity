Feature: Serenity Login

  Scenario: User logs into the system
    Given the user opens the login page
    When the user attempts to log in with credentials
      | admin   | serenity |

  Scenario: Invalid login attempt
    Given the user opens the login page
    When the user attempts to log in with credentials
      | adnin   | serenity |
    Then the system should display an error message "Invalid username or password!"

