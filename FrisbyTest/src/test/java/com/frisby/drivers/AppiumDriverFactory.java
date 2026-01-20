package com.frisby.drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AppiumDriverFactory {

    public static AppiumDriver createDriver() {
        try (InputStream is = AppiumDriverFactory.class.getClassLoader()
                .getResourceAsStream("config.properties")) {

            Properties props = new Properties();
            props.load(is);

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", props.getProperty("platformName"));
            caps.setCapability("deviceName", props.getProperty("deviceName"));
            caps.setCapability("udid", props.getProperty("udid"));
            caps.setCapability("automationName", props.getProperty("automationName"));
            caps.setCapability("app", props.getProperty("app"));
            caps.setCapability("noReset", Boolean.parseBoolean(props.getProperty("noReset")));
            caps.setCapability("autoGrantPermissions",
                    Boolean.parseBoolean(props.getProperty("autoGrantPermissions")));

            String url = props.getProperty("appium.url");
            AppiumDriver driver = new AndroidDriver(new URL(url), caps);

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            return driver;

        } catch (Exception e) {
            throw new RuntimeException("Error creando driver: " + e.getMessage(), e);
        }
    }
}