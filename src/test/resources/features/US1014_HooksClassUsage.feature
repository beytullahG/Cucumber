Feature: US1014 Take a screenshot when the scenario fails

  @wip
  Scenario: TC20 user should be able to find Nutella on the test automation page

    Given the user goes to the homepage by navigating to "taUrl"
    Then types "nutella" in the search box and presses ENTER
    And tests that no product is found in the search results
    And closes the page
