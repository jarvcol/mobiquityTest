Feature: Edit employee functionality
  This feature deals with the testing of the edit and delete employee functions

  Background: User is Logged In
    Given I navigate cafetownsend login page
    When I enter the 'Luke' in the userName field
    And I enter the 'Skywalker' in the password field
    And I click on the logIn button
    Then I should see 'Luke' in the greeting message

  Scenario: Editing an employee
    When I click on the '1' employee on the list
    And I click on the Edit employee button
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
      | Harry | Plotter  |
      | Alf   | Abet     |
      | Avery | Niceman  |
      | Dee   | Lishous  |