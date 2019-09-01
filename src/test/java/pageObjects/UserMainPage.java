package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.UrlSetUp;

public class UserMainPage extends BasePage {

    public UserMainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Page Elements
    @FindBy(xpath=".//header//p[@class='main-button']")
    private WebElement logOutButton;

    @FindBy(css="#bAdd")
    private WebElement createEmployeeButton;

    @FindBy(css="bEdit")
    private WebElement updateEmployeeButton;

    @FindBy(css="bDelete")
    private WebElement deleteEmployeeButton;

    @FindBy(css="#greetings")
    private WebElement greetingMessage;

    //Page Methods
    public void clickOnLogOutButton(){
        getWait().until(ExpectedConditions.visibilityOf(logOutButton));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(logOutButton).click().perform();
    }

    //Validation Methods
    public boolean greetingMessageContains(String userName){
        getWait().until(ExpectedConditions.visibilityOf(greetingMessage));
        return greetingMessage.getText().contains(userName);
    }
}
