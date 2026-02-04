@Internet
Feature: TheInternet Page End to End Tests

#  Background:
#    Given the user is on The Internet home page


   #---------------------- Form Authentication Page Tests -------------------------------------
#  @FormAuth
#  Scenario: User can click on the Form Validation link
#    When the user clicks the "Form Authentication" link
#    Then the user is navigated to the "https://the-internet.herokuapp.com/login"
#
#  @FormAuth
#  Scenario: User can log in successfully and then logout successfully
#    When the user clicks the "Form Authentication" link
#    And the user enters their username "tomsmith" and password "SuperSecretPassword!"
#    And the user clicks the login button
#    Then the user is navigated to the "https://the-internet.herokuapp.com/secure"
#    And the user clicks the "Logout" button
#    Then the user is navigated to the "https://the-internet.herokuapp.com/login"
#
#  @FormAuth
#  Scenario Outline: User cannot log in with invalid credentials -- username: "<bad user>" and password: "<bad password>"
#    When the user clicks the "Form Authentication" link
#    And the user enters their username "<bad user>" and password "<bad password>"
#    And the user clicks the login button
#    Then the user is navigated to the "https://the-internet.herokuapp.com/login"
#    And a banner shows the reject text: "<reject>"
#
#    Examples:
#      | bad user  | bad password          | reject                    |
#      | wrong     | 1234                  | Your username is invalid! |
#      |           |                       | Your username is invalid! |
#      | tomsmith  |                       | Your password is invalid! |
#      | tom smith | SuperSecretPassword!  | Your username is invalid! |
#      | tom       | SuperSecretPassword!  | Your username is invalid! |
#      | tomsmith  | Super SecretPassword! | Your password is invalid! |


    #---------------------- Add/Remove Elements Page Tests -------------------------------------


#  Scenario Outline: User can create <n> many elements
#    When the user clicks the "Add/Remove Elements" link
#    Then the user is navigated to the "https://the-internet.herokuapp.com/add_remove_elements/"
#    And the user clicks the "Add Element" button <n> times
#    Then <n> Delete elements exist on the page
#
#
#    Examples:
#      | n |
#      | 1 |
#      | 5 |
#      | 0 |
#
#
#  Scenario Outline: User can delete <n> many elements
#    When the user clicks the "Add/Remove Elements" link
#    And the user clicks the "Add Element" button 10 times
#    And the user clicks the "Delete" button <n> times
#    Then <expected> Delete elements exist on the page
#
#
#    Examples:
#      | n | expected |
#      | 1 | 9        |
#      | 5 | 5        |
#      | 0 | 10       |



     #---------------------- Broken Images Page Tests -------------------------------------
#  @BrokenImages
#  Scenario: The broken images should not load
#    When the user clicks the "Broken Images" link
#    Then none of the broken images have loaded
#
#  @BrokenImages
#  Scenario: The Fork Me image should load
#    When the user clicks the "Broken Images" link
#    Then the Fork me image should appear on the page

 #---------------------- Challenging DOM Page Tests -------------------------------------


##  1. Buttons
#
#  @ChallengingDOM @Buttons
#  Scenario: The Challenging DOM page should display exactly 3 buttons
#    When the user clicks the "Challenging DOM" link
#    Then there should be 3 button link elements on the page
#
#  @ChallengingDOM @Buttons
#  Scenario: The alert button should have alert styling
#    When the user clicks the "Challenging DOM" link
#    Then the alert button should have alert styling
#
#
##  2. Table Structure
#
#  @ChallengingDOM @TableStructure
#  Scenario Outline: The table should have the correct header: <header>
#    When the user clicks the "Challenging DOM" link
#    Then the "<header>" header should exist in the table
#
#    Examples:
#      | header  |
#      | Lorem   |
#      | Ipsum   |
#      | Dolor   |
#      | Sit     |
#      | Amet    |
#      | Diceret |
#      | Action  |
#
#
#  @ChallengingDOM @TableStructure
#  Scenario: The table should contain exactly 11 rows
#    When the user clicks the "Challenging DOM" link
#    Then there should be 11 elements of type "tr" on the page
#
#
#  @ChallengingDOM @TableStructure
#  Scenario: Every table row should contain both an edit and a delete link
#    When the user clicks the "Challenging DOM" link
#    Then each table row should contain an edit and a delete link
#
#
##  3. Canvas Element
#
##  Verify the canvas element exists on the page.
#  @ChallengingDOM @Canvas
#  Scenario: The canvas element exists on the page
#    When the user clicks the "Challenging DOM" link
#    Then the single canvas element is shown on the page
#    And the "canvas" has height: 200
#    And the "canvas" has width: 599
#
#
##  5. Locator Strategy Practice
##
##  text content
#  @ChallengingDOM @TableCell
#  Scenario Outline: Table cell at row <row> and column <col> has correct text value: "<text>"
#    When the user clicks the "Challenging DOM" link
#    Then the cell <row>, <col> has text "<text>"
#
#    Examples:
#      | row | col | text        |
#      | 1   | 2   | Adipisci0   |
#      | 1   | 0   | Iuvaret0    |
#      | 4   | 3   | Definiebas3 |
#      | 2   | 5   | Phaedrum1   |



     #---------------------- CheckBoxes Page Tests -------------------------------------
#  @CheckBox
#  Scenario Outline: User can toggle a checkbox value
#    When the user clicks the "Checkboxes" link
#    Then the number 1 checkbox should be "checked"
#    Then the number 0 checkbox should be "unchecked"
#    When the user clicks the number <num> checkbox
#    Then the number <num> checkbox should be "<state1>"
#    When the user clicks the number <num> checkbox
#    Then the number <num> checkbox should be "<state2>"
#
#
#    Examples:
#      | num | state1    | state2    |
#      | 0   | checked   | unchecked |
#      | 1   | unchecked | checked   |
#
#
#  @CheckBox
#  Scenario: The checkbox page saves state between soft refreshes
#    When the user clicks the "Checkboxes" link
#    When the user clicks the number 1 checkbox
#    Then the number 1 checkbox should be "unchecked"
#    And the user refreshes the page softly
#    Then the number 1 checkbox should be "unchecked"
#
#  @CheckBox
#  Scenario: The checkbox page does NOT save state between hard refreshes
#    When the user clicks the "Checkboxes" link
#    When the user clicks the number 1 checkbox
#    Then the number 1 checkbox should be "unchecked"
#    And the user refreshes the page hard
#    Then the number 1 checkbox should be "unchecked"


     #---------------------- Context Menu Tests -------------------------------------

#  @ContextMenu
#  Scenario: The dotted box displays an alert when right clicked
#    When the user clicks the "Context Menu" link
#    When the "hot-spot" element is right clicked
#    Then an alert is displayed on the page

     #---------------------- Disappearing Elements Tests -------------------------------------

#  @DisappearingElements
#  Scenario: The page opens and Menu exists
#    When the user clicks the "Disappearing Elements" link
#    Then the menu exists
#    And the "a" element with text "Home" exists
#    And the "a" element with text "About" exists
#    And the "a" element with text "Contact Us" exists
#    And the "a" element with text "Portfolio" exists
#
#  @DisappearingElements @Flakey
#  Scenario: The Gallery link sometimes exists
#    When the user clicks the "Disappearing Elements" link
#    Then the gallery sometimes appears on the page
#
#  @DisappearingElements @Navigation
#  Scenario Outline: The "<button>" button redirect to correct page
#    When the user clicks the "Disappearing Elements" link
#    When the user clicks the "<button>" button
#    Then the user is navigated to the "<url>"
#
#
#
#    Examples:
#      | button     | url                                            |
#      | Home       | https://the-internet.herokuapp.com/            |
#      | About      | https://the-internet.herokuapp.com/about/      |
#      | Contact Us | https://the-internet.herokuapp.com/contact-us/ |
#      | Portfolio  | https://the-internet.herokuapp.com/portfolio/  |


