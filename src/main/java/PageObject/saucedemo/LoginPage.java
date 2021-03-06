package PageObject.saucedemo;

import Builder.UserBuilder;
import PageObject.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;


public class LoginPage extends BasePage {

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorTxt = By.tagName("h3");


    public LoginPage openPage() {
        open();
        return this;
    }

    public LoginPage enterUsername(String username) {
        enter(this.username, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        enter(this.password, password);
        return this;
    }

    public LoginPage loginApp(UserBuilder userBuilder) {
        enterUsername(userBuilder.getUsername());
        enterPassword(userBuilder.getPassword());
        clickLogin();
        return this;
    }

    public LoginPage clickLogin() {
        click(this.loginButton);
        return this;
    }

    public LoginPage checkErrorText(String expectedText) {
        Assert.assertEquals(getElementText(errorTxt), expectedText);
        return this;
    }
}
