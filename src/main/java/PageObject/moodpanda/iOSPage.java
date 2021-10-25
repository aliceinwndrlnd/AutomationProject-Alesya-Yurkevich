package PageObject.moodpanda;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class iOSPage {

    @FindBy(css = "a[href*='app-store']")
    SelenideElement appStore;

    public iOSPage checkiOsPage() {
        appStore.shouldBe(Condition.enabled);
        return this;
    }

}
