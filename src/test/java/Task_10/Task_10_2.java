package Task_10;

import Builder.UserBuilder;
import PageObject.saucedemo.CartPage;
import PageObject.saucedemo.LoginPage;
import PageObject.saucedemo.ProductPage;
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
    UserBuilder userBuilder;


    @BeforeClass
    public void precondition() {
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        userBuilder = new UserBuilder.Builder().withUsername("standard_user").withPassword("secret_sauce").build();
        }


    @Parameters({"username","password"})
    @Link("https://www.saucedemo.com/cart")
    @Description("adding and removing items from the cart")
    @Test(invocationCount = 3)
    public void addAndRemove() {
        loginPage.openPage()
                .loginApp(userBuilder);
        productPage.addToCartBtn()
                .clickToCartBtn();
        cartPage.btnChecking();
        }

}
