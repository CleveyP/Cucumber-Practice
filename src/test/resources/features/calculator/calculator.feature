@Calculator @Unit
Feature: Calculator Tests

  Background:
    Given the calculator is on

  Scenario Outline: Calculator Can Add Two Numbers <num1> and <num2>
    When provided with two numbers <num1> and <num2>
    And the numbers are added together
    Then the result should be <result>

    Examples:
      | num1 | num2 | result |
      | 1    | 2    | 3      |
      | -1   | 5    | 4      |
      | -1   | -6   | -7     |

  Scenario Outline: Calculator Can Subtract Two Numbers <num1> and <num2>
    When provided with two numbers <num1> and <num2>
    And the numbers are subtracted from each other
    Then the result should be <result>


    Examples:
      | num1 | num2 | result |
      | 1    | 2    | -1     |
      | -1   | 5    | -6     |
      | -1   | -6   | 5      |


    Scenario: Calculator shows Error When Dividing By Zero
      When we choose any number and zero
      Then we divide the two numbers and an error is shown

    Scenario Outline: Calculator Can Divide Two Numbers <num1> and <num2>
      When provided with two numbers <num1> and <num2>
      And the numbers are divided together
      Then the result should be <result>


      Examples:
        | num1 | num2 | result |
        | 1    | 2    | 0      |
        | -10  | 5    | -2     |
        | 0    | -6   | 0      |
