package mobiquity.stepDefinitios;

import cucumber.api.java.en.And;
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

    @And("I should see the employee list")
    public void iShouldSeeTheEmployeeList() {
        Assert.assertTrue("Employee list is not visible", userMainPage.getEmployeeListView().areEmployeeInListVisible());
    }

    @When("I click on the Add employee button")
    public void iClickOnTheAddEmployeeButton() {
        userMainPage.clickOnAddButton();
    }

    @Then("I should see the Add employee form")
    public void iShouldSeeTheAddEmployeeForm() {
        Assert.assertTrue("Add employee form is not visible", userMainPage.getEmployeeForm().isFormVisible());
    }

    @When("I click on the Edit employee button")
    public void iClickOnTheEditEmployeeButton() {
        userMainPage.clickOnEditButton();
    }

    @Then("I should see the Edit employee form")
    public void iShouldSeeTheEditEmployeeForm() {
        Assert.assertTrue("Edit employee form is not visible", userMainPage.getEmployeeForm().isFormVisible());

    }

    @When("I click on the \'([^\\\"]*)\' employee on the list")
    public void iClickOnTheEmployeeOnTheList(String index) {
        userMainPage.getEmployeeListView().clickOnEmployeeByIndex(Integer.parseInt(index));
    }

    @Then("I click on Delete button")
    public void iClickOnDeleteButton() {
        userMainPage.clicOnDeleteButton();
    }

    @Then("I should see a warning message")
    public void iShouldSeeAWarningMessage() {
        userMainPage.isWarningMessageDisplayed();
    }

    @When("I entered (.*) on the employee name input")
    public void iEnteredNameOnTheEmployeeNameInput(String name) {
        userMainPage.getEmployeeForm().writeToEmployeeNameInput(name);
    }

    @And("^I entered (.*) on the employee last name input")
    public void iEnteredLastNameOnTheEmployeeLastNameInput(String lastName) {
        userMainPage.getEmployeeForm().writeToEmployeeLastNameInput(lastName);
    }

    @And("I entered (.*) on the employee stat date input")
    public void iEnteredStartDateOnTheEmployeeStatDateInput(String startDate) {
        userMainPage.getEmployeeForm().writeToEmployeeStartDateInput(startDate);
    }

    @And("I entered (.*) on the employee email input")
    public void iEnteredEmailOnTheEmployeeEmailInput(String email) {
        userMainPage.getEmployeeForm().writeToEmployeeEmailInput(email);
    }

    @And("I click on the add employee button from the form")
    public void iClickOnTheAddEmployeeButtonFromTheForm() {
        userMainPage.employeeFormPerformAction();
    }

    @And("I click on the edit employee button from the form")
    public void iClickOnTheEditEmployeeButtonFromTheForm() {
        userMainPage.employeeFormPerformAction();
    }

    @Then("I should see the employee (.*), (.*) in the employee list")
    public void iShouldSeeTheEmployeeLastNameNameInTheEmployeeList(String lastName, String name) {
        Assert.assertTrue("Employee "+name+" "+lastName+" is not on the list",
                userMainPage.getEmployeeListView().isEmployeeNameOnList(name+" "+lastName));
    }

    @When("I click the employee (.*), (.*) in the employee list")
    public void iClickTheEmployeeLastNameNameInTheEmployeeList(String lastName, String name) {
        userMainPage.getEmployeeListView().clickOnEmployeeByName(name+" "+lastName);
    }

    @And("I accept the warning message")
    public void iAcceptTheWarningMessage() {
        userMainPage.acceptAlert();
    }

    @Then("I should not see the employee (.*), (.*) in the employee list")
    public void iShouldNotSeeTheEmployeeLastNameNameInTheEmployeeList(String lastName, String name) {
        Assert.assertFalse("Employee "+name+" "+lastName+" is on the list",
                userMainPage.getEmployeeListView().isEmployeeNameOnList(name+" "+lastName));
    }

    @When("I double click on the \'([^\\\"]*)\' employee on the list")
    public void iDoubleClickOnTheEmployeeOnTheList(String index) {
        userMainPage.doubleClickOnEmployeeByIndex(Integer.parseInt(index));
    }

    @Then("I should see the (.*) new date on the employee information")
    public void iShouldSeeTheStartDateNewDateOnTheEmployeeInformation(String date) {
        Assert.assertTrue("Employee start date value is not the expected",
                userMainPage.getEmployeeForm().employeeStartDateInputValueIs(date));
    }

    @And("I should see the (.*) new email on the employee information")
    public void iShouldSeeTheEmailNewEmailOnTheEmployeeInformation(String email) {
        Assert.assertTrue("Employee email value is not the expected",
                userMainPage.getEmployeeForm().employeeEmailInputValueIs(email));
    }

    @And("I should see the (.*) new last name on the employee information")
    public void iShouldSeeTheLastNameNewLastNameOnTheEmployeeInformation(String lastName) {
        Assert.assertTrue("Employee email value is not the expected",
                userMainPage.getEmployeeForm().employeeLastNameInputValueIs(lastName));
    }

    @And("I should see the (.*) new name on the employee information")
    public void iShouldSeeTheNameNewNameOnTheEmployeeInformation(String name) {
        Assert.assertTrue("Employee email value is not the expected",
                userMainPage.getEmployeeForm().employeeNameInputValueIs(name));
    }
}
