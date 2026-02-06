@Internet @DragAndDrop
Feature: heroku Internet Drag and Drop Page Tests

  Background:
    Given the user is on the Internet "drag_and_drop" page

  Scenario: The user can drag the A card onto the B card
    When the user drags the "A" card onto the "B" card
    Then the "B" card displays "A"

  Scenario: The user can drag the B card onto the A card
    When the user drags the "B" card onto the "A" card
    Then the "A" card displays "B"

  Scenario Outline: The cards do not change if the user drops a card outside a card holder
    When the user drags the "<card>" onto empty space
    Then the "A" card displays "A"
    Then the "B" card displays "B"


    Examples:
      | card |
      | A    |
      | B    |