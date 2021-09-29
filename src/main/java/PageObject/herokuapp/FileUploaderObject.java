package PageObject.herokuapp;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FileUploaderObject extends BasePage {
    private By uploadBtn = By.id("file-submit");
    private By chooseFileBtn = By.id("file-upload");
    private By title = By.tagName("h3");
    private By uploadFiles = By.id("uploaded-files");
    private String userDir = System.getProperty("user.dir");


    public FileUploaderObject(WebDriver driver) {
        super(driver);
    }

    public FileUploaderObject verifyPageTitle(String title){
        Assert.assertEquals(getElementText(this.title), title);
        return this;
    }

    public FileUploaderObject uploadFile(){
        driver.findElement(chooseFileBtn).sendKeys(userDir + properties.getProperty("filePath"));
        click(uploadBtn);
        return this;
    }
    public FileUploaderObject verifyUploading(String name){
        Assert.assertEquals(getElementText(uploadFiles), name);
        return this;
    }
}
