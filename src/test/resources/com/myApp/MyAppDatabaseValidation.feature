Feature: My App Database Validation

  Scenario: Validating UI data with DB Data
    Given User go to MyApp homepage
    When  User gets data from UI
    Then  User validates UI data with DB
