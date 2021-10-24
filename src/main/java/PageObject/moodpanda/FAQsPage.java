package PageObject.moodpanda;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class FAQsPage {

    @FindBy (css = "#main h2")
    SelenideElement faqs;

    @FindBy (css = "#main p")
    SelenideElement faqsText;

    public FAQsPage checkFaqs() {
        faqs.shouldBe(Condition.visible);
        faqsText.shouldBe(Condition.matchText("Some of our frequently asked questions"));
        return this;
    }

}
