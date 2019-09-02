Feature: Add employee functionality
  This feature deals with the testing of the add employee function

  Background: User is Logged In
    Given I navigate cafetownsend login page
    When I enter the 'Luke' in the userName field
    And I enter the 'Skywalker' in the password field
    And I click on the logIn button
    Then I should see 'Luke' in the greeting message

  Scenario Outline: Adding a new employee
    When I click on the Add employee button
    Then I should see the Add employee form
    When I entered <name> on the employee name input
    And I entered <lastName> on the employee last name input
    And I entered <startDate> on the employee stat date input
    And I entered <email> on the employee email input
    And I click on the add employee button from the form
    Then I should see the employee <lastName>, <name> in the employee list
    Examples:
      | name  | lastName | startDate  | email          |
      | Alf   | Abet     | 2019-08-30 | test2@test.com |
      | Dee   | Lishous  | 2019-08-30 | test4@test.com |