package Task_12;

import Builder.UserBuilder;
import PageObject.herokuapp.FormAuthenticationObject;
import PageObject.herokuapp.HomePageLinksEnum;
import PageObject.herokuapp.HomePageObject;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class FormAuthentication_Test extends BaseTest {  //Builder
    HomePageObject homePageObject;
    FormAuthenticationObject formAuthenticationObject;
    UserBuilder userBuilder;

    @BeforeClass
    public void precondition (){
        homePageObject = new HomePageObject(driver);
        formAuthenticationObject = new FormAuthenticationObject(driver);
        homePageObject.clickLink(HomePageLinksEnum.FORM_AUTHENTICATION);
        userBuilder = new UserBuilder.Builder().withUsername("tomsmith").withPassword("SuperSecretPassword!").build();
    }


    @Test
    public void formAuthentication_Test() {
        formAuthenticationObject.loginApp(userBuilder)
                .clickLogin()
                .verifyLogin();
    }
}
