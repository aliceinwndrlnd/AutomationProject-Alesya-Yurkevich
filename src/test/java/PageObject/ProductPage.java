package PageObject;

import org.openqa.selenium.By;

public class ProductPage extends BasePage {

    private By icon = By.className("app_logo");
    private By filter = By.xpath("//select");
    private By addToCartBtn = By.name("add-to-cart-sauce-labs-backpack");
    private By cartBtn = By.cssSelector(".shopping_cart_link");

    public ProductPage displayProductPage() {
        isDisplayed(icon, filter, cartBtn);
        return this;
    }

    public ProductPage addToCartBtn() {
        click(addToCartBtn);
        return this;
    }

    public ProductPage clickToCartBtn() {
        click(cartBtn);
        return this;
    }

}
