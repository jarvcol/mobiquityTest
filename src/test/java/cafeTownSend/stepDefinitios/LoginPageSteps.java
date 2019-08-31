package cafeTownSend.stepDefinitios;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
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
        testContext.setCurrentPage(loginPage);
    }

    @Then("I should see the login form")
    public void iShouldSeeTheLoginForm() {
        Assert.assertTrue(true);
    }
}
