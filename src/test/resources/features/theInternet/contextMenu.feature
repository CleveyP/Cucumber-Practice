@Internet @ContextMenu
Feature: Heroku Internet Context Menu Page Tests

  Background:
    Given the user is on the Internet "context_menu" page


  Scenario: The dotted box displays an alert when right clicked
    When the "hot-spot" element is right clicked
    Then an alert is displayed on the page