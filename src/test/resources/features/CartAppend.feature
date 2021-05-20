Feature: Add products to cart

  As a client of the Swag Labs platform
  I want to add products to my shopping cart
  To be able to buy them and have them sent to my house

  Background:
    Given I am a user with a correct Login and I am on the products page

    #Test ID:004
    #Autor: Johan Sebastián Molina
  @systemCart
  Scenario: The shopping cart counter must be modified when I add an item
    When I add two items that I want to buy
    Then the shopping cart counter is two


    #Test ID:005
    #Autor: Johan Sebastián Molina
  @systemCart
  Scenario: I add items to the shopping cart and remove some
    When I add six items to the shopping cart and remove one
    Then The shopping cart counter should be five and only five items should appear inside it

    #Test ID:006
    #Autor: Johan Sebastián Molina
  @systemCart
  Scenario: The selected product is inside the shopping cart
    When I add the item to the shopping cart
    Then I can see the same product that I select in the shopping cart