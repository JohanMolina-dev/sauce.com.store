Feature: buy my desired item
  As a client of the Swag Labs platform
  I want to buy some products
  Background:
    Given : I'm on the products page and I have my products added to the shopping cart
    #Test ID:007
    #Autor: Johan Sebastián Molina
    Scenario: Buy without having the zip code
      When check out my products, I enter my first and last name without the zip code
      Then I should see error message
    #Test ID:008
    #Autor: Johan Sebastián Molina
    Scenario: Buy with a non-existent or wrong zip code
      When check out my products, I enter my first and last name and I entered a wrong zip code, nonexistent
      Then I should see error message zip code
    #Test ID:009
    #Autor: Johan Sebastián Molina
    Scenario: Buy with correct zip code
    When check out my products, I enter my first and last name and I entered a correct zip code
    Then I should see the total of my purchase plus taxes and should be able to finish the purchase