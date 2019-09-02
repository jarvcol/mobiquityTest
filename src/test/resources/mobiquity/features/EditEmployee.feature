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
    When I entered <startDate> on the employee stat date input
    And I entered <email> on the employee email input
    And I click on the edit employee button from the form
    And I double click on the '1' employee on the list
    Then I should see the <startDate> new date on the employee information
    And I should see the <email> new email on the employee information
    Examples:
      | startDate  | email          |
      | 2019-08-02 | test1@test.com |
      | 2017-04-12 | test3@test.com |

