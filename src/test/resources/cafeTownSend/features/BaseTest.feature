Feature: Login and logout functionality
  This feature deals with the testing of the login and logout functions

  Scenario: Accessing the cafetownsend login page
    Given I navigate cafetownsend login page
    Then I should see the login form

  Scenario: Login into the cafe cafetownsend
    Given I navigate cafetownsend login page
    When I enter the 'Luke' in the userName field
    And I enter the 'Skywalker' in the password field
    And I click on the logIn button
    Then I should the 'Luke' in the greeting message

  Scenario: Log out from the cafe cafetownsend
    Given I navigate cafetownsend login page
    When I enter the 'Luke' in the userName field
    And I enter the 'Skywalker' in the password field
    And I click on the logIn button
    Then I should the 'Luke' in the greeting message
    When I click on the logOut button
    Then I should see the login form
