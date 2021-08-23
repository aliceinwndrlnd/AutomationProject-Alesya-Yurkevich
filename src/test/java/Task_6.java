import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Task_6 {
    WebDriver driver = null;

    @BeforeTest
    public void preconditions() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test1() {
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

    }

    @Test
    public void test2 () {
        driver.get("https://www.saucedemo.com/");
        Actions act = new Actions(driver);
        WebElement element = driver.findElement(By.cssSelector(".login_password"));
        act.moveToElement(element).perform();
        Assert.assertEquals(driver.findElement(By.xpath("//div[2]/h4")).getText(),"Password for all users:");
        Assert.assertEquals(driver.findElement(By.tagName("h4")).getText(),"Accepted usernames are:");
    }

    @Test
    public void test3() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        Assert.assertEquals(driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).getText(),"ADD TO CART");
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.partialLinkText("Linked")));
        act.moveToElement(driver.findElement(By.linkText("Twitter"))).click(driver.findElement(By.linkText("Twitter"))).build().perform();
        Thread.sleep(2000);

    }


    @AfterTest
    public void postconditions() {
        driver.quit();
    }
}
