Feature: Test the Login Function using DataTable
  Verify that the user can login to the Bank Website successfully

  Scenario: Login Functionality
    Given The user is in the Login page
    When user enters valid credentials using DataTable
      | mngr572310 | EhYpyrE |
    Then user login to the website successfully

