package pages;

import common.CONST.LOCALSTOTAGE;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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
    private final By bySaveDataTable = By.id("save_data");
    private final By bySaveCongig = By.id("save_config");


    public HeadPage clikinputSwitcPffical(int indexOffical, int indexDay, int indexParoue){
        By byInputSwitcPffical = By.xpath(String.format("//div[contains(@class, 'carts_office_sort')][%d]//div[contains(@class, 'day_office%d')]//div[contains(@class, 'profesor_stule')][%d]//input",
                indexOffical+1, indexDay+1, indexParoue+1));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ITEM_WAITING_TIME));
        WebElement elementInputSwitcPffical = wait.until(ExpectedConditions.elementToBeClickable(byInputSwitcPffical));
        elementInputSwitcPffical.click();
        return this;
    }

    public HeadPage clikSaveCongig(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ITEM_WAITING_TIME));
        WebElement elementSaveCongig = wait.until(ExpectedConditions.elementToBeClickable(bySaveCongig));
        elementSaveCongig.click();

        return this;
    }

    public HeadPage chekSaveConfig(int indexOffical, int indexDay, int indexParoue){
        String script = "return window.localStorage.getItem(arguments[0]);";
        String key = LOCALSTOTAGE.SAVECONFIG;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ITEM_WAITING_TIME));
        wait.until(driver -> {
            String value = (String) ((JavascriptExecutor) driver).executeScript(script, key);
            return value != null;
        });

        String value = (String) ((JavascriptExecutor) driver).executeScript(script, key);

        checkBoolean(new JSONObject(value).getJSONArray("finallArrOffice").getJSONObject(indexOffical).getJSONArray("days_parrys").getJSONArray(indexDay).getBoolean(indexParoue));
        return this;
    }
    public static void checkBoolean(boolean value) {
        if (value) {
            throw new IllegalArgumentException("Значение должно быть false, получено true.");
        }
    }
    public HeadPage clikSaveDataTable(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ITEM_WAITING_TIME));
        WebElement elementSaveDataTable = wait.until(ExpectedConditions.elementToBeClickable(bySaveDataTable));
        elementSaveDataTable.click();
        checkDontNullLocalStorage(LOCALSTOTAGE.SAVEDATATABLE);
        return this;
    }


    public HeadPage clikUploadingData(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ITEM_WAITING_TIME));
        WebElement elementUploadingData = wait.until(ExpectedConditions.elementToBeClickable(byUploadingData));
        elementUploadingData.click();
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
