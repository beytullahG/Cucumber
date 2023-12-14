Feature: US1004 User logs into the system with valid credentials

  Scenario: TC08 User should be able to log into the system with valid credentials

    Given the user goes to the homepage by navigating to "toUrl"
    Then clicks on the account button
    And enters the email as "toValidEmail"
    And enters the password as "toValidPassword"
    Then clicks on the signIn button
    And tests that successful login is possible
    And waits for 3 seconds
    And closes the page
