@Internet @CheckBox
Feature: Heroku Internet CheckBoxes Page Tests

  Background:
    Given the user is on the Internet "checkboxes" page

  
  Scenario Outline: User can toggle a checkbox value
    Then the number 1 checkbox should be "checked"
    Then the number 0 checkbox should be "unchecked"
    When the user clicks the number <num> checkbox
    Then the number <num> checkbox should be "<state1>"
    When the user clicks the number <num> checkbox
    Then the number <num> checkbox should be "<state2>"


    Examples:
      | num | state1    | state2    |
      | 0   | checked   | unchecked |
      | 1   | unchecked | checked   |


  
  Scenario: The checkbox page saves state between soft refreshes
    When the user clicks the number 1 checkbox
    Then the number 1 checkbox should be "unchecked"
    And the user refreshes the page softly
    Then the number 1 checkbox should be "unchecked"

  
  Scenario: The checkbox page does NOT save state between hard refreshes
    When the user clicks the number 1 checkbox
    Then the number 1 checkbox should be "unchecked"
    And the user refreshes the page hard
    Then the number 1 checkbox should be "checked"