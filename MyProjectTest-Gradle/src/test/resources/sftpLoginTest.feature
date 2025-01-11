Feature: SFTP Login
  Scenario: User should be able to login with valid credentials
    Given the user open sftp
    When the user enters valid credentials
    And hits connect
    Then the user logged in to sftp
