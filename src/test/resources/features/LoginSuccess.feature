Feature: Login
  As a valid customer of the Swag Labs sales platform
  I want to login successful
  Background:
    Given : I'm on the page that allows me to start the session

    #Test ID:001
    #Autor: Johan Sebastián Molina

  @login @system_blocked
  Scenario: Login failed, the system blocked my username
    When I enter my username and password blocked
    Then I should see an alert abducting that I cannot log in successfully

	#Test ID:002
    #Autor: Johan Sebastián Molina
  @login @invalid_credentials
  Scenario:Login with invalid credentials
    When I enter invalid username and password
    Then I should see an alert abducting that there is an error

	#Test ID:003
    #Autor: Johan Sebastián Molina
  @login @valid_credentials
  Scenario: Login Successfully with valid credentials
    When I enter my username and password correctly and validly
    Then should be on the products page and I can log out