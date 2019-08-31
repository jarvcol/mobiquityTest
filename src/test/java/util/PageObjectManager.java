package util;

import org.openqa.selenium.WebDriver;
import pageObjects.UserMainPage;
import pageObjects.LoginPage;

public class PageObjectManager {

    private WebDriver driver;

    private LoginPage loginPage;
    private UserMainPage userMainPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }

    public UserMainPage getUserMainPage() {
        return (userMainPage == null) ? userMainPage = new UserMainPage(driver) : userMainPage;
    }

}