@FunctionalTest
Feature: Using Tags in Cucumber

  @SmokeTest
  Scenario: Scenario1
    Given This is Scenario1

  @SmokeTest
  Scenario: Scenario2
    Given This is Scenario2

    @SanityTest
    @SmokeTest
  Scenario: Scenario3
    Given This is Scenario3

  Scenario: Scenario4
    Given This is Scenario4
