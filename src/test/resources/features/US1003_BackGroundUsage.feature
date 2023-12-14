Feature: US1003 User should be able to write common steps at the beginning once

  Background: Common steps at the beginning can be written here
    Given the user goes to the homepage by navigating to "taUrl"

  Scenario: TC06 User should not find results when searching for 'java'

    Then types "java" in the search box and presses ENTER
    And tests that no product is found in the search results
    And waits for 3 seconds
    Then closes the page

  Scenario: TC07 User should not find results when searching for 'samsung'

    Then types "cucumber" in the search box and presses ENTER
    And tests that no product is found in the search results
    And waits for 2 seconds
    Then closes the page
