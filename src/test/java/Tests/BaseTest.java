package Tests;

import common.Actions;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class BaseTest {
    protected WebDriver driver = Actions.createDriver("chrome");

    @AfterTest
    public void clearLocalStorage(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.sessionStorage.clear();");
    }
    @AfterSuite
    public void close(){
        driver.quit();
    }
}
