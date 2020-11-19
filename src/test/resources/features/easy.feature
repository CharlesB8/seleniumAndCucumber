Feature: Testing Basic Form Page

  Scenario: Single input field
    Given I am on the page
    And I enter a message
    When I click the button
    Then I should have the message return to me