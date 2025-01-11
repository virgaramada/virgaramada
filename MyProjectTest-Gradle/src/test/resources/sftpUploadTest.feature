Feature: SFTP Upload
  Scenario: User should be able to upload files
    Given the user connected to sftp
    When the user select root folder
    And the user select file to upload
    And the user hits upload
    Then the user should see uploaded files
    And the user should see archived files
    And in same folder
    And per each date