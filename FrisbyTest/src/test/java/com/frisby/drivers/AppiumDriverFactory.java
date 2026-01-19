package com.example.frisby.drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

public class AppiumDriverFactory {

    public static AppiumDriver<MobileElement> create() {
        try (InputStream is = AppiumDriverFactory.class.getResourceAsStream("/config.properties")) {
            Properties p = new Properties();
            p.load(is);

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", p.getProperty("platformName"));
            caps.setCapability("platformVersion", p.getProperty("platformVersion"));
            caps.setCapability("deviceName", p.getProperty("deviceName"));
            caps.setCapability("automationName", p.getProperty("automationName"));

            String app = p.getProperty("app");
            if (app != null && !app.isEmpty()) {
                caps.setCapability("app", app);
            } else {
                caps.setCapability("appPackage", p.getProperty("appPackage"));
                caps.setCapability("appActivity", p.getProperty("appActivity"));
            }

            String url = p.getProperty("appium.url");
            return new AndroidDriver<>(new URL(url), caps);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo crear el AppiumDriver: " + e.getMessage(), e);
        }
    }
}