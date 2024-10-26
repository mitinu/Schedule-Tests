package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import java.util.concurrent.TimeUnit;

import static common.CONST.CONST.BRAOWSER_WAITING_TIME;
import static common.Config.SRC_CHROM_GRIVER;
public class Actions {
    public static WebDriver createDriver(String browser) {
        WebDriver driver = null;
        switch (browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", SRC_CHROM_GRIVER);
                driver = new ChromeDriver();
                break;
            default:
                Assert.fail("Неподдерживаемая браузер: " + browser);
                break;
        }
        driver.manage().timeouts().implicitlyWait(BRAOWSER_WAITING_TIME, TimeUnit.SECONDS);
        return driver;
    }
}
