package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.FileReaderManager;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver){
        wait = new WebDriverWait(driver, FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());
        this.driver = driver;
    }

    public BasePage(WebDriver driver, int timeOutInSec){
        wait = new WebDriverWait(driver, timeOutInSec);
        this.driver = driver;
    }

    protected WebDriverWait getWait(){
        return wait;
    }

    protected WebDriver getDriver(){
        return driver;
    }

    protected void NavigateTo(String url){
        driver.get(url);
    }

    protected boolean isElementPresent(By by){
        try{
            driver.findElement(by);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    protected boolean isElementVisible(WebElement element){
        return element.isDisplayed();
    }
}
