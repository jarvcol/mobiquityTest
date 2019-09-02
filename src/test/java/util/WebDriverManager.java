package util;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import enums.DriverType;

public class WebDriverManager {
    private WebDriver driver;
    private static DriverType driverType;

    public WebDriverManager() {
        driverType = driverType.valueOf(FileReaderManager.getInstance().getConfigReader().getBrowser().toLowerCase().trim());
    }

    public WebDriver getDriver() {
        if(driver == null) driver = setUpDriver();
        return driver;
    }

    private WebDriver setUpDriver() {
        switch (driverType) {
            case firefox : driver = new FirefoxDriver();
                break;
            case chrome :
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--incognito");
                chromeOptions.addArguments("--disable-cache");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--disable-popup-blocking");
                driver = new ChromeDriver(chromeOptions);
                break;
            case ie : driver = new InternetExplorerDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }

}