Feature: US1009 User performs multiple searches

@wip
  Scenario Outline: TC15 User should be able to search for elements in a list

    Given the user goes to the homepage by navigating to "taUrl"
    Then types "<searchKeywords>" in the search box and presses ENTER
    And tests that a product can be found in the search results
    Then waits for 1 seconds
    And closes the page

    Examples:
      | searchKeywords |
      | phone          |
      | java           |
      | samsung        |
      | apple          |
      | nutella        |

# If we want to search for more than one item, not just one, we use Scenario Outline instead of Scenario
