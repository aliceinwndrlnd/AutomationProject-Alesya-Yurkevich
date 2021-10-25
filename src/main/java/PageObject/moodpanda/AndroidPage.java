package PageObject.moodpanda;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class AndroidPage {

    @FindBy(id = "fcxH9b")
    SelenideElement googlePlay;

    public AndroidPage checkGooalePlayVisability() {
        googlePlay.shouldBe(Condition.enabled);
        return this;
    }

}
