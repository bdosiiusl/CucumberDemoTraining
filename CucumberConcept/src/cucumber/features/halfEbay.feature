Feature: HalfEbay Registation page

  Scenario: HalfEbay Registration
    Given I am on halfEbay website
    When I complete registration
    Then I check that registration is successful
