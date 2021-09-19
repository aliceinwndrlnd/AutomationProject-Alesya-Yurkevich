package Task_10;

import PageObject.*;
import driver.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Task_10_2 extends BaseTest {
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;


    @BeforeClass
    public void precondition() {
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        }

    @Parameters({"username","password"})
    @Link("https://www.saucedemo.com/cart")
    @Description("adding and removing items from the cart")
    @Test(invocationCount = 3)
    public void addAndRemove(@Optional("standard_user") String username, @Optional("secret_sauce") String password) {
        loginPage.openPage()
                .enterUsername(username)
                .enterPassword(password)
                .clickLogin();
        productPage.addToCartBtn()
                .clickToCartBtn();
        cartPage.btnChecking();
        }

}
