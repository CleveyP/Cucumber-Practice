@Calculator @e2e
Feature: Calculator End to End Tests

  Background:
    Given the user is on the home page

  Scenario Outline: User can enter two numbers, <num1> and <num2> into the inputs
    When the user enters <num1> and <num2> into the inputs
    Then  <num1> and <num2> appear on the page


    Examples:
    | num1 | num2 |
    | 1    |  2   |
    | 0    |  5   |
    |-1    |  100 |


    Scenario Outline: User can perform "<operation>" on two numbers, <num1> and <num2>
      When the user enters <num1> and <num2> into the inputs
      And the user selects the "<operation>" option
      And the user presses the submit button
      Then the <result> is shown on the screen

      Examples:
        | num1 | num2 | result | operation|
        | 1    |  2   | 2      | multiply |
        | 0    |  5   | 0      | multiply |
        |-1    |  100 | -100   | multiply |
        | 5    |  2   | 7      | add      |
        | 0    |  5   | 5      | add      |
        |-1    |  100 | 99     | add      |


