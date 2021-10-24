package PageObject.moodpanda;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class AboutPage {

    @FindBy (linkText = "Read our interview as part of QuantifiedSelf's ToolMaker Series")
    SelenideElement about;

    public AboutPage checkAboutPage() {
        about.shouldBe(Condition.visible);
        return this;
    }

}
