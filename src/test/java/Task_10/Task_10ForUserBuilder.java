package Task_10;

import Builder.UserBuilder;
import PageObject.saucedemo.LoginPage;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task_10ForUserBuilder extends BaseTest {
    LoginPage loginPage;

    @BeforeClass
    public void precondition() {
        loginPage = new LoginPage(driver);
        loginPage.openPage();
    }

    @Test
    public void forBuilderTest() {
        UserBuilder userBuilder = new UserBuilder.Builder().withUsername("standard_user").withPassword("secret_sauce").build();
        System.out.println(userBuilder.toString());
    }

}
