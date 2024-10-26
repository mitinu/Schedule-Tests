package Tests;

import org.testng.annotations.Test;
import pages.HeadPage;

import static common.Config.urlHead;

public class UploadingDataTest extends BaseTest{

    protected HeadPage headPage = new HeadPage(this.driver);

    @Test
    public void uploadingDataTest() {
        headPage.open(urlHead);
        headPage.clikUploadingData().dismissAlert()
                .clikUploadingData().acceptAlert().checkLocalStorage();
    }


}
