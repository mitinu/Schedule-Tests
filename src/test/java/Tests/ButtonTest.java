package Tests;

import org.testng.annotations.Test;
import pages.HeadPage;

import static common.Config.urlHead;

public class ButtonTest extends BaseTest{

    protected HeadPage headPage = new HeadPage(this.driver);

    @Test
    public void uploadingDataTest() {
        headPage.open(urlHead);
        headPage.clikUploadingData().dismissAlert()
                .clikUploadingData().acceptAlert().checkLocalStorage();
    }
    @Test
    public void saveDataTableTest() {
        headPage.open(urlHead);
        headPage.clikSaveDataTable();
    }
    @Test
    public void clikSaveConfigTest() {
        headPage.open(urlHead);

        int indexOfficalAddProfessor = 0;
        int indexDay = 0;
        int indexParoue = 0;
        headPage.clikUploadingData().acceptAlert()

                .clikinputSwitcOffical(indexOfficalAddProfessor, indexDay, indexParoue)
                .clikinputSwitcProfessor(indexOfficalAddProfessor, indexDay, indexParoue)

                .clikSaveCongig()

                .chekSaveConfigOffice(indexOfficalAddProfessor, indexDay, indexParoue)
                .chekSaveConfigProfessor(indexOfficalAddProfessor, indexDay, indexParoue);
    }


}
