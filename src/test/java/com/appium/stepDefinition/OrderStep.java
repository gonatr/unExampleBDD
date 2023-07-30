package com.appium.stepDefinition;

import com.appium.pageObject.customer.CustomerPage;
import com.appium.pageObject.product.ProductListPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.utils.AppiumDriverEx;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrderStep {
    public static AppiumDriver appiumDriver;

    public OrderStep() {
        this.appiumDriver = AppiumDriverEx.appiumDriver;
    }

    CustomerPage customer;
    ProductListPage product;

    @Given("User on page app Store")
    public void userOnPageAppStore() {
        customer = new CustomerPage(appiumDriver);
        product = new ProductListPage(appiumDriver);
        System.out.println("User on page app Store");
    }

    @When("^User clicks store, (?:see|not) select store name from list$")
    public void userClicksStoreSelectStoreNameFromList() {
        System.out.println("User clicked store = "+customer.getCustomer());
    }

    @Then("^User will (?:see|not) get selected store code from list (.*)$")
    public void userWillGetSelectedStoreCodeFromList(String result) {
        if (result.contains("true")){
            String storeCode1 = "Store01";
            assertTrue(customer.selectCustomerId().contains(storeCode1));
            System.out.println("Success select store");
        } else if (result.contains("false")){
            System.out.println("Please select store code!");
        }
    }

    @When("^User clicks store, (?:see|not) select product name from list$")
    public void userClicksStoreSelectProductNameFromList() {
        System.out.println("User clicked product = " + product.getProduct());
    }

    @Then("^User will (?:see|not) get selected product code from list (.*)$")
    public void userWillGetSelectedProductCodeFromList(String text) {
        if (text.contains("true")){
            String productCode1 = "Product01";
            assertTrue(product.getProduct().contains(productCode1));
            System.out.println("Success selected product code");
        } else if(text.contains("false")){
            System.out.println("Please select a product code!");
        }
    }

    @When("^User clicks store, (?:see|not) select quantity from list (.*)$")
    public void userClicksStoreSelectQuantityFromList(String text) {
        if (text.contains("true")) {
            int userQTY = 2;
            System.out.println("User clicked quantity = " + userQTY);
        } else if (text.contains("false")) {
            System.out.println("User not clicked quantity");
        }
    }

    @Then("^User will (?:see|not) get selected quantity (.*)$")
    public void userWillGetSelectedQuantity(String text) {
        if (text.contains("true")){
            int userQTY = 2;
            int productQTY = product.setQuantity(2);
            assertTrue(userQTY == productQTY);
            System.out.println("Success user set quantity");
        } else if (text.contains("false")){
            System.out.println("Please select a quantity!");
        }

    }

    @When("User adds notes to product order")
    public void userAddsNotesToProductOrder() {
        String notes = "comments product from User";
        System.out.println("User write = " + notes);
    }

    @Then("User will get notes")
    public void userWillGetNotes() {
        String notes = "comments product from User";
        assertEquals(product.addNote("comments product from User"), notes);
        System.out.println("Success add notes to product order");
    }
}
