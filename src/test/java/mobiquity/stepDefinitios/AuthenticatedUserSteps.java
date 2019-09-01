package mobiquity.stepDefinitios;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.UserMainPage;
import util.TestContext;

public class AuthenticatedUserSteps {

    TestContext testContext;
    UserMainPage userMainPage;

    public AuthenticatedUserSteps(TestContext testContext) {
        this.testContext = testContext;
        userMainPage = testContext.getPageObjectManager().getUserMainPage();
    }

    @Then("I should see \'([^\\\"]*)\' in the greeting message")
    public void iShouldTheLukeInTheGreetingMessage(String userName) {
        Assert.assertTrue("Greeting message does not contain the expected name", userMainPage.greetingMessageContains(userName));
    }

    @When("I click on the logOut button")
    public void iClickOnTheLogOutButton() {
        userMainPage.clickOnLogOutButton();
    }
}
