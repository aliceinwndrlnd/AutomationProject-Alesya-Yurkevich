package Task_16;

import PageObject.moodpanda.*;
import driver.BaseTest_Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Selenide.*;


public class Task_16 extends BaseTest_Selenide {

    @Test (priority = 1)
    public void verifyHomePage_Test() {
        get(HomePage.class)
                .checkBrandNameSubtext()
                .checkImage();
    }

    @Test (priority = 2)
    public void verifyLoginPage_Test() {
        get(HomePage.class)
                .clickLoginPage();
        get(LoginPage.class)
                .checkingLoginPage()
                .verifyText()
                .verifyImg();
    }

    @Test (priority = 3)
    public void verifyRegisterPage(){
        get(HomePage.class)
                .clickLoginPage();
        get(LoginPage.class)
                .clickCreateAkk();
        get(RegisterPage.class)
                .checkingRegisterPage()
                .verifyText();
    }

    @Test (priority = 4)
    public void verifyOverviewPage() {
        get(HomePage.class)
                .clickOverviewPage();
        get(OverviewPage.class)
                .verifyOverviewPage();
    }

    @Test (priority = 5)
    public void verifyTestimonialsPage_Test() {
        get(HomePage.class)
                .clickScrollDownBtn();

        get(TestimonialsPage.class)
                .verifyContentText("FOR MOOD-TRACKING")
                .verifyContentText("MOBILE & WEB APP");
    }

    @Test (priority = 6)
    public void verifyiOsPage() {
        get(HomePage.class)
                .clickiOsPage();
        get(iOSPage.class)
                .checkiOsPage();
    }

    @Test (priority = 7)
    public void verifyAndroidPage() {
        get(HomePage.class)
                .clickAndroidPage();
        get(AndroidPage.class)
                .checkGooalePlayVisability();
    }

   @Test (priority = 8)
    public void verifyAboutPage() {
        get(HomePage.class)
                .clickAboutPage();
        get(AboutPage.class)
                .checkAboutPage();
    }

    @Test (priority = 9)
    public void verifyFaqsPage() {
        get(HomePage.class)
                .clickFaqsPage();
        get(FAQsPage.class)
                .checkFaqs();
    }


    @AfterMethod
    public void post() {
        closeWebDriver();
    }
}