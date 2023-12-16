Feature:US1013 A List Can Be Created According to Minimum Stock Values in Stock Excel

  @P1
  Scenario: TC19 it is possible to create a list of products with given min. stock values in the given stock excel

    Given the user goes to the homepage by navigating to "taUrl"
    Then lists all the products in the stock excel that have increased, and have stock equal to or greater than the min stock quantity
    And closes the page
