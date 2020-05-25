Feature: AS a user
  I want to use all the question forms and filter options
  So that I am able to start a New Custom session and complete it.

  Scenario: Create a custom session with default options
    Given user is on custom session page
    When user starts the new custom session
    Then user should see exam started
    And user should see default number of questions as "0/40"

  Scenario: Analysis page is displayed once a new custom session is started and ended with questions and filters
    Given user is on custom session page
    When user sets questions and filters
    And user starts the new custom session
    Then user should see exam started with end block
    And Analysis page should be displayed once session is completed
#
  Scenario: Reset custom exam session
    Given user is on custom session page
    When user sets questions and filters
    And user reset the session options
    Then user should see the custom options reset to default values



