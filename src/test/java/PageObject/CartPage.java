package PageObject;

import org.openqa.selenium.By;
import org.testng.Assert;

public class CartPage extends BasePage{
    private By removebtn = By.id("remove-sauce-labs-backpack");
    private By continuebtn = By.id("continue-shopping");
    private By checkoutBtn = By.id("checkout");
    private By title = By.cssSelector(".title");
    private By products = By.className("cart_item_label");

    public CartPage compareTitle (String expected) {
        Assert.assertEquals(getElementText(title),expected);
        return this;
    }
    public CartPage btnChecking() {
        click(this.removebtn);
        click(this.continuebtn);
        return this;
    }
    public CartPage checkoutBtn(){
        click(checkoutBtn);
        return this;
    }
    public CartPage poductDisplay(){
        isDisplayed(products);
        return this;
    }

}
