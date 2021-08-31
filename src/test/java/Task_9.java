import PageObject.*;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task_9 extends BaseTest {
    LoginPage loginPage;
    ProductPage productPage;
    MenuPage menuPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @BeforeClass
    public void precondition() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        menuPage = new MenuPage();
        loginPage.openPage();
    }

    @Test(priority = 1)
    public void loginApp() {     //Fluent / Chain of Invocations
        loginPage.openPage()
                .enterUsername("problem_user")
                .enterPassword("secret_sauce")
                .clickLogin();
    }

    @Test(priority = 2)
    public void loginApp2() {
        loginPage.openPage()
                .enterUsername("locked_out_user")
                .enterPassword("secret_sauce")
                .clickLogin()
                .checkErrorText("Epic sadface: Sorry, this user has been locked out.");
    }

    @Test(priority = 3)
    public void loginApp3() {
        loginPage.openPage()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin();
    }

    @Test(priority = 4)
    public void testMenu() throws InterruptedException {
        Thread.sleep(2000);
        menuPage.clickMenu()
                .display();
    }

    @Test(priority = 5)
    public void testProductPage() throws InterruptedException {
        Thread.sleep(2000);
        productPage.displayProductPage()
                .addToCartBtn()
                .clickToCartBtn();
    }

    @Test(priority = 6)
    public void addToCart() throws InterruptedException {
        Thread.sleep(2000);
        cartPage.compareTitle("YOUR CART")
                .poductDisplay()
                .btnChecking();//remove, continue
        productPage.addToCartBtn().clickToCartBtn();
        cartPage.checkoutBtn();// and checkout buttons
    }

    @Test(priority = 7)
    public void checkout() {
        checkoutPage.enterData("Test", "Test", "22222")
                .clickContinue()
                .clickOnFinish();
    }
}
