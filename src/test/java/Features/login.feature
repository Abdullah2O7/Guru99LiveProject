Feature: Login Function
  Verify that the user can login to the Bank Website successfully

  Scenario Outline: Login Functionality
    Given The user is in the Login page
    When user enters valid <username> and <password>
    Then user login to the website successfully

    Examples:
      | username  | password |
      | mngr572310 | EhYpyrE |
