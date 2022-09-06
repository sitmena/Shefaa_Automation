Feature: Register New Volunteer Tests

  Background: Navigate to Shefaa Registration Page

  Scenario Outline: Register new volunteer successfully

    Given user on register page And choose user type option <user type>
    When enter his mobile number And Confirm rules and conditions <mobile number>
    And enter the correct otp And confirm <otp>
    Then user will move to his profile page
    Examples:
      | user type | mobile number | otp |
      | volunteer    | 996279056368     | 123321               |

