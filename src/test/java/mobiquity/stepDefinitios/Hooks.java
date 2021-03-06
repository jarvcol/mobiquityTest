package mobiquity.stepDefinitios;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import util.TestContext;

public class Hooks{

    TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void InitializeTest(Scenario scenario) throws Exception {
        testContext.getWebDriverManager().getDriver();
    }

    @After
    public void TearDownTest(Scenario scenario) {
        if(testContext.getPageObjectManager().getUserMainPage().isAlertPresent())
            testContext.getPageObjectManager().getUserMainPage().closeAlert();
        testContext.getWebDriverManager().closeDriver();
    }

}