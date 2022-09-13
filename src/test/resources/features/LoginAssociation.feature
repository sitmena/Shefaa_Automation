Feature: Login Already Existing Association Tests

  Background: Navigate to Be A Friend Of Shefaa Page

  Scenario Outline: Login already existing association successfully

    Given user on be a friend of shefaa page And choose user type option <user type>
    When enter his mobile number And password <mobile number> <password>
    And choose login button
    Then user will move to association home page
    Examples:
      |user type    | mobile number | password |
      | association | 996279056368     | sitech@1234 |