package mobiquity.stepDefinitios;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.LoginPage;
import util.TestContext;

public class LoginPageSteps{

    TestContext testContext;
    LoginPage loginPage;

    public LoginPageSteps(TestContext testContext) {
        this.testContext = testContext;
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }

    @Given("I navigate cafetownsend login page")
    public void navigateToCafetownsendLoginPage() {
        loginPage.goToLoginPage();
    }

    @Then("I should see the login form")
    public void iShouldSeeTheLoginForm() {
        Assert.assertTrue("User name input is not visible on login page", loginPage.isUserNameInputVisible());
        Assert.assertTrue("Password input is not visible on login page", loginPage.isPasswordInputVisible());
        Assert.assertTrue("Login button is not visible on login page", loginPage.isLoginButtonVisible());
    }

    @When("I enter the \'([^\\\"]*)\' in the userName field")
    public void iEnterTheLukeInTheUserNameField(String userName) {
        loginPage.writeToUserInputField(userName);
    }

    @And("I enter the \'([^\\\"]*)\' in the password field")
    public void iEnterTheSkywalkerInThePasswordField(String password) {
        loginPage.writeToPasswordInputField(password);
    }

    @And("I click on the logIn button")
    public void iClickOnTheLogInButton() {
        loginPage.clickOnLoginButton();
    }

    @Then("I should be in the login page")
    public void iShouldBeInTheLoginPage() {
        Assert.assertTrue("User is not on login page as expected", loginPage.isLoginCurrentPage());
    }
}
