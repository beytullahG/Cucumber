Feature: US1005 User cannot log in with incorrect credentials

  Scenario: TC09 User cannot log in with valid email and invalid password

    Given the user goes to the Test Automation homepage
    Then clicks on the account button
    And enters the email as "taValidEmail"
    And enters the password as "taInvalidPassword"
    Then clicks on the signIn button
    And tests that the user cannot log into the system
    And waits for 3 seconds
    And closes the page

  Scenario: TC10 User cannot log in with invalid email and valid password

    Given the user goes to the Test Automation homepage
    Then clicks on the account button
    And enters the email as "taInvalidEmail"
    And enters the password as "taValidPassword"
    Then clicks on the signIn button
    And tests that the user cannot log into the system
    And waits for 3 seconds
    And closes the page

  Scenario: TC11 User cannot log in with invalid email and invalid password

    Given the user goes to the Test Automation homepage
    Then clicks on the account button
    And enters the email as "taInvalidEmail"
    And enters the password as "taInvalidPassword"
    Then clicks on the signIn button
    And tests that the user cannot log into the system
    And waits for 3 seconds
    And closes the page
