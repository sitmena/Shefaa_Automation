Feature: Clear Personal Information For Donor Tests

  Background: Navigate to Personal Information Page

  Scenario Outline: Clear Personal Information For Donor successfully

    Given user on be a friend of shefaa page And choose user type option <user type>
    When enter his mobile number <mobile number>
    And enter the correct otp And confirm <otp> <btnType>
    And choose personal information button
    And clear optional informations And press save button
    Then clear success message will appears
    Examples:
      | mobile number    | otp    |    btnType  |
      | 996279056368     | 123321 |  Login      | 