package com.appium.stepDefinition;

import com.appium.pageObject.product.ProductListPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.utils.AppiumDriverEx;

import static org.junit.Assert.assertTrue;

public class AdminSalesStep {
    public static AppiumDriver appiumDriver;

    public AdminSalesStep(){
        this.appiumDriver = AppiumDriverEx.appiumDriver;
    }

    ProductListPage product;

    @Given("^Admin sales click store, click list order (.*)$")
    public void adminSalesClickListOrder(String text) {
        product = new ProductListPage(appiumDriver);
        int order = product.setQuantity(3);

        if (text.contains("true")){
            System.out.println("Admin sales get list order = " + order);
        } else if (text.contains("false")){
            System.out.println("There is not ordered!");
        }
    }

    @Then("^Admin sales can (?:see|not) list orders input from salesman (.*)$")
    public void adminSalesCanSeeListOrdersInputFromSalesman(String text) {
        if (text.contains("true")){
            int order = product.setQuantity(3);
            int stockItem = product.stockProduct(5);
            String productCode = "Product01";
            int stockGudang = stockItem - order;

            System.out.printf("ini Stock: " + stockGudang);
            if (stockItem >= order){
                assertTrue(product.getProduct().contains(productCode));
                assertTrue(stockItem >= order);
                System.out.println(", maka dia akan menandai nomer - nomer pesanan tsb untuk disiapkan okeh Admin Gudang.");
            } else if (stockItem <= order){
                assertTrue(product.getProduct().contains(productCode));
                assertTrue(stockItem <= order);
                System.out.println(", selisih QTYnya akan dibuatkan menjadi dokumen pesanan baru  ");
            }
        } else if (text.contains("false")){
            System.out.println("Salesmen not input product");
        }

    }
}
