Feature: System Manager Accept Register Association Tests

  Background: Navigate to Admin System Login Page

  Scenario Outline: Accept Register Association successfully

    Given system manager on Admin page And choose signin button
    When enter his email And password And choose login<email> <password>
    And system manager will move to requests page And choose any new request And show it
    Then enter the required fields And accept <operational ratio> <Sustainability ratio>
    Then close the form
    Examples:
      | email             | password   | operational ratio | Sustainability ratio |
      | heba.f@sitech.me  | sitech@123 | 5                | 7                   |