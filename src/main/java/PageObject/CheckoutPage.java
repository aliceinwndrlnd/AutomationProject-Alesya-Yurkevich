package PageObject;

import org.openqa.selenium.By;

public class CheckoutPage extends BasePage {

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By zip = By.id("postal-code");
    private By continueBtn = By.id("continue");
    private By finishBtn = By.id("finish");

    public CheckoutPage enterData(String firstname, String lastname, String zip) {
        enter(this.firstName, firstname);
        enter(this.lastName, lastname);
        enter(this.zip, zip);
        return this;
    }

    public CheckoutPage clickContinue() {
        click(this.continueBtn);
        return this;
    }

    public CheckoutPage clickOnFinish() {
        click(finishBtn);
        return this;
    }
}
