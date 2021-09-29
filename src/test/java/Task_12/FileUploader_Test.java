package Task_12;

import PageObject.herokuapp.FileUploaderObject;
import PageObject.herokuapp.HomePageLinksEnum;
import PageObject.herokuapp.HomePageObject;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUploader_Test extends BaseTest {
    HomePageObject homePageObject;
    FileUploaderObject fileUploaderObject;

    @BeforeClass
    public void precondition (){
        homePageObject = new HomePageObject(driver);
        fileUploaderObject = new FileUploaderObject(driver);
        homePageObject.clickLink(HomePageLinksEnum.FILE_UPLOADER);
    }

    @Test
    public void fileUploader_Test() {
        fileUploaderObject.verifyPageTitle("File Uploader")
                .uploadFile()
                .verifyUploading("imagee.jpg")
                .verifyPageTitle("File Uploaded!");
    }
}
