Feature: Login page test

  Background:
    Given the user is at the login page

  Scenario: Authentication with the activation code
    When user clicks on I have a code
    Then user should be redirected to the page Activate your account

  Scenario: Login with a valid unregistered email
    When user fill the email field with a valid unregistered email
    And press the Continue button
    Then a sorry message should be exhibit

  Scenario: Login with a valid registered email
    When user fill the email field with a valid registered email
    And press the Continue button
    And user fill the password field with a valid password
    Then user should access the homepage