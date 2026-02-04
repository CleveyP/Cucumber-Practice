@Internet @ChallengingDOM
Feature: Heroku Internet Challenging DOM Page Tests

  Background:
    Given the user is on the Internet "challenging_dom" page
    
#  1. Buttons ----------------------------------------------------------------------------------    

  @Buttons
  Scenario: The Challenging DOM page should display exactly 3 buttons
    Then there should be 3 button link elements on the page

  @Buttons
  Scenario: The alert button should have alert styling
    Then the alert button should have alert styling


#  2. Table Structure -----------------------------------------------------------------------------

  @TableStructure
  Scenario Outline: The table should have the correct header: <header>
    Then the "<header>" header should exist in the table

    Examples:
      | header  |
      | Lorem   |
      | Ipsum   |
      | Dolor   |
      | Sit     |
      | Amet    |
      | Diceret |
      | Action  |


  @TableStructure
  Scenario: The table should contain exactly 11 rows
    Then there should be 11 elements of type "tr" on the page


  @TableStructure
  Scenario: Every table row should contain both an edit and a delete link
    Then each table row should contain an edit and a delete link


#  3. Canvas Element -----------------------------------------------------------------------------


  @Canvas
  Scenario: The canvas element exists on the page
    Then the single canvas element is shown on the page
    And the "canvas" has height: 200
    And the "canvas" has width: 599


#  5. Locator Strategy -----------------------------------------------------------------------------

  @TableCell
  Scenario Outline: Table cell at row <row> and column <col> has correct text value: "<text>"
    Then the cell <row>, <col> has text "<text>"

    Examples:
      | row | col | text        |
      | 1   | 2   | Adipisci0   |
      | 1   | 0   | Iuvaret0    |
      | 4   | 3   | Definiebas3 |
      | 2   | 5   | Phaedrum1   |
