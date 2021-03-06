package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.employee.forms.EmployeeForm;
import util.PageObjectManager;

public class UserMainPage extends BasePage {

    public UserMainPage(WebDriver driver, PageObjectManager pageObjectManager){
        super(driver, pageObjectManager);
        this.employeeListView = getPageObjectManager().getListViewPage();
        PageFactory.initElements(driver, this);
    }

    //Page Elements
    @FindBy(xpath=".//header//p[@class='main-button']")
    private WebElement logOutButton;

    @FindBy(css="#bAdd")
    private WebElement createEmployeeButton;

    @FindBy(css="#bEdit")
    private WebElement updateEmployeeButton;

    @FindBy(css="#bDelete")
    private WebElement deleteEmployeeButton;

    @FindBy(css="#greetings")
    private WebElement greetingMessage;

    private EmployeeForm employeeForm;
    private EmployeeListView employeeListView;

    //Page Methods
    public void clickOnLogOutButton(){
        getWait().until(ExpectedConditions.visibilityOf(logOutButton));
        Actions actions = new Actions(getDriver());
        actions.click(logOutButton).build().perform();
    }

    public void clickOnAddButton(){
        getWait().until(ExpectedConditions.visibilityOf(createEmployeeButton));
        createEmployeeButton.click();
        employeeForm = getPageObjectManager().getAddEmployeeForm();
    }

    public void clickOnEditButton(){
        getWait().until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(updateEmployeeButton),
                ExpectedConditions.elementToBeClickable(updateEmployeeButton)));
        updateEmployeeButton.click();
        employeeForm = getPageObjectManager().getEditEmployeeForm();
    }

    public void clicOnDeleteButton(){
        getWait().until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(deleteEmployeeButton),
                ExpectedConditions.elementToBeClickable(deleteEmployeeButton)));
        deleteEmployeeButton.click();
    }

    public void employeeFormPerformAction(){
        employeeForm.perform();
    }

    public void closeAlert(){
        super.closeAlert();
    }

    public void acceptAlert(){
        super.acceptAlert();
        //employeeListView.updateEmployeeList(); this method was intented to remove all duplicated and non existing employees
    }

    public void doubleClickOnEmployeeByIndex(int index){
        employeeListView.doubleClickOnEmployeeByIndex(index);
        employeeForm = getPageObjectManager().getEditEmployeeForm();
    }

    //Validation Methods
    public boolean greetingMessageContains(String userName){
        getWait().until(ExpectedConditions.visibilityOf(greetingMessage));
        return greetingMessage.getText().contains(userName);
    }

    public boolean isWarningMessageDisplayed(){
        getWait().until(ExpectedConditions.alertIsPresent());
        return getDriver().switchTo().alert().getText().contains("Are you sure you want to delete");
    }

    public EmployeeForm getEmployeeForm(){
        return employeeForm;
    }

    public EmployeeListView getEmployeeListView(){
        return employeeListView;
    }
}
