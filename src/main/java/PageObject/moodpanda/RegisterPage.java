package PageObject.moodpanda;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {

    @FindBy (css = "#UpdateMoodWelcome .modal-header h4")
    SelenideElement pageTitle;

    @FindBy (id = "ContentPlaceHolderContent_TextBoxFirstName")
    SelenideElement inputFirstName;

    @FindBy (id = "ContentPlaceHolderContent_TextBoxSurname")
    SelenideElement inputSurname;

    @FindBy (id = "ContentPlaceHolderContent_DropDownListGender")
    SelenideElement gender;

    @FindBy (id = "ContentPlaceHolderContent_DropDownListYearOfBirth")
    SelenideElement yearOfBirth;

    @FindBy (id = "ContentPlaceHolderContent_TextBoxEmail")
    SelenideElement inputEmail;

    @FindBy (id = "ContentPlaceHolderContent_TextBoxPassword")
    SelenideElement password;

    @FindBy (id = "ContentPlaceHolderContent_TextBoxPasswordConfirm")
    SelenideElement confirmPassword;

    @FindBy (id = "ContentPlaceHolderContent_ButtonLogin")
    SelenideElement loginBtn;


    public RegisterPage checkingRegisterPage(){
        inputFirstName.shouldBe(Condition.exist);
        inputEmail.shouldBe(Condition.exist);
        inputSurname.shouldBe(Condition.exist);
        gender.shouldBe(Condition.exist);
        yearOfBirth.shouldBe(Condition.exist);
        loginBtn.shouldBe(Condition.exist);
        password.shouldBe(Condition.exist);
        confirmPassword.shouldBe(Condition.exist);
        return this;
    }

    public RegisterPage verifyText() {
        pageTitle.shouldBe(Condition.matchText("Create MoodPanda Account"));
        return this;
    }



}
