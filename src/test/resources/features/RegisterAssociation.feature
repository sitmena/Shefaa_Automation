Feature: Register New Association Tests

  Background: Navigate to Be A Friend Of Shefaa Page

  Scenario Outline: Register new association successfully

    Given user on be a friend of shefaa page And choose user type option <user type>
    When enter his mobile number And date of birth And email And id And confirm <mobile number> <date of birth> <email> <id>
    And enter the correct otp And confirm <otp>
    And enter the correct email otp And confirm <otp>
    And enter his license number And choose inquiry <license number>
    And fill the association name And association type And association logo And expiry date And license file And iban And bank account And association number And email And association location And city And town And location link And number of service providers And hospital name And discount rate And owner name And ceo name And ceo number And confirm the rules <association name> <association type> <association logo> <expiry date> <license file> <iban> <bank account> <association number> <email> <association location> <city> <town> <location link> <number of service providers> <hospital name> <discount rate> <owner name> <ceo name> <ceo number>
    And press on send button
    Then form will sent to the system manager
    Examples:
      | user type | mobile number | date of birth | email | id | otp | license number | association name | association type | association logo | expiry date | license file | iban | bank account | association number | email | association location | city | town | location link | number of service providers | hospital name | discount rate | owner name | ceo name | ceo number |
      | association    | 996279056161     | 23-4-1993  | hebafoudeh93@gmail.com | 1 | 123321 | 1 | asscoiation one | charity one | logoimage | 1-5-2025 | file | 123654 | 456389413 | 985 | association@gmail.com | airport street | amman | airport street | link here | 5 | hospitalone | 4 | heba | hebaone | 078561524|
