package pageObjects.employee.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.BasePage;

public abstract class EmployeeForm extends BasePage {

    public EmployeeForm(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Page Elements
    @FindBy(css="input[ng-model='selectedEmployee.firstName']")
    private WebElement nameInputField;

    @FindBy(css="input[ng-model='selectedEmployee.lastName']")
    private WebElement lastNameInputField;

    @FindBy(css="input[ng-model='selectedEmployee.startDate']")
    private WebElement startDateInputField;

    @FindBy(css="input[ng-model='selectedEmployee.email']")
    private WebElement emailInputField;

    //Page Methods
    public abstract void cancelAction();

    public abstract boolean isFormVisible();

    public abstract void perform();

    public void writeToEmployeeNameInput(String name){
        getWait().until(ExpectedConditions.visibilityOf(nameInputField));
        nameInputField.sendKeys(name);
    }

    public void writeToEmployeeLastNameInput(String lastName){
        getWait().until(ExpectedConditions.visibilityOf(lastNameInputField));
        lastNameInputField.sendKeys(lastName);
    }

    public void writeToEmployeeStartDateInput(String date){
        getWait().until(ExpectedConditions.visibilityOf(startDateInputField));
        startDateInputField.sendKeys(date);
    }

    public void writeToEmployeeEmailInput(String email){
        getWait().until(ExpectedConditions.visibilityOf(emailInputField));
        emailInputField.sendKeys(email);
    }

    //Validation Methods
    public boolean isEmployeeNameInputVisible(){
        return super.isElementVisible(nameInputField);
    }

    public boolean isEmployeeLastNameInputVisible(){
        return super.isElementVisible(lastNameInputField);
    }

    public boolean isEmployeeStartDateInputVisible(){
        return super.isElementVisible(startDateInputField);
    }

    public boolean isEmployeeEmailInputVisible(){
        return super.isElementVisible(emailInputField);
    }
}