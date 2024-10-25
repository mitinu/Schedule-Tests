package Tests;

import common.Actions;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.JavascriptExecutor;

public class BaseTest {
    protected WebDriver driver = Actions.createDriver("chrome");

    public void clearLocalStorage(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.sessionStorage.clear();");
    }
    public void close(){
        driver.quit();
    }
}
