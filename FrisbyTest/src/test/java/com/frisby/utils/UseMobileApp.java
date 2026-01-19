package com.frisby.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class UseMobileApp {
    private final AppiumDriver<MobileElement> driver;

    public UseMobileApp(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    public static UseMobileApp with(AppiumDriver<MobileElement> driver) {
        return new UseMobileApp(driver);
    }
}