package org.example.steps.Internet;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.example.pages.Internet.InternetDragAndDropPage;
import org.example.steps.GenericSteps;
import org.testng.Assert;


@RequiredArgsConstructor
public class InternetDragAndDropSteps {
    private final InternetDragAndDropPage page;
    private final GenericSteps genericSteps;



    @When("the user drags the {string} card onto the {string} card")
    public void dragCardOntoTheCard(String fromCard, String toCard) {
        page.dragCardToOtherCard(fromCard, toCard);
    }


    @Then("the {string} card displays {string}")
    public void cardDisplays(String fromCard, String expected) {
        String fromCardContent = page.getCardContent(fromCard);

        Assert.assertEquals(fromCardContent, expected);
    }

    @When("the user drags the {string} onto empty space")
    public void dragEmptySpace(String fromCard) {
        page.dragCardToEmptySpace(fromCard);
    }




}
