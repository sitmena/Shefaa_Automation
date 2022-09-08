Feature: Login Already Existing Volunteer Tests

  Background: Navigate to Shefaa Login Page

  Scenario Outline: Login already existing volunteer successfully

    Given user on login page And choose signin button
    When enter his mobile number <mobile number>
    And enter the correct otp And confirm <otp>
    Then user will move to his profile page
    Examples:
       | mobile number | otp |
     | 996279056368     | 123321               |