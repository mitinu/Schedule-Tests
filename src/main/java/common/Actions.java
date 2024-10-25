package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



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
        //TODO возможно нужно дабавить ожидание но вятли
        return driver;
    }
}
