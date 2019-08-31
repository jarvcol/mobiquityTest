package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.UrlSetUp;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public LoginPage(WebDriver driver, int timeOutInSec){
        super(driver, timeOutInSec);
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
        userInputField.sendKeys(userName);
    }

    public void writeToPasswordInputField(String password){
        passwordInputField.sendKeys(password);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }
}
