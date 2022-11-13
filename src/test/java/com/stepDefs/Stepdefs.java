package com.stepDefs;

import com.CartPage;
import com.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Stepdefs {

    @Steps
    private HomePage homePage;
    @Steps
    private CartPage cartPage;

    public Stepdefs(HomePage homePage, CartPage cartPage) {
        this.homePage = homePage;
        this.cartPage = cartPage;
    }


    @Given("I add four random items to my cart")
    public void iAddFourRandomItemsToMyCart() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://cms.demo.katalon.com");
        homePage.selectFourItems();
    }

    @When("I view my cart")
    public void iViewMyCart() {
        homePage.viewMyCart();
    }

    @Then("I find total four items listed in my cart")
    public void iFindTotalFourItemsListedInMyCart() {
        cartPage.checkTotalNumberOfItemsIsFour();
    }

    @When("I search for lowest price item")
    public void iSearchForLowestPriceItem() {
        cartPage.searchForLowestPrice();
    }

    @And("I am able to remove the lowest price item from my cart")
    public void iAmAbleToRemoveTheLowestPriceItemFromMyCart() {
        cartPage.removeLowestPriceItemFromCart();
    }

    @Then("I am able to verify three items in my cart")
    public void iAmAbleToVerifyThreeItemsInMyCart() {
        cartPage.checkTotalNumberOfItemsIsThree();
    }

}
