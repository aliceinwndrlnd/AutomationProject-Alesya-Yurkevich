package driver;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Listeners;
import properties.PropertyReader;
import testNg.Listener;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.driver;

@Log4j2
@Listeners(Listener.class)
public class BaseTest_Selenide {

    public <PageObjectClass> PageObjectClass get(Class<PageObjectClass> pageObjectClassClass) {
        return driver().hasWebDriverStarted() ? page(pageObjectClassClass) : open(PropertyReader.getProperties().getProperty("url"), pageObjectClassClass);
    }
}