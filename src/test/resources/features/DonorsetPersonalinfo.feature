Feature: Set Personal Information For Donor Tests

  Background: Navigate to Personal Information Page

  Scenario Outline: Set Personal Information For Donor successfully

    Given user on be a friend of shefaa page And choose user type option <user type>
    When enter his mobile number <mobile number>
    And enter the correct otp And confirm <otp> <btnType>
    And choose personal information button
    And fill the required informations And press save button <firstname> <lastname> <email> <year> <month> <day>
    Then success message will appears
    Examples:
      | mobile number    | otp    |    btnType  |   firstname  |   lastname  |   email          | year | month | day |
      | 996279056368     | 123321 |  Login      | heba          | foudeh       | heba.f@sitech.me | 1993 | april | 23  |