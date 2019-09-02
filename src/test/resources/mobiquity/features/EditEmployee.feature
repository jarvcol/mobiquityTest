Feature: Edit employee functionality
  This feature deals with the testing of the edit and delete employee functions

  Background: User is Logged In
    Given I navigate cafetownsend login page
    When I enter the 'Luke' in the userName field
    And I enter the 'Skywalker' in the password field
    And I click on the logIn button
    Then I should see 'Luke' in the greeting message

  Scenario Outline: Editing an employee from the list
    When I click on the '1' employee on the list
    And I click on the Edit employee button
    Then I should see the Edit employee form
    When I entered <name> on the employee name input
    And I entered <lastName> on the employee last name input
    And I entered <startDate> on the employee stat date input
    And I entered <email> on the employee email input
    And I click on the edit employee button from the form
    And I click on the '1' employee on the list
    Then I should see the <startDate> new date on the employee information
    And I should see the <email> new email on the employee information
    And I should see the <name> new name on the employee information
    And I should see the <lastName> new last name on the employee information
    Examples:
      | name  | lastName | startDate  | email          |
      | Harry | Plotter  | 2019-08-02 | test1@test.com |
      | Avery | Niceman  | 2017-04-12 | test3@test.com |

  Scenario: Editing an employee by button
    When I click on the '1' employee on the list
    And I click on the Edit employee button
    Then I should see the Edit employee form

  Scenario: Editing an employee by double click
    When I double click on the '1' employee on the list
    Then I should see the Edit employee form

  Scenario: Deleting an employee to see the warning message
    When I click on the '3' employee on the list
    Then I click on Delete button
    Then I should see a warning message

  Scenario Outline: Deleting an employee from the list
    When I click the employee <lastName>, <name> in the employee list
    And I click on Delete button
    And I accept the warning message
    When I click on the logOut button
    And I enter the 'Luke' in the userName field
    And I enter the 'Skywalker' in the password field
    And I click on the logIn button
    And I should not see the employee <lastName>, <name> in the employee list
    Examples:
      | name  | lastName |
      | Alf   | Abet     |
      | Dee   | Lishous  |