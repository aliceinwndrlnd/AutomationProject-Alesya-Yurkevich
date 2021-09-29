package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import properties.PropertyReader;

import java.util.Properties;


public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected Properties properties;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        actions = new Actions(driver);
        properties = PropertyReader.getProperties();
    }

    protected void enter(By element, CharSequence... charSequences) {
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(charSequences);
    }

    protected void click(By element) {

        driver.findElement(element).click();
    }

    protected void open() {
        driver.get(properties.getProperty("url"));
    }

    protected void open(String url) {
        driver.get(url);
    }

    protected String getElementText(By element) {

        return driver.findElement(element).getText();
    }

    protected void isDisplayed(By... elements) {
        for (By element : elements) {
            System.out.println("Verify element :: " + element);
            Assert.assertFalse(driver.findElements(element).isEmpty(), "Element :: " + elements + " is not exist.");
        }
    }

    public void pause(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
