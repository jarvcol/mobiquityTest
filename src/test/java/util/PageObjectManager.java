package util;

import org.openqa.selenium.WebDriver;
import pageObjects.EmployeeListView;
import pageObjects.UserMainPage;
import pageObjects.LoginPage;
import pageObjects.employee.forms.AddEmployeeForm;
import pageObjects.employee.forms.EditEmployeeForm;
import pageObjects.employee.forms.EmployeeForm;

public class PageObjectManager {

    private WebDriver driver;

    private LoginPage loginPage;
    private UserMainPage userMainPage;
    private EmployeeListView listViewPage;
    private EmployeeForm editEmployeeForm;
    private EmployeeForm addEmployeeForm;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }

    public UserMainPage getUserMainPage() {
        return (userMainPage == null) ? userMainPage = new UserMainPage(driver, this) : userMainPage;
    }

    public EmployeeListView getListViewPage() {
        return (listViewPage == null) ? listViewPage = new EmployeeListView(driver) : listViewPage;
    }

    public EmployeeForm getAddEmployeeForm() {
        return (addEmployeeForm == null) ? addEmployeeForm = new AddEmployeeForm(driver) : addEmployeeForm;
    }

    public EmployeeForm getEditEmployeeForm() {
        return (editEmployeeForm == null) ? editEmployeeForm = new EditEmployeeForm(driver) : editEmployeeForm;
    }
}