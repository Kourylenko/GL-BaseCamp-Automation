Feature: Create new Note
  Create New Note in ANotepad

  Scenario: I create new Note

    Given Notepad is opened in Chrome browser
    When I entered text in Note Title field
    And I clicked Save button
    #Then  Note Title field displayed text "New Note"
    #When I entered text "Hello!" in Note Content field
    #Then Note Content field displayed text "Hello!"

    #Then I saw massage "You have saved your note as a"
    #Then Saved Note displayed in "My Saved Notes" block

