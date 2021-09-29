package PageObject.herokuapp;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DynamicControlsObject extends BasePage {

    private By removeBtn = By.xpath("//form[@id='checkbox-example']//button");
    private By textBack = By.xpath("//form[@id='checkbox-example']//p");
    private By title = By.tagName("h4");
    private By input = By.xpath("//form[@id='input-example']//input");
    private By enableBtn = By.xpath("//form[@id='input-example']//button");
    private By enableText = By.xpath("//form[@id='input-example']//p");



    public DynamicControlsObject(WebDriver driver) {
        super(driver);
    }

    public DynamicControlsObject clickRemoveBtn(){
        click(removeBtn);
        return this;
    }

    public DynamicControlsObject verifyPageTitle (){
        Assert.assertEquals(getElementText(title), HomePageLinksEnum.DYNAMIC_CONTROLS.getLinkText());
        return this;
    }

    public DynamicControlsObject verifyElements(String text){
        wait.until(ExpectedConditions.textToBe(textBack,text));
        return this;
    }

    public DynamicControlsObject verifyInput() {
        isDisplayed(input);
        wait.until(ExpectedConditions.attributeToBe(input, "disabled", "true"));
        return this;
    }
    public DynamicControlsObject verifyEnableBtn() {
        click(enableBtn);
        Assert.assertEquals(getElementText(enableText),"It's enabled!");
        isDisplayed(input);
        return this;
    }


}
