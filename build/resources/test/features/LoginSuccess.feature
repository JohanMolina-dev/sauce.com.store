Feature: Login Success
  As a valid customer of the Swag Labs sales platform
  I want to login successful
  Scenario: Login Successfully with valid credentials
    Given I'm on the page that allows me to start the session
    When I enter my username and password correctly and validly
    Then should be on the products page and I can log out