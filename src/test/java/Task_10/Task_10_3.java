package Task_10;

import static PageObject.ProductPage.FilterVar.*;

import PageObject.*;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Task_10_3 extends BaseTest {
    LoginPage loginPage;
    ProductPage productPage;

    @BeforeClass
    public void precondition() {
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        productPage = new ProductPage(driver);
    }


    @Parameters({"username", "password"})
    @Test
    public void sortTest(@Optional("standard_user") String username, @Optional("secret_sauce") String password) {
        loginPage.openPage()
                .enterUsername(username)
                .enterPassword(password)
                .clickLogin();
        productPage.clickOnFilterBtn()
                .clickFilterVar(AtoZ)
                .clickFilterVar(ZtoA)
                .clickFilterVar(LoToHi)
                .clickFilterVar(HiToLo);

    }
}