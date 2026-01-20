package com.frisby.drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AppiumDriverFactory {

    public static AppiumDriver create() {
        AppiumDriver driver = null;
        try (InputStream is = AppiumDriverFactory.class.getClassLoader().getResourceAsStream("config.properties")) {

            if (is == null) {
                throw new RuntimeException("No se encontró el archivo config.properties en el classpath");
            }

            Properties p = new Properties();
            p.load(is);

            DesiredCapabilities caps = new DesiredCapabilities();

            // Configuración básica obligatoria
            String platformName = getRequiredProperty(p, "platformName");
            caps.setCapability("platformName", platformName);

            caps.setCapability("platformVersion", getProperty(p, "platformVersion", "11.0"));
            caps.setCapability("deviceName", getProperty(p, "deviceName", "Android Emulator"));
            caps.setCapability("automationName", getProperty(p, "automationName", "UiAutomator2"));

            // Configuración de app
            String app = p.getProperty("app");
            if (app != null && !app.trim().isEmpty()) {
                caps.setCapability("app", app.trim());
            } else {
                String appPackage = getRequiredProperty(p, "appPackage");
                String appActivity = getRequiredProperty(p, "appActivity");
                caps.setCapability("appPackage", appPackage);
                caps.setCapability("appActivity", appActivity);
            }

            // Configuraciones opcionales comunes
            caps.setCapability("newCommandTimeout", getProperty(p, "newCommandTimeout", "300"));
            caps.setCapability("noReset", Boolean.parseBoolean(getProperty(p, "noReset", "false")));
            caps.setCapability("fullReset", Boolean.parseBoolean(getProperty(p, "fullReset", "false")));
            caps.setCapability("autoGrantPermissions", Boolean.parseBoolean(getProperty(p, "autoGrantPermissions", "true")));
            caps.setCapability("unicodeKeyboard", Boolean.parseBoolean(getProperty(p, "unicodeKeyboard", "true")));
            caps.setCapability("resetKeyboard", Boolean.parseBoolean(getProperty(p, "resetKeyboard", "true")));

            // URL del servidor Appium
            String url = getRequiredProperty(p, "appium.url");
            URL appiumUrl = new URL(url);

            // Crear driver según la plataforma
            if ("Android".equalsIgnoreCase(platformName)) {
                driver = new AndroidDriver(appiumUrl, caps);
            } else if ("iOS".equalsIgnoreCase(platformName)) {
                driver = new IOSDriver(appiumUrl, caps);
            } else {
                driver = new AppiumDriver(appiumUrl, caps);
            }

            // Configurar timeouts por defecto
            driver.manage().timeouts().implicitlyWait(
                    Long.parseLong(getProperty(p, "implicitWait", "10")),
                    TimeUnit.SECONDS
            );

            return driver;

        } catch (Exception e) {
            throw new RuntimeException("No se pudo crear el AppiumDriver: " + e.getMessage(), e);
        }
    }

    private static String getRequiredProperty(Properties p, String key) {
        String value = p.getProperty(key);
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("La propiedad requerida '" + key + "' no está configurada en config.properties");
        }
        return value.trim();
    }

    private static String getProperty(Properties p, String key, String defaultValue) {
        String value = p.getProperty(key);
        return (value == null || value.trim().isEmpty()) ? defaultValue : value.trim();
    }
}