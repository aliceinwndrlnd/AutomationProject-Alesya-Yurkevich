package PageObject.moodpanda;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy (id = "ContentPlaceHolderContent_HyperLinkRegister")
    SelenideElement createAccountBtn;

    @FindBy (id = "ContentPlaceHolderContent_TextBoxEmail")
    SelenideElement inputLogin;

    @FindBy (id = "ContentPlaceHolderContent_TextBoxPassword")
    SelenideElement inputPassword;

    @FindBy (id = "ContentPlaceHolderContent_ButtonLogin")
    SelenideElement loginBtn;

    @FindBy (css = "#UpdateMoodWelcome .modal-header > h4")
    SelenideElement titleText;

    @FindBy (css = "#UpdateMoodWelcome > div small")
    SelenideElement cookiesText;

    @FindBy (css = "#ContentPlaceHolderContent_AppStore img")
    SelenideElement footerImg;


    public LoginPage checkingLoginPage() {
        titleText.shouldBe(Condition.exist);
        inputLogin.shouldBe(Condition.exist);
        inputPassword.shouldBe(Condition.exist);
        createAccountBtn.shouldBe(Condition.exist);
        loginBtn.shouldBe(Condition.exist);
        cookiesText.shouldBe(Condition.exist);
        return this;
    }

    public LoginPage verifyText() {
        titleText.shouldBe(Condition.matchText("Login to MoodPanda"));
        cookiesText.shouldBe(Condition.text("MoodPanda uses cookies. By continuing to use MoodPanda you accept this."));
        return this;
    }

    public LoginPage verifyImg(){
        footerImg.shouldBe(Condition.exist);
        return this;
    }

    public LoginPage clickCreateAkk(){
        createAccountBtn.click();
        return this;
    }

}
