import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Task_5 {
    WebDriver driver = null;

    @BeforeTest
    public void preconditions() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void parameterscheck1() {
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
        driver.findElement(By.name("calc_roomwidth")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), "8", Keys.ENTER);
        driver.findElement(By.name("calc_roomheight")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE),"9",Keys.ENTER);
        driver.findElement(By.name("calc_lamwidth")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE),"2000",Keys.ENTER);
        driver.findElement(By.name("calc_lamheight")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE),"400",Keys.ENTER);
        driver.findElement(By.name("calc_inpack")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE),"34",Keys.ENTER);
        driver.findElement(By.name("calc_price")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE),"1500",Keys.ENTER);
        Select select = new Select(driver.findElement(By.name("calc_direct")));
        select.selectByIndex(0);
        driver.findElement(By.name("calc_bias")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE),"300",Keys.ENTER);
        driver.findElement(By.name("calc_walldist")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE),"5",Keys.ENTER);
        WebElement calkBtn = driver.findElement(By.xpath("//*[@class='btn btn-secondary btn-lg tocalc']"));
        calkBtn.click();
        Assert.assertEquals(driver.findElement(By.id("s_lam")).getText(), "71.83 м2.");
        Assert.assertEquals(driver.findElement(By.id("l_count")).getText(), "95 шт.");
        Assert.assertEquals(driver.findElement(By.id("l_packs")).getText(), "3 шт.");
        Assert.assertEquals(driver.findElement(By.id("l_price")).getText(), "122400 руб.");
        Assert.assertEquals(driver.findElement(By.id("l_over")).getText(), "7 шт.");
        Assert.assertEquals(driver.findElement(By.id("l_trash")).getText(), "10 шт.");
    }

    @Test
    public void parameterscheck2() {
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
        driver.findElement(By.name("calc_roomwidth")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), "15", Keys.ENTER);
        driver.findElement(By.name("calc_roomheight")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE),"10",Keys.ENTER);
        driver.findElement(By.name("calc_lamwidth")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE),"2000",Keys.ENTER);
        driver.findElement(By.name("calc_lamheight")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE),"300",Keys.ENTER);
        driver.findElement(By.name("calc_inpack")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE),"20",Keys.ENTER);
        driver.findElement(By.name("calc_price")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE),"3800",Keys.ENTER);
        Select select = new Select(driver.findElement(By.name("calc_direct")));
        select.selectByIndex(1);
        driver.findElement(By.name("calc_bias")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE),"100",Keys.ENTER);
        driver.findElement(By.name("calc_walldist")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE),"10",Keys.ENTER);
        WebElement calkBtn = driver.findElement(By.xpath("//*[@class='btn btn-secondary btn-lg tocalc']"));
        calkBtn.click();
        Assert.assertEquals(driver.findElement(By.id("s_lam")).getText(), "149.50 м2.");
        Assert.assertEquals(driver.findElement(By.id("l_count")).getText(), "253 шт.");
        Assert.assertEquals(driver.findElement(By.id("l_packs")).getText(), "13 шт.");
        Assert.assertEquals(driver.findElement(By.id("l_price")).getText(), "592800 руб.");
        Assert.assertEquals(driver.findElement(By.id("l_over")).getText(), "7 шт.");
        Assert.assertEquals(driver.findElement(By.id("l_trash")).getText(), "9 шт.");
    }

    @Test
    public void parameterscheck3() {
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
        Actions actions = new Actions(driver);
        actions.keyDown(driver.findElement(By.name("calc_roomwidth")), Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys("3").build().perform();
        actions.keyDown(driver.findElement(By.name("calc_roomheight")), Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys("3").build().perform();
        actions.keyDown(driver.findElement(By.name("calc_lamwidth")), Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys("156").build().perform();
        actions.keyDown(driver.findElement(By.name("calc_lamheight")), Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys("55").build().perform();
        actions.keyDown(driver.findElement(By.name("calc_inpack")), Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys("10").build().perform();
        actions.keyDown(driver.findElement(By.name("calc_price")), Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys("700").build().perform();
        Select select = new Select(driver.findElement(By.name("calc_direct")));
        select.selectByIndex(1);
        actions.keyDown(driver.findElement(By.name("calc_bias")), Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys("33").build().perform();
        actions.keyDown(driver.findElement(By.name("calc_walldist")), Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys("5").build().perform();
        WebElement calkBtn = driver.findElement(By.xpath("//*[@class='btn btn-secondary btn-lg tocalc']"));
        calkBtn.click();
        Assert.assertEquals(driver.findElement(By.id("s_lam")).getText(), "8.94 м2.");
        Assert.assertEquals(driver.findElement(By.id("l_count")).getText(), "1100 шт.");
        Assert.assertEquals(driver.findElement(By.id("l_packs")).getText(), "110 шт.");
        Assert.assertEquals(driver.findElement(By.id("l_price")).getText(), "6606 руб.");
        Assert.assertEquals(driver.findElement(By.id("l_over")).getText(), "0 шт.");
        Assert.assertEquals(driver.findElement(By.id("l_trash")).getText(), "55 шт.");
    }

    @Test
    public void googletest1() {
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("(/html/body/div//form/div//input)[1]")).sendKeys("Hello world",Keys.ENTER);
        Actions act = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("(//*[@id='rso']//a/h3)[9]"));
        act.moveToElement(element).click(element).build().perform();
    }

    @Test
    public void googletest2() {
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("(/html/body/div//form/div//input)[1]")).sendKeys("//",Keys.ENTER);
        List<String> textList1 = new ArrayList<>();
        driver.findElements(By.xpath("(//*[@id=\"topstuff\"]/div//p)[1]")).forEach(data -> textList1.add(data.getText()));
        Assert.assertTrue(textList1.contains("По запросу // ничего не найдено. "));

    }


    @AfterTest
    public void postconditions() {
        driver.quit();
    }
}
