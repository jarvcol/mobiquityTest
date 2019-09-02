package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Optional;

public class EmployeeListView extends BasePage {

    public EmployeeListView(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Page Elements
    @FindBy(css="#employee-list li")
    private List<WebElement> employeeList;

    //Page Methods
    public void clickOnEmployeeByIndex(int index){
        getWait().until(ExpectedConditions.visibilityOfAllElements(employeeList));
        employeeList.get(index-1).click();
    }

    public void doubleClickOnEmployeeByIndex(int index){
        getWait().until(ExpectedConditions.visibilityOfAllElements(employeeList));
        Actions actions = new Actions(getDriver());
        actions.doubleClick(employeeList.get(index-1)).build().perform();
    }

    public void clickOnEmployeeByName(String fullName){
        getWait().until(ExpectedConditions.visibilityOfAllElements(employeeList));
        filterListByName(fullName).click();
    }

    public void doubleClickOnEmployeeByName(String fullName){
        getWait().until(ExpectedConditions.visibilityOfAllElements(employeeList));
        Actions actions = new Actions(getDriver());
        actions.doubleClick(filterListByName(fullName)).build().perform();
    }

    private WebElement filterListByName(String fullName){
        Optional<WebElement> employee = employeeList.stream().filter(x -> x.getText().equals(fullName)).findFirst();
        return employee.get();
    }

    //Validation Methods
    public boolean areEmployeeInListVisible(){
        getWait().until(ExpectedConditions.visibilityOfAllElements(employeeList));
       return employeeList.stream().allMatch(x -> x.isDisplayed());
    }

    public boolean isEmployeeNameOnList(String fullName){
        getWait().until(ExpectedConditions.visibilityOfAllElements(employeeList));
        return filterListByName(fullName) != null;
    }
}
