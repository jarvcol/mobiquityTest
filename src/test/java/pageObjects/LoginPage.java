package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.UrlSetUp;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    //Page Elements
    @FindBy(css="...")
    private WebElement userInputField;

    @FindBy(css="...")
    private WebElement passwordInputField;

    @FindBy(xpath="...")
    private WebElement loginButton;

    //Page Methods
    public void goToLoginPage(){
        super.NavigateTo(UrlSetUp.getUrl()+"/login");
    }

    public void writeToUserInputField(String userName){
        getWait().until(ExpectedConditions.visibilityOf(userInputField));
        userInputField.sendKeys(userName);
    }

    public void writeToPasswordInputField(String password){
        getWait().until(ExpectedConditions.visibilityOf(passwordInputField));
        passwordInputField.sendKeys(password);
    }

    public void clickOnLoginButton(){
        getWait().until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
    }

    //Validation Methods
    public boolean isUserNameInputVisible(){
        getWait().until(ExpectedConditions.visibilityOf(loginButton));
        return super.isElementVisible(userInputField);
    }

    public boolean isPasswordInputVisible(){
        getWait().until(ExpectedConditions.visibilityOf(loginButton));
        return super.isElementVisible(userInputField);
    }

    public boolean isLoginButtonVisible(){
        getWait().until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(userInputField),
                ExpectedConditions.visibilityOf(passwordInputField)));
        return super.isElementVisible(loginButton);
    }
}
