@Internet @AddRemoveElement
Feature: Heroku Internet Add/Remove Element Page Tests

  Background:
    Given the user is on the Internet "add_remove_elements/" page

  Scenario Outline: User can create <n> many elements
    And the user clicks the "Add Element" button <n> times
    Then <n> Delete elements exist on the page


    Examples:
      | n |
      | 1 |
      | 5 |
      | 0 |


  Scenario Outline: User can delete <n> many elements
    And the user clicks the "Add Element" button 10 times
    And the user clicks the "Delete" button <n> times
    Then <expected> Delete elements exist on the page


    Examples:
      | n | expected |
      | 1 | 9        |
      | 5 | 5        |
      | 0 | 10       |

