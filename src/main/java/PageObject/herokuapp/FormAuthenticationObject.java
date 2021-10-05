package PageObject.herokuapp;

import Builder.UserBuilder;
import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FormAuthenticationObject extends BasePage {
    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.cssSelector(".radius>i");
    private By afterLoginText = By.tagName("h4");


    public FormAuthenticationObject(WebDriver driver) {
        super(driver);
    }

    public FormAuthenticationObject loginApp(UserBuilder userBuilder) { //Builder
        enter(username, userBuilder.getUsername()); //Value object
        enter(password, userBuilder.getPassword());
        return this;
    }

    public FormAuthenticationObject clickLogin() {
        click(this.loginBtn);
        return this;
    }

    public FormAuthenticationObject verifyLogin() {
        Assert.assertEquals(getElementText(afterLoginText), "Welcome to the Secure Area. When you are done click logout below.");
        return this;
    }

}
