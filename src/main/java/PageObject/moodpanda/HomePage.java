package PageObject.moodpanda;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(css = ".scroll-down > a")
    SelenideElement scrollDownBtn;

    @FindBy(className = "brand-name-subtext")
    SelenideElement brandNameSubtext;

    @FindBy(css = ".img-responsive.img-centered")
    SelenideElement img;

    @FindBy (css = "a[href*='/Login/']")
    SelenideElement loginPage;

    @FindBy (css = "a[href='#about']")
    SelenideElement overviewPage;

    @FindBy (css = "a[href$='mt=8']")
    SelenideElement iOsPage;

    @FindBy (css = "a[href$='GB']")
    SelenideElement androidPage;

    @FindBy (css = "a[href$='about.aspx']")
    SelenideElement aboutPage;

    @FindBy (css = "a[href='/faq.aspx']")
    SelenideElement faqPage;

    public HomePage clickScrollDownBtn() {
        scrollDownBtn.click();
        return this;
    }

    public HomePage checkBrandNameSubtext() {
        brandNameSubtext.should(Condition.matchText("track your mood & get anonymous support"));
        return this;
    }

    public HomePage checkImage() {
        this.img.shouldBe(Condition.exist);
        return this;
    }

    public HomePage clickLoginPage() {
        loginPage.click();
        return this;
    }

    public HomePage clickAboutPage() {
        aboutPage.click();
        return this;
    }

    public HomePage clickiOsPage() {
        iOsPage.click();
        return this;
    }

    public HomePage clickAndroidPage() {
        androidPage.click();
        return this;
    }

    public HomePage clickFaqsPage() {
        faqPage.click();
        return this;
    }

    public HomePage clickOverviewPage() {
        overviewPage.click();
        return this;
    }


}