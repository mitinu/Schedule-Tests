package pages;

import common.CONST.LOCALSTOTAGE;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.Alert;

import static common.CONST.CONST.ITEM_WAITING_TIME;


public class HeadPage extends BasePage{

    public HeadPage(WebDriver driver) {
        super(driver);
    }
    private final By byUploadingData = By.xpath("//input[contains(@value, 'обновлениен')]");


    public HeadPage clikUploadingData(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ITEM_WAITING_TIME));

        WebElement uploadButton = wait.until(ExpectedConditions.elementToBeClickable(byUploadingData));
        uploadButton.click();
        return this;
    }
    public HeadPage dismissAlert(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }

    public HeadPage acceptAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }
    protected void checkDontNullLocalStorage(String key){
        String script = "return window.localStorage.getItem(arguments[0]);";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ITEM_WAITING_TIME));
        wait.until(driver -> {
            String value = (String) ((JavascriptExecutor) driver).executeScript(script, key);
            return value != null;
        });
    }
    public HeadPage checkLocalStorage(){
        checkDontNullLocalStorage(LOCALSTOTAGE.BASICDATA);
        checkDontNullLocalStorage(LOCALSTOTAGE.SAVECONFIG);

//        String value = (String) ((JavascriptExecutor) driver).executeScript(script, key);
//        JSONObject jsonObject = new JSONObject(value);
//        System.out.println("Значение для ключа '" + key + "': " + jsonObject);
        return this;
    }
}
