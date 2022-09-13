Feature: Register New Association Tests

  Background: Navigate to Be A Friend Of Shefaa Page

  Scenario Outline: Register new association successfully

    Given user on be a friend of shefaa page And choose user type option <user type>
    When enter his mobile number And date of birth And email And id And confirm <mobile number> <year> <month> <day> <email> <id>
    And enter the correct mobile otp And confirm <otp>
    And enter the correct email otp And confirm <otp>
    And enter his license number And choose inquiry <license number>
    And fill the registration form And confirm the rules <iban> <association number> <email> <second otp> <association location> <location link> <number of service providers> <discount rate> <ceo name> <ceo number>
    And press on send button
    Then form will sent to the system manager
    Examples:
      | user type   | mobile number | year |  month| day |  email                 | id   | otp    | license number   |  iban   | association number  | email                 | second otp | association location |   location link | number of service providers |  discount rate |  ceo name |ceo number |
      | association | 996279056161  |1993  |April  | 23  | hebafoudeh93@gmail.com | 1    | 123321 | 1                |  123654 |  985                | association@gmail.com | 123321     |airport street       |   link here     | 5                           | 4             |  hebaceo  |078561524 |
