package Task_10;

import Builder.UserBuilder;
import PageObject.saucedemo.LoginPage;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task_10ForUserBuilder extends BaseTest {
    LoginPage loginPage;
    UserBuilder userBuilder;

    @BeforeClass
    public void precondition() {
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        userBuilder = new UserBuilder.Builder().withUsername("standard_user").withPassword("secret_sauce").build();
    }

    @Test
    public void forBuilderTest() {
        loginPage.loginApp(userBuilder);
    }
}
