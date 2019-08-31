package cafeTownSend.stepDefinitios;

import pageObjects.UserMainPage;
import util.TestContext;

public class AuthenticatedUserSteps {

    TestContext testContext;
    UserMainPage userMainPage;

    public AuthenticatedUserSteps(TestContext testContext) {
        this.testContext = testContext;
        userMainPage = testContext.getPageObjectManager().getUserMainPage();
    }


}
