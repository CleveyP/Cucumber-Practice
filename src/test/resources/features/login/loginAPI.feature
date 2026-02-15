@Auth @API
Feature: Login Page API Tests


  Scenario Outline: validate request
    Given the body
      | username | <user> |
      | password | <pass> |

    When I make the request
    Then the response status is <res status>
    Then the response body is "<res body>"


    Examples:
      | user      | pass | res body       | res status |
      | Cleveland | 1234 | OK             | 200        |
      | Caimi     | 123  | Wrong Username | 401        |
      | a         | 1234 | Wrong Username | 401        |

