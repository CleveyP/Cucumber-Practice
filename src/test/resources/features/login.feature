@Auth
Feature: Login Page End to End Tests

  Background:
    Given the user is on the login page

  Scenario Outline: A user can login with a correct username: "<username>" and password "<password>"
    When the user enters "<username>" and "<password>"
    And clicks the login button
    Then a success message, "Logged In Successfully!" is shown on the page


    Examples:
      | username  | password |
      | Cleveland | 1234     |
      | Caimin    | 123      |

  Scenario Outline: A user can not login with incorrect username: "<username>" and/or incorrect password "<password>"
    When the user enters "<username>" and "<password>"
    And clicks the login button
    Then a rejection message "<message>" is shown on the page


    Examples:
      | username  | password | message        |
      | Cleveland | 123      | Wrong Password |
      | Caimi     | 123      | Wrong Username |
      | a         | 1234     | Wrong Username |

