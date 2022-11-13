package com;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert.*;

public class CartPage {
    @FindBy(css = "div#content form.woocommerce-cart-form tr[class$='cart_item']")
    private List<WebElement> cartItems;
    @FindBy(xpath = "//form[@class=\"woocommerce-cart-form\"]//tr[contains(@class, 'cart_item')]//td[contains(@class, 'product-price')]")
    private List<WebElement> prices;
    @FindBy(id = "")
    private WebElement asdasd2;
    @FindBy(id = "")
    private WebElement asdasd3;


    public void checkTotalNumberOfItemsIsFour() {
        Assert.assertEquals(4, cartItems.size());
    }

    public void searchForLowestPrice() {
        List<Integer> list = new ArrayList<>();

        for(WebElement price : prices){
            list.add(Integer.parseInt(price.getText().replace("$", "")));
        }
        Integer min = list
                .stream()
                .mapToInt(v -> v)
                .min().orElseThrow(NoSuchElementException::new);
        System.out.println("Lowest price is" + min);
    }

    public void removeLowestPriceItemFromCart() {
        WebElement correct = prices.stream().filter((element) -> element.getText().contains("Flying Ninja")).findFirst().orElse(null);
        Assert.assertNotNull(correct);
        correct.findElement(By.xpath("/..//td")).click();
    }

    public void checkTotalNumberOfItemsIsThree() {
        Assert.assertEquals(3, cartItems.size());
    }

}
