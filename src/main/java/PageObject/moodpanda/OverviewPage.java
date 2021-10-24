package PageObject.moodpanda;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.support.FindBy;



public class OverviewPage {
    @FindBy(css = ".about-content i")
    ElementsCollection overviewPickEl;

    public OverviewPage verifyOverviewPage() {
        overviewPickEl.forEach(pick->pick.is(Condition.visible));
        return this;
    }

}
