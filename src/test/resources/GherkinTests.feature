Feature: Create and delete new Note
  Create and Delete New Note in ANotepad

  Scenario: I create new Note

    Given Notepad is opened in Chrome browser
    When I entered text in Note Title field "New Note"
    And I entered text in Note Content field "Hello"
    And I clicked Save button
    And I saw message "You have saved your note as a"


  Scenario: I delete Note
    Given  Notepad is opened in Chrome browser
    And I have previously created a note
    When I clicked Delete button
    Then I saw a question about accepting or dismissing my operation
    And I clicked Asept
    And I saw message "No notw here"


