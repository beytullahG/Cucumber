Feature: US1010 User cannot log in with incorrect information
@P2
  Scenario Outline: TC16 User should not be able to log in with the provided incorrect credentials

    Given the user goes to the homepage by navigating to "taUrl"
    Then clicks on the account button
    When enters the email as "<givenEmail>"
    And enters the email as "<givenPassword>"
    Then clicks on the signIn button
    And tests that the user cannot log into the system
    And waits for 1 seconds
    Then closes the page

    Examples:
      | givenEmail      | givenPassword      |
      | taValidEmail    | taInvalidPassword  |
      | taInvalidEmail  | taValidPassword    |
      | taInvalidEmail  | taInvalidPassword  |
      | taInvalidEmail2 | taInvalidPassword2 |
      | taInvalidEmail3 | taInvalidPassword3 |
