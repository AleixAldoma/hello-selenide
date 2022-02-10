Feature: Robobar cart
  Scenario: user add one cola
    Given user opens Robobar website
    When user adds a cola
    Then total should be €1.25

  Scenario: user add two colas
    Given user opens Robobar website
    When user adds a cola
    And user adds a cola
    Then total should be €2.50