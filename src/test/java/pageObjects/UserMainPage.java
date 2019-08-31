package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.UrlSetUp;

public class UserMainPage extends BasePage {

    public UserMainPage(WebDriver driver){
        super(driver);
    }

    //Page Elements
    @FindBy(css="...")
    private WebElement logOutButton;

    @FindBy(css="...")
    private WebElement createEmployeeButton;

    @FindBy(xpath="...")
    private WebElement updateEmployeeButton;

    @FindBy(xpath="...")
    private WebElement deleteEmployeeButton;

    @FindBy(xpath="...")
    private WebElement greetingMessage;

    //Page Methods
    public void clickOnLogOutButton(){
        getWait().until(ExpectedConditions.visibilityOf(logOutButton));
        logOutButton.click();
    }

    //Validation Methods
    public boolean greetingMessageContains(String userName){
        getWait().until(ExpectedConditions.visibilityOf(logOutButton));
        return greetingMessage.getText().contains(userName);
    }
}
