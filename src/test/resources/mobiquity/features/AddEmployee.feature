Feature: Add employee functionality
  This feature deals with the testing of the add employee function

  Background: User is Logged In
    Given I navigate cafetownsend login page
    When I enter the 'Luke' in the userName field
    And I enter the 'Skywalker' in the password field
    And I click on the logIn button
    Then I should see 'Luke' in the greeting message

  Scenario: Adding a new employee
    Given I click on the Add employee button
    Then I should see the Add employee form