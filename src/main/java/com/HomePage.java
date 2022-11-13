package com;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
public class HomePage {
    @FindBy(css = "div[class='columns-3'] div.ellie-thumb-wrapper a[class*='product__link']")
    private List<WebElement> items;

    @FindBy(css = "div[class='columns-3'] div.ellie-thumb-wrapper a[class*='add_to_cart']")
    private WebElement addToCard;
    @FindBy(css = "div[class='columns-3'] a[href='https://cms.demo.katalon.com/cart/']")
    private WebElement viewCart;

    public HomePage(List<WebElement> items, WebElement addToCard, WebElement viewCart) {
        this.items = items;
        this.addToCard = addToCard;
        this.viewCart = viewCart;
    }

    public void selectFourItems() {
        for (int i = 0; i <= 3; i++) {
            Actions action = new Actions(getDriver());
            action.moveToElement(items.get(i)).perform();
            action.moveToElement(addToCard);
            action.click().build().perform();
        }
    }

    public void viewMyCart() {
        viewCart.click();
    }

}
