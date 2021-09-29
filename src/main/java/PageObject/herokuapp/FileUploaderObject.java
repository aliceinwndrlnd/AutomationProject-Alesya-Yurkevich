package PageObject.herokuapp;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUploaderObject extends BasePage {
    private By uploadBtn = By.id("file-submit");
    private By chooseFileBtn = By.id("file-upload");
    private By title = By.tagName("h3");
    private By uploadFiles = By.id("uploaded-files");
    private String userDir = System.getProperty("user.dir");
    private By dragAndDropUpload = By.id("drag-drop-upload");
    private By uploadFileName = By.xpath("//*[@id='drag-drop-upload']//*[@class='dz-filename']//span");


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

    public FileUploaderObject dragAndDropUpload(String imgName) {
        click(dragAndDropUpload);
        pause();
        StringSelection stringSelection = new StringSelection(userDir+ "\\files\\" + imgName);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null); //мы описали объект с помощью StringSelection выше
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL); //описываем, какие зажимаем кнопки
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL); //описываем, какие отпускаем кнопки
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            e.printStackTrace();  // робот всегда описывается try and catch (e.printStackTrace - распечатывает,что словил)
        }
        pause();
        Assert.assertEquals(getElementText(uploadFileName), imgName);
        return this;
    }
}
