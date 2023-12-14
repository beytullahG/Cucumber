Feature: US1002 User should be able to search for a product using parameters

  Scenario: TC04 User should not find results when searching for 'java'

    Given the user goes to the Test Automation homepage
    Then types "java" in the search box and presses ENTER
    And tests that no product is found in the search results
    And waits for 3 seconds
    Then closes the page

  Scenario: TC05 User should not find results when searching for 'samsung'

    Given the user goes to the homepage by navigating to "taUrl"
    Then types "cucumber" in the search box and presses ENTER
    And tests that no product is found in the search results
    And waits for 2 seconds
    Then closes the page
