package com.appium.stepDefinition;

import com.appium.pageObject.customer.CustomerPage;
import com.appium.pageObject.product.ProductPrice;
import com.appium.pageObject.product.ProductListPage;
import com.appium.pageObject.product.Shipping;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.utils.AppiumDriverEx;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShippingStep {
    public static AppiumDriver appiumDriver;

    public ShippingStep () {
        this.appiumDriver = AppiumDriverEx.appiumDriver;
    }
    ProductListPage productList;
    CustomerPage customerList;

    Shipping ship;

    @Given("Admin warehouse click product shipping, select driver")
    public void adminWarehouseClickProductShippingSelectDriver() {
        productList = new ProductListPage(appiumDriver);
        customerList = new CustomerPage(appiumDriver);
        ship = new Shipping(new ArrayList<>());

        System.out.println("Pengecekan product sebelum dikirim ke store");
    }

    @Then("Admin warehouse get the results order from drivers a")
    public void adminWarehouseGetTheResultsOrderFromDrivers() {
        int order = productList.setQuantity(3);
        String customerCode = "Store01";
        if(order != 5 || productList.setQuantity(10) == 0){
            assertTrue(customerList.getCustomer().contains(customerCode));
            assertEquals(0, ship.getTotal(),0);
            System.out.println("Documents yang dibatalkan oleh = " + customerCode);
        }
    }

    @Then("Admin warehouse get the results order from drivers b")
    public void adminWarehouseGetTheResultsOrderFromDriversB() {
        int order = productList.setQuantity(3);
        int stockItem = productList.stockProduct(2);
        ship = new Shipping(Arrays.asList(new ProductPrice(100, 2)));

        if (stockItem <= order){
            assertEquals(200, ship.getTotal(),0);
            System.out.println("Diterima sebagian toko, dengan nilai harga product "+ship.getTotal()+". Admin akan input QTY kembali tiap product");
        } else if (stockItem >= order){
            assertEquals(200, ship.getTotal(),0);
            System.out.println("Diterima toko secara full QTY dengan nilai harga product "+ship.getTotal());
        }
    }

    @Then("Admin warehouse get the results order from drivers c")
    public void adminWarehouseGetTheResultsOrderFromDriversC() {
        int order = productList.setQuantity(3);
        int stockItem = productList.stockProduct(4);
        ship = new Shipping(Arrays.asList(new ProductPrice(100,1), new ProductPrice(200,2)));

        assertEquals(500, ship.getTotal(),0);
    }
}
