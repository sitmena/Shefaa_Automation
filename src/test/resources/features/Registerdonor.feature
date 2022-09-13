Feature: Register New Donor Tests

  Background: Navigate to Be A Friend Of Shefaa Page

  Scenario Outline: Register new donor successfully

    Given user on be a friend of shefaa page And choose user type option <user type>
    When enter his mobile number And Confirm rules and conditions <mobile number>
    And enter the correct otp And confirm <otp> <btnType>
    Then user will move to his profile page
    Examples:
      | user type | mobile number | otp      |    btnType|
      | donor     | 996279056368  | 123321   | Register  |

