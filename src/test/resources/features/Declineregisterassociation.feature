Feature: System Manager Decline To Register Association Tests

  Background: Navigate to Shefaa Login Page

  Scenario Outline: Decline To Register Association successfully

    Given system manager on login page And choose signin button
    When enter his mobile number <mobile number>
    And enter the correct otp And confirm <otp>
    Then system manager will move to requests page And choose any new request And show it
    Then system manager write a a reason in the field and press decline button And close the request <decline reason>
    Examples:
      | mobile number | otp | decline reason |
      | 996279056368     | 123321               | here to enter the reason why you reject it |