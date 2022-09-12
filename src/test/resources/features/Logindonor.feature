Feature: Login Already Existing Donor Tests

  Background: Navigate to Be A Friend Of Shefaa Page

  Scenario Outline: Login already existing donor successfully

    Given user on be a friend of shefaa page And choose user type option <user type>
    When enter his mobile number <mobile number>
    And enter the correct otp And confirm <otp>
    Then user will move to home page
    Examples:
       | mobile number | otp |
     | 996279056368     | 123321 |