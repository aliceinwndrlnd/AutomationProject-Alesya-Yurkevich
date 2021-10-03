package Task_10;

import static PageObject.saucedemo.ProductPage.FilterVar.*;

import Builder.UserBuilder;
import PageObject.saucedemo.LoginPage;
import PageObject.saucedemo.ProductPage;
import driver.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Task_10_3 extends BaseTest {
    LoginPage loginPage;
    ProductPage productPage;
    UserBuilder userBuilder;

    @BeforeClass
    public void precondition() {
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        productPage = new ProductPage(driver);
        userBuilder = new UserBuilder.Builder().withUsername("standard_user").withPassword("secret_sauce").build();
    }


    @Parameters({"username", "password"})
    @Description("sorting of products")
    @Link("https://www.saucedemo.com/inventory")
    @Test
    public void sortTest() {
        loginPage.openPage()
                .loginApp(userBuilder);
        productPage.clickOnFilterBtn()
                .clickFilterVar(AtoZ)
                .clickFilterVar(ZtoA)
                .clickFilterVar(LoToHi)
                .clickFilterVar(HiToLo);

    }
}