package com.appium.stepDefinition;

import com.appium.pageObject.product.ProductListPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.utils.AppiumDriverEx;

import static org.junit.Assert.assertTrue;

public class StockProductStep {
    public static AppiumDriver appiumDriver;

    public StockProductStep() {
        this.appiumDriver = AppiumDriverEx.appiumDriver;
    }

    ProductListPage product;

    @Given("^Admin sales click stock product (.*)$")
    public void adminSalesClickStockProduct(String text) {
        product = new ProductListPage(appiumDriver);
        int order = product.setQuantity(4);
        if (text.contains("true")){
            System.out.println("ini order: " + order);
        } else if (text.contains("false")){
            System.out.println("There is not product ordered!");
        }
    }

    @Then("^Admin sales get the stock product from warehouse and document tracking (.*)$")
    public void adminSalesGetTheStockProductAndNumberTracking(String text) {
        if (text.contains("true")) {
            int order = product.setQuantity(4);
            int stockItems = product.stockProduct(5);
            String trackingId = product.trackingOrder();

            if (stockItems >= order){
                assertTrue(stockItems >= order);
                assertTrue(trackingId.contains(trackingId));
                System.out.println("maka admin gudang akan menandai nomor-nomor pesanan dengan kriteria tersebut.");
                System.out.println("cetak document surat jalan = "+trackingId);
            } else if (stockItems <= order){
                assertTrue(stockItems <= order);
                System.out.println("Document dengan stock tidak cukup");
            }
        } else if (text.contains("false")){
            System.out.println("There is not product order and document tracking!");
        }
    }
}
