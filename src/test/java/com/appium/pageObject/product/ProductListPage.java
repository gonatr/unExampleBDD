package com.appium.pageObject.product;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.base.BaseTClass;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.UUID;

public class ProductListPage extends BaseTClass {
    public static AppiumDriver appiumDriver;



    public ProductListPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    String[] codeProduct = {"Product01, Product02, Product03, Product04, Product05, Product06"};

    public String getProduct() {
        String prodId = Arrays.toString(codeProduct);

        return prodId;
    }

    public int setQuantity(int quantity) {
        return quantity;
    }

    public String addNote(String note) {
        String noteId = note;
        return noteId;
    }

    public int stockProduct(int stockItem){
        int quantity = stockItem;
        return quantity;
    }

    public String trackingOrder(){
        UUID trackingId = UUID.randomUUID();
        return trackingId.toString();
    }





}
