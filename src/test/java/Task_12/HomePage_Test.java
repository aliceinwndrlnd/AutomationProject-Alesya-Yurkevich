package Task_12;

import PageObject.herokuapp.HomePageObject;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePage_Test extends BaseTest {
    HomePageObject homePageObject;

    @BeforeClass
    public void precondition (){
        homePageObject = new HomePageObject();
    }

    @Test
    public void verifyHomePageObject_Test (){
        homePageObject.openPage().verifyHomePage();
    }

}
