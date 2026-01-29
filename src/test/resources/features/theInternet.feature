@Internet
Feature: TheInternet Page End to End Tests

  Background:
    Given the user is on The Internet home page


   #---------------------- Form Authentication Page Tests -------------------------------------
  @FormAuth
  Scenario: User can click on the Form Validation link
    When the user clicks the "Form Authentication" link
    Then the user is navigated to the "https://the-internet.herokuapp.com/login"

  @FormAuth
  Scenario: User can log in successfully and then logout successfully
    When the user clicks the "Form Authentication" link
    And the user enters their username "tomsmith" and password "SuperSecretPassword!"
    And the user clicks the login button
    Then the user is navigated to the "https://the-internet.herokuapp.com/secure"
    And the user clicks the "Logout" button
    Then the user is navigated to the "https://the-internet.herokuapp.com/login"

  @FormAuth
  Scenario Outline: User cannot log in with invalid credentials -- username: "<bad user>" and password: "<bad password>"
    When the user clicks the "Form Authentication" link
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


    #---------------------- Add/Remove Elements Page Tests -------------------------------------

  @AddRemoveElement
  Scenario Outline: User can create <n> many elements
    When the user clicks the "Add/Remove Elements" link
    Then the user is navigated to the "https://the-internet.herokuapp.com/add_remove_elements/"
    And the user clicks the "Add Element" button <n> times
    Then <n> Delete elements exist on the page


    Examples:
      | n |
      | 1 |
      | 5 |
      | 0 |

  @AddRemoveElement
  Scenario Outline: User can delete <n> many elements
    When the user clicks the "Add/Remove Elements" link
    And the user clicks the "Add Element" button 10 times
    And the user clicks the "Delete" button <n> times
    Then <expected> Delete elements exist on the page


    Examples:
      | n | expected |
      | 1 | 9        |
      | 5 | 5        |
      | 0 | 10       |



     #---------------------- Broken Images Page Tests -------------------------------------
  @BrokenImages
  Scenario: The broken images should not load
    When the user clicks the "Broken Images" link
    Then none of the broken images have loaded

  @BrokenImages
  Scenario: The Fork Me image should load
    When the user clicks the "Broken Images" link
    Then the Fork me image should appear on the page

 #---------------------- Challenging DOM Page Tests -------------------------------------


#  1. Buttons
#
#  Verify the page contains exactly 3 buttons.
#
#  Verify that there are 2 buttons with the text “foo.”
#
#  Verify that the button with the text “qux” has the alert styling.
#
#  2. Table Structure
#
#  Verify the table has the correct headers: Lorem, Ipsum, Dolor, Sit, Amet, Diceret, Action.
#
#  Verify the table contains exactly 10 rows.
#
#  Verify that every row contains both an “edit” and a “delete” link.
#
#  3. Table Row Actions
#
#  Click the “delete” link for a specific row identified by its first column (e.g., “Iuvaret7”) and verify the correct row is targeted.
#
#  Click the “edit” link for a specific row identified by its first column and verify the action is triggered for the correct row.
#
#  4. Parameterized / Scenario Outline Style
#
#  Test deleting multiple rows by parameterizing the first column value (e.g., “Iuvaret0”, “Iuvaret5”, “Iuvaret9”).
#
#  Test editing multiple rows similarly, using the first column as a parameter.
#
#  5. Canvas Element
#
#  Verify the canvas element exists on the page.
#
#  Verify the canvas has the expected width and height.
#
#  6. Locator Strategy Practice (Optional)
#
#  Avoid using the random UUID IDs; verify you can locate elements using:
#
#  text content
#
#  class names
#
#  relative positioning in tables
#
#  hierarchy (like parent → child relationships)