Feature: Charity Forget Password Tests

  Background: Navigate to Be A Friend Of Shefaa Page

  Scenario Outline: Charity Forget Password successfully

    Given user on be a friend of shefaa page And choose user type option <user type>
    When choose forget password option
    When enter his mobile number And send <mobile number>
    Then success message will appears and forget password sent
    Examples:
      | user type   | mobile number |
      | association | 996279056161  |
