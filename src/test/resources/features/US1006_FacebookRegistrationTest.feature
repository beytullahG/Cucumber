Feature: US1006 Facebook Registration Test with Faker Class

  Scenario: TC12 Registration on Facebook with Fake Information

    Given the user goes to the homepage by navigating to "faceUrl"
    And clicks on the create new account button on Facebook
    And waits for 1 seconds
    When fills out the Facebook registration form with information from the Faker class
    Then waits for 2 seconds
    And clicks on the Facebook sign-up button
    Then waits for 2 seconds
    And closes the page
