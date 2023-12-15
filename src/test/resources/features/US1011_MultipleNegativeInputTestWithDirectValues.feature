Feature: US1011 Negative login test with incorrect information in the scenario


  Scenario Outline: TC17 User should not be able to log in with the provided incorrect credentials in the list

    Given the user goes to the homepage by navigating to "taUrl"
    Then clicks on the account button
    When enters "<givenEmail>" as the email from the list
    And enters "<givenPassword>" as the password from the list
    Then clicks on the signIn button
    And tests that the user cannot log into the system
    And waits for 1 seconds
    Then closes the page

    Examples:
      | givenEmail          | givenPassword |
      | beytullah@bmail.com | 1234555       |
      | gamze@gmail.com     | example123    |
      | zehra@zmail.com     | asdf4321      |
      | ayca@amail.com      | 6543241tre65  |
      | gulnur@gmail.com    | 123ert678     |
