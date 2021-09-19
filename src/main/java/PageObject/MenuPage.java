package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage extends BasePage {

    private By menuBtn = By.id("react-burger-menu-btn");
    private By allItems = By.id("inventory_sidebar_link");
    private By about = By.id("about_sidebar_link");
    private By logout = By.id("logout_sidebar_link");
    private By resetApp = By.id("reset_sidebar_link");

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public MenuPage clickMenu() {
        click(menuBtn);
        return this;
    }

    public MenuPage display() {
        isDisplayed(allItems, about, logout, resetApp);
        return this;
    }
    public MenuPage sleep () {
        pause();
        return this;
    }
}
