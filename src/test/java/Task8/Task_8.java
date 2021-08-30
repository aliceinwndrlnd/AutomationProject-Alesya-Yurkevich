package Task8;

import driver.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task_8 extends BaseTest {

    @BeforeTest
    public void preconditions() {
        driver.get(System.getProperty("user.dir") + "/src/test/java/Task8/html/index.html");
    }

    @Test
    public void testTable(){
        List<WebElement> heads = driver.findElements(By.xpath("//table//th[1]"));
        Map<String,List<String>> data = new HashMap<>();
        for (int index = 0; index < heads.size(); index++){
        List<String> columnData = new ArrayList<>();
        List <WebElement>columns = driver.findElements(By.xpath("//table//tr//following::tr//td[" + (index + 1) + "]"));
        for (WebElement column : columns) {
            columnData.add(column.getText());
        }
        data.put(heads.get(index).getText(), columnData);
    }
    data.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
    @Test
    public void testInput ()  {
        driver.findElement(By.id("email")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//*[@id='mails']/input[2]")).click();
    }
    @Test
    public void testCheckbox () {
        driver.findElement(By.id("allcountries")).click();
    }
    @Test
    public void testSelect () {
        Select select = new Select(driver.findElement(By.name("hasequipment")));
        select.selectByIndex(0);
    }
    @Test
    public void testButton () {
        driver.findElement(By.xpath("//td[1]/button")).click();
    }
    @Test
    public void testPic () {
        driver.findElement(By.xpath("//img")).isDisplayed();
    }
    @Test
    public void testLink () throws InterruptedException {
        driver.findElement(By.linkText("Visit our website")).click();
        Thread.sleep(2000);
    }
    @Test
    public void testTagText () {
        Assert.assertEquals(driver.findElement(By.xpath("//p[2]")).getText(),"If you agree to receive our mails, please enter your e-mail address:");
    }
}


