Feature: US1007 Test for the product added to the shopping cart by the user

  @wip
  Scenario: TC13 The correct product should be added to the cart

    Given the user goes to the homepage by navigating to "sauceUrl"
    And waits for 2 seconds
    Then types "standard_user" into the saucedemo username box
    And types "secret_sauce" into the saucedemo password box
    And waits for 2 seconds
    Then clicks on the saucedemo login button
    And records the name of the first product and goes to its page
    When clicks on the saucedemo add to Cart button
    Then clicks on the saucedemo shopping cart
    And waits for 2 seconds
    And tests that the selected product has been successfully added to the cart
    And waits for 2 seconds
    And closes the page
