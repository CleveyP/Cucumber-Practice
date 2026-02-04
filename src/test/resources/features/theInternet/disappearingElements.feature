@Internet @DisappearingElements
Feature: The Internet Disappearing Elements Page Tests

  Background:
    Given the user is on the Internet "disappearing_elements" page
  
  Scenario: The page opens and Menu exists
    Then the menu exists
    And the "a" element with text "Home" exists
    And the "a" element with text "About" exists
    And the "a" element with text "Contact Us" exists
    And the "a" element with text "Portfolio" exists

  @Flakey
  Scenario: The Gallery link sometimes exists
    Then the gallery sometimes appears on the page

  @Navigation
  Scenario Outline: The "<button>" button redirect to correct page
    When the user clicks the "<button>" button
    Then the user is navigated to the "<url>"



    Examples:
      | button     | url                                            |
      | Home       | https://the-internet.herokuapp.com/            |
      | About      | https://the-internet.herokuapp.com/about/      |
      | Contact Us | https://the-internet.herokuapp.com/contact-us/ |
      | Portfolio  | https://the-internet.herokuapp.com/portfolio/  |