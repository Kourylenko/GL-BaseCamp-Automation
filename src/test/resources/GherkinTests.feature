Feature: Create new Note
  Create and Delete New Note in ANotepad

  Scenario: I create new Note

    Given Notepad is opened in Chrome browser
    When I entered text in Note Title field "New Note"
    And I entered text in Note Content field "Hello"
    And I clicked Save button
    And I saw message "You have saved your note as a"


