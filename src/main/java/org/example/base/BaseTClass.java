package org.example.base;

import io.appium.java_client.AppiumDriver;

public class BaseTClass {
    public static AppiumDriver appiumDriver;

    public BaseTClass(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
}
