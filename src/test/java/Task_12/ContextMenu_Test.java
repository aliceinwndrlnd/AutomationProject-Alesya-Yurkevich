package Task_12;

import PageObject.herokuapp.ContextMenuObject;
import PageObject.herokuapp.HomePageLinksEnum;
import PageObject.herokuapp.HomePageObject;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContextMenu_Test extends BaseTest {
    HomePageObject homePageObject;
    ContextMenuObject contextMenuObject;

    @BeforeClass
    public void precondition (){
        contextMenuObject = new ContextMenuObject();
        homePageObject = new HomePageObject();
        homePageObject.clickLink(HomePageLinksEnum.CONTEXT_MENU);
    }

    @Test
    public void contextMenuObject_Test (){
        contextMenuObject.verifyPageTitle()
                .verifyAlertText();
    }

}
