package objects;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;


public class StepDefs {
    @Given("^Notepad is opened in Chrome browser$")
    public void notepadIsOpenInChromeBrowser() throws Throwable {
        open("https://anotepad.com/");
    }

    @When("^I entered text in Note Title field \"([^\"]*)\"$")
    public void iEnterTextInNoteTitleField(String arg0) throws Throwable {
        $x("//*[@id='edit_title']").sendKeys(arg0);
    }

    @And("^I entered text in Note Content field \"([^\"]*)\"$")
    public void iEnterTextInNoteContentField(String arg1) throws Throwable {
        $x("//*[@id='edit_textarea']").sendKeys(arg1);
    }

    @And("^I clicked Save button")
    public void iClickSaveButton() throws Throwable {
        $x("//*[@id='btnSaveNote']").click();
    }

    @And("^I saw message \"You have saved your note as a\"")
    public void iSawMessage() throws Throwable {
        $x("//p[@class='alert alert-warning']").shouldHave(Condition.text("You have saved your note as a"));
    }
}
































//    @When("^I click on first search results$")
//    public void iClickOnFirstSearchResults() throws Throwable {
//        $("h3").click();
//    }
//
//    @Then("^Opened page should contain info about \"([^\"]*)\"$")
//    public void openedPageShouldContainInfoAbout(String arg0) throws Throwable {
//        $("div.news div.news-line").shouldHave(Condition.text(arg0));
//    }
//
//    @When("I click on second search results")
//    public void iClickOnSecondSearchResults() {
//
//        $$("h3").get(1).click();
//
//    }
//
//    @And("Results number is {int}")
//    public void resultsNumberIs(int arg0) {
//        $$("h3").shouldHaveSize(arg0);
//    }
//}
