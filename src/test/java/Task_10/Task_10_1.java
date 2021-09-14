package Task_10;

import PageObject.*;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task_10_1 extends BaseTest {
    LoginPage loginPage;
    ProductPage productPage;

    @BeforeClass
    public void precondition() {
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        productPage = new ProductPage(driver);
    }


    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                {"standard_user","secret_sauce",""},//positive
                {"qwerty","secret_sauce","Epic sadface: Username and password do not match any user in this service"},
                {"standard_user","","Epic sadface: Password is required" },
                {""," ","Epic sadface: Username is required"},
                {"locked_out_user","secret_sauce","Epic sadface: Sorry, this user has been locked out."},
        };
    }
        @Test(dataProvider = "dataProvider")
        public void loginApp(String username, String passsword, String errorText) {
            loginPage.openPage()
                    .enterUsername(username)
                    .enterPassword(passsword)
                    .clickLogin();
            if (errorText.isEmpty()) {
                productPage.displayProductPage();
        }else {
                loginPage.checkErrorText(errorText);}
    }
}

