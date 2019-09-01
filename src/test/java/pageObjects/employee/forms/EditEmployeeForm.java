package pageObjects.employee.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditEmployeeForm extends EmployeeForm{
    public EditEmployeeForm(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Page Elements
    @FindBy(css="a[class='subButton bBack']")
    private WebElement cancelButton;

    @FindBy(xpath=".//button[@class='main-button' and text()='Update']")
    private WebElement editButton;

    @FindBy(xpath=".//p[@class='main-button' and text()='Delete']")
    private WebElement deleteButton;

    //Page Methods
    @Override
    public void cancelAction() {
        getWait().until(ExpectedConditions.visibilityOf(cancelButton));
        cancelButton.click();
    }

    @Override
    public void perform() {
        getWait().until(ExpectedConditions.visibilityOf(editButton));
        editButton.click();
    }

    public void deleteEmployee(){
        getWait().until(ExpectedConditions.visibilityOf(deleteButton));
        deleteButton.click();
    }

    //Validation Methods
    public boolean isEditEmployeeButtonVisible(){
        return super.isElementVisible(editButton);
    }

    public boolean isDeleteEmployeeButtonVisible(){
        return super.isElementVisible(deleteButton);
    }

    public boolean isCancelButtonVisible(){
        return super.isElementVisible(cancelButton);
    }

    @Override
    public boolean isFormVisible(){
        return super.isEmployeeEmailInputVisible() &&
                super.isEmployeeLastNameInputVisible() &&
                super.isEmployeeStartDateInputVisible() &&
                super.isEmployeeNameInputVisible() &&
                isEditEmployeeButtonVisible() && isDeleteEmployeeButtonVisible() && isCancelButtonVisible();
    }
}
