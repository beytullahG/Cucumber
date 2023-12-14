Feature: US1001 User searches on the Test Automation page

  Scenario: TC01 User should find results for the phone search

    Given the user goes to the Test Automation homepage
    Then types "phone" in the search box and presses ENTER
    And tests that a product can be found in the search results
    And waits for a moment
    Then closes the page

  @Regression @Smoke @E2E3
  Scenario: TC02 User should find results for the shoes search

    Given the user goes to the Test Automation homepage
    Then types "shoes" in the search box and presses ENTER
    And tests that a product can be found in the search results
    And waits for a moment
    Then closes the page

  @Regression @E2E1
  Scenario: TC03 User should not find results when searching for nutella

    Given the user goes to the Test Automation homepage
    Then types "nutella" in the search box and presses ENTER
    And tests that no product is found in the search results
    And waits for a moment
    Then closes the page
