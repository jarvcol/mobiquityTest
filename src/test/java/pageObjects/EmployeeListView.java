package pageObjects;

import org.openqa.selenium.*;
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
    private final String employeeListLocator = "#employee-list li";
    @FindBy(css=employeeListLocator)
    private List<WebElement> employeeList;

    //Page Methods
    public void clickOnEmployeeByIndex(int index){
        getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(employeeList)));
        employeeList.get(index-1).click();
    }

    public void doubleClickOnEmployeeByIndex(int index){
        getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(employeeList)));
        Actions actions = new Actions(getDriver());
        actions.doubleClick(employeeList.get(index-1)).build().perform();
    }

    public void clickOnEmployeeByName(String fullName){
        getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(employeeList)));
        filterListByName(fullName).click();
    }

    public void doubleClickOnEmployeeByName(String fullName){
        getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(employeeList)));
        Actions actions = new Actions(getDriver());
        actions.doubleClick(filterListByName(fullName)).build().perform();
    }

    private WebElement filterListByName(String fullName){
        Optional<WebElement> employee = employeeList.stream().filter(x -> x.getText().equals(fullName)).findFirst();
        if(employee.isPresent())
            return employee.get();
        else
            return null;
    }

    //Validation Methods
    public boolean areEmployeeInListVisible(){
        getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(employeeList)));
       return employeeList.stream().allMatch(x -> x.isDisplayed());
    }

    public boolean isEmployeeNameOnList(String fullName){
        getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(employeeList)));
        return filterListByName(fullName) != null;
    }

    public void updateEmployeeList(){
        getWait().until(ExpectedConditions.visibilityOf(employeeList.get(0)));
        Actions actions = new Actions(getDriver());
        for (WebElement employee:employeeList) {
            try {
                getWait().until(ExpectedConditions.or(
                        ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(employee)),
                        ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(employee))));
                actions.moveToElement(employee).pause(500).build().perform();
            }
            catch (NoSuchElementException | StaleElementReferenceException ignored) {
            }
        }
        // Original line removed due to StaleElementReferenceException
        // employeeList.stream().forEach(x -> actions.moveToElement(x).pause(1000).build().perform());
        employeeList = null;
        employeeList = getDriver().findElements(By.cssSelector(employeeListLocator));
    }
}
