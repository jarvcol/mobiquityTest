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

    public void writeToEmployeeNameInputField(String name){
        employeeForm.writeToEmployeeNameInput(name);
    }

    public void writeToEmployeeLastNameInputField(String lastName){
        employeeForm.writeToEmployeeLastNameInput(lastName);
    }

    public void writeToEmployeeStartDateInputField(String date){
        employeeForm.writeToEmployeeStartDateInput(date);
    }

    public void writeToEmployeeEmailInputField(String email){
        employeeForm.writeToEmployeeEmailInput(email);
    }

    public void employeeFormPerformAction(){
        employeeForm.perform();
    }

    public boolean isEmployeeNameOnTheList(String fullName){
        return employeeListView.isEmployeeNameOnList(fullName);
    }

    //Validation Methods
    public boolean greetingMessageContains(String userName){
        getWait().until(ExpectedConditions.visibilityOf(greetingMessage));
        return greetingMessage.getText().contains(userName);
    }

    public boolean isEmployeeListVisible(){
        return employeeListView.areEmployeeInListVisible();
    }

    public boolean isEmployeeFormVisible(){
        return employeeForm.isFormVisible();
    }

    public void clickOnEmployeeByIndex(int index){
        employeeListView.clickOnEmployeeByIndex(index);
    }

    public boolean isWarningMessageDisplayed(){
        getWait().until(ExpectedConditions.alertIsPresent());
        return getDriver().switchTo().alert().getText().contains("Are you sure you want to delete");
    }
}
