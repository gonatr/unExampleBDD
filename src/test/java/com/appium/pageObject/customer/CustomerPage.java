package com.appium.pageObject.customer;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.base.BaseTClass;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomerPage extends BaseTClass {
    public static AppiumDriver appiumDriver;

    public CustomerPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }


    String[] codeStore = {"Store01", "Store02", "Store03", "Store04", "Store05"};
    public String selectCustomerId(){
        String custID = Arrays.toString(codeStore);
        return custID;
    }

    public String getCustomer(){
        String custID = Arrays.toString(codeStore);
        return custID;
    }

}
