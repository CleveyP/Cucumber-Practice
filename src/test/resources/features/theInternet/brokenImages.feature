@Internet @BrokenImages
Feature: Heroku Internet Broken Images Page Tests

  Background:
    Given the user is on the Internet "broken_images" page


  Scenario: The broken images should not load
    Then none of the broken images have loaded


  Scenario: The Fork Me image should load
    Then the Fork me image should appear on the page