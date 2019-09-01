package pageObjects.employee.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddEmployeeForm extends EmployeeForm {
    public AddEmployeeForm(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Page Elements
    @FindBy(css="a[class='subButton bCancel']")
    private WebElement cancelButton;

    @FindBy(xpath=".//button[@class='main-button' and text()='Add']")
    private WebElement addButton;

    //Page Methods
    @Override
    public void cancelAction() {
        getWait().until(ExpectedConditions.visibilityOf(cancelButton));
        cancelButton.click();
    }

    @Override
    public void perform() {
        getWait().until(ExpectedConditions.visibilityOf(addButton));
        addButton.click();
    }
}
