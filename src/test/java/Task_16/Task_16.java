package Task_16;

import PageObject.moodpanda.HomePage;
import PageObject.moodpanda.TestimonialsPage;
import driver.BaseTest_Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;


public class Task_16 extends BaseTest_Selenide {

    @Test
    public void verifyHomePage_Test() {
        get(HomePage.class)
                .checkBrandNameSubtext()
                .checkImage();
    }

    @Test
    public void verifyTestimonialsPage_Test() {
        get(HomePage.class)
                .clickScrollDownBtn();

        get(TestimonialsPage.class)
                .verifyContentText("FOR MOOD-TRACKING")
                .verifyContentText("MOBILE & WEB APP");
    }

    @AfterMethod
    public void post() {
        closeWebDriver();
    }
}