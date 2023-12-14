Feature: US1008 User tests the buttons on the page
@wip
  Scenario: TC14 User tests that add and delete buttons are functional

    Given the user goes to the homepage by navigating to "heroUrl"
    When the user clicks on the Add Element button
    And waits for 2 seconds
    And tests that the Delete button is visible
    Then the user clicks the Delete button
    And tests that the Add Remove Elements text is visible
    And waits for 2 seconds
    And closes the page
