package com.frisby.support;

import io.appium.java_client.AppiumDriver;
import net.serenitybdd.core.webdriver.driverproviders.ConfiguredDriver;
import net.serenitybdd.core.webdriver.driverproviders.DriverCapabilities;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.SupportedWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverSetup implements ConfiguredDriver {

    @Override
    public WebDriver newInstance(String options, EnvironmentVariables environmentVariables) {
        DesiredCapabilities capabilities = DriverCapabilities.forDriver(SupportedWebDriver.APPIUM, environmentVariables);

        try {
            String appiumUrl = environmentVariables.getProperty("appium.hub");
            return new AppiumDriver(new URL(appiumUrl), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException("URL incorrecta para Appium", e);
        }
    }
}