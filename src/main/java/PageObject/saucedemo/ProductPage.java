package PageObject.saucedemo;


import PageObject.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductPage extends BasePage {

    private By icon = By.className("app_logo");
    private By filter = By.xpath("//select");
    private By addToCartBtn = By.name("add-to-cart-sauce-labs-backpack");
    private By cartBtn = By.cssSelector(".shopping_cart_link");
    private By products = By.cssSelector(".inventory_item_name");
    private By price = By.cssSelector(".inventory_item_price");
    private By aToZ = By.cssSelector("[value=az]");
    private By zToA = By.cssSelector("[value=za]");
    private By LoToHiPrice = By.cssSelector("[value=lohi]");
    private By HiToLoPrice = By.cssSelector("[value=hilo]");


    public ProductPage displayProductPage() {
        isDisplayed(icon, filter, cartBtn);
        return this;
    }

    public ProductPage addToCartBtn() {
        click(addToCartBtn);
        return this;
    }

    public ProductPage clickToCartBtn() {
        click(cartBtn);
        return this;
    }

    public ProductPage sleep() {
        pause(2);
        return this;
    }

    public ProductPage clickOnFilterBtn() {
        click(filter);
        return this;
    }

    public enum FilterVar {
        AtoZ,
        ZtoA,
        LoToHi,
        HiToLo
    }

    public ProductPage clickFilterVar(FilterVar filterVar) {
        switch (filterVar) {
            case AtoZ:
                click(aToZ);
                sortFromAtoZ();
                break;
            case ZtoA:
                click(zToA);
                sortFromZtoA();
                break;
            case LoToHi:
                click(LoToHiPrice);
                sortLoToHi();
                break;
            case HiToLo:
                click(HiToLoPrice);
                sortHiToLo();
                break;
        }
        return this;
    }


    public ProductPage sortFromAtoZ() {
        List<String> expectedData = driver.findElements(products).stream().map(data -> data.getText()).sorted().collect(Collectors.toList());
        List<String> actualData = driver.findElements(products).stream().map(data -> data.getText()).collect(Collectors.toList());
        Assert.assertEquals(expectedData, actualData);
        return this;
    }

    public ProductPage sortFromZtoA() {
        List<String> expectedData = driver.findElements(products).stream().map(data -> data.getText()).sorted(Collections.reverseOrder()).collect(Collectors.toList());
        List<String> actualData = driver.findElements(products).stream().map(data -> data.getText()).collect(Collectors.toList());
        Assert.assertEquals(expectedData, actualData);
        return this;
    }

    public ProductPage sortLoToHi() {
        List<String> list1 = driver.findElements(price).stream().map(data -> data.getText()).collect(Collectors.toList());
        List<Double> actualData = list1.stream().map(data -> Double.parseDouble(data.replace("$", ""))).collect(Collectors.toList());
        List<Double> expectedData = list1.stream().map(data -> Double.parseDouble(data.replace("$", ""))).sorted().collect(Collectors.toList());
        Assert.assertEquals(expectedData, actualData);
        return this;
    }

    public ProductPage sortHiToLo() {
        List<String> list1 = driver.findElements(price).stream().map(data -> data.getText()).collect(Collectors.toList());
        List<Double> actualData = list1.stream().map(data -> Double.parseDouble(data.replace("$", ""))).collect(Collectors.toList());
        List<Double> expectedData = list1.stream().map(data -> Double.parseDouble(data.replace("$", ""))).sorted(Collections.reverseOrder()).collect(Collectors.toList());
        Assert.assertEquals(expectedData, actualData);
        return this;
    }

}



