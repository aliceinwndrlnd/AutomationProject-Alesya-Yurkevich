import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Task_6 {

    @Test
     public void test() {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.saucedemo.com/");
    driver.findElement(By.id("user-name")).sendKeys("standard_user");
    driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
    driver.findElement(By.id("login-button")).click();
    Actions act = new Actions(driver);
    WebElement element = driver.findElement(By.xpath("//*[@id=\"item_3_title_link\"]/div"));
    act.moveToElement(element).click(element).build().perform();
    driver.findElement(By.cssSelector("#add-to-cart-test\\.allthethings\\(\\)-t-shirt-\\(red\\)")).click();
    driver.findElement(By.className("shopping_cart_link")).click();
    Assert.assertEquals(driver.findElement(By.className("inventory_item_name")).getText(),"Test.allTheThings() T-Shirt (Red)");
    Assert.assertEquals(driver.findElement(By.className("inventory_item_price")).getText(),"$15.99");

    driver.quit();
    }
}
