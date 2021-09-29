package Task_12;

import PageObject.herokuapp.FramesObject;
import PageObject.herokuapp.HomePageLinksEnum;
import PageObject.herokuapp.HomePageObject;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Frames_Test extends BaseTest {
    HomePageObject homePageObject;
    FramesObject framesObject;

    @BeforeClass
    public void precondition (){
        homePageObject = new HomePageObject(driver);
        framesObject = new FramesObject(driver);
        homePageObject.clickLink(HomePageLinksEnum.FRAMES);
    }

    @Test
    public void frames_Test() {
        framesObject.verifyPageTitle("Frames")
                .clickFrameLink("iFrame")
                .verifyPageTitle("An iFrame containing the TinyMCE WYSIWYG Editor")
                .verityFrameText("Your content goes here.");
    }
}
