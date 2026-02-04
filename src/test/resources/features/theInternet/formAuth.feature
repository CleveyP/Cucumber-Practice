@Internet @FormAuth
Feature: Heroku Internet Form Auth Feature Tests

  Background:
    Given the user is on the Internet "login" page



  Scenario: User can log in successfully and then logout successfully
    And the user enters their username "tomsmith" and password "SuperSecretPassword!"
    And the user clicks the login button
    Then the user is navigated to the "https://the-internet.herokuapp.com/secure"
    And the user clicks the "Logout" button
    Then the user is navigated to the "https://the-internet.herokuapp.com/login"


  Scenario Outline: User cannot log in with invalid credentials -- username: "<bad user>" and password: "<bad password>"
    And the user enters their username "<bad user>" and password "<bad password>"
    And the user clicks the login button
    Then the user is navigated to the "https://the-internet.herokuapp.com/login"
    And a banner shows the reject text: "<reject>"

    Examples:
      | bad user  | bad password          | reject                    |
      | wrong     | 1234                  | Your username is invalid! |
      |           |                       | Your username is invalid! |
      | tomsmith  |                       | Your password is invalid! |
      | tom smith | SuperSecretPassword!  | Your username is invalid! |
      | tom       | SuperSecretPassword!  | Your username is invalid! |
      | tomsmith  | Super SecretPassword! | Your password is invalid! |
