package com.sinensia.helloselenide.cucumber;

import com.sinensia.helloselenide.CartPage;
import com.sinensia.helloselenide.CheckoutPage;
import com.sinensia.helloselenide.OrderPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class RobobarStepDefinitions {
    CartPage cartPage;
    CheckoutPage checkoutPage;
    OrderPage orderPage;

    @Given("user opens Robobar website")
    public void userOpensRobobarWebsite() {
        open("http://localhost:3000");
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        orderPage = new OrderPage();
    }

    @When("user adds a cola")
    public void userAddsACola() {
        cartPage.addCola();
    }

    @Then("total should be €{double}")
    public void totalShouldBe€(Double total) {
        cartPage.total().shouldBe(text(total.toString()));
    }

    @When("user adds a beer")
    public void userAddsABeer() {
        cartPage.addBeer();
    }

    @When("user adds a wine")
    public void userAddsAWine() {
        cartPage.addWine();
    }

    @And("user checkout")
    public void userCheckout() {
        cartPage.checkout();
    }

    @And("user inputs age {string}")
    public void userInputsAge(String age) {
        checkoutPage.setAge(age);
    }

    @And("user order")
    public void userOrder() {
        checkoutPage.order();
    }

    @Then("message should be {string}")
    public void messageShouldBeComingRightUp(String msg) {
        orderPage.getSentMessage().shouldBe(text(msg));
    }

    @Then("alert should appear")
    public void alertShouldAppear() {
        orderPage.getAlertDiv().shouldNotBe(hidden);
    }
}
