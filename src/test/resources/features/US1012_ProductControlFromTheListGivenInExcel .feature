Feature: US1012 Test of products and minimum stock quantities given as an Excel

  @P1
  Scenario Outline: TC18 Products in the given Excel list should have minimum stock

    Given the user goes to the homepage by navigating to "taUrl"
    Then finds the stock quantity of the product in the "<desiredRow>" row in the Excel
    And tests that the stock quantity in the "<desiredRow>" row is greater than the given stock quantity
    And closes the page

    Examples:
      | desiredRow |
      | 2          |
      | 3          |
      | 4          |
      | 5          |
      | 6          |
      | 7          |
      | 8          |
      | 9          |
