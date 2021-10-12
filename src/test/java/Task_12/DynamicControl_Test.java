package Task_12;

import PageObject.herokuapp.DynamicControlsObject;
import PageObject.herokuapp.HomePageLinksEnum;
import PageObject.herokuapp.HomePageObject;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DynamicControl_Test extends BaseTest {
    HomePageObject homePageObject;
    DynamicControlsObject dynamicControlsObject;

    @BeforeClass
    public void precondition (){
        homePageObject = new HomePageObject();
        dynamicControlsObject = new DynamicControlsObject();
        homePageObject.clickLink(HomePageLinksEnum.DYNAMIC_CONTROLS);
    }

    @Test
    public void dynamicControlsObject_Test() {  //Fluent / Chain of Invocation
        dynamicControlsObject.verifyPageTitle()
                .clickRemoveBtn()
                .verifyElements("It's gone!")
                .verifyInput()
                .verifyEnableBtn();
    }

}
