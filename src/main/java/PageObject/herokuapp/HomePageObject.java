package PageObject.herokuapp;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePage {

    private By title = By.tagName("h1");
    private By subtitle = By.tagName("h2");

    private By getLink(HomePageLinksEnum homePageLinksEnum){

        return By.linkText(homePageLinksEnum.getLinkText());
    }


    public HomePageObject(WebDriver driver) {

        super(driver);
    }

    public HomePageObject openPage() {
        open();
        return this;
    }

    public HomePageObject clickLink(HomePageLinksEnum homePageLinksEnum){
        click(getLink(homePageLinksEnum));
        return this;
    }

    public HomePageObject verifyHomePage(){
        isDisplayed(title,subtitle);
        for (HomePageLinksEnum homePageLinksEnum : HomePageLinksEnum.values()){
            isDisplayed(getLink(homePageLinksEnum));
        }
        return this;
    }

}
