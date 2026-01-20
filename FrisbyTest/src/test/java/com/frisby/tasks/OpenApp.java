package com.frisby.tasks;

import com.frisby.utils.Actor;
import com.frisby.utils.UseMobileApp;
import io.appium.java_client.AppiumDriver;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class OpenTheApp implements Task {

    public static OpenTheApp now() {
        return new OpenTheApp();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        AppiumDriver driver = (AppiumDriver) BrowseTheWeb.as(actor).getDriver();

        UseMobileApp ability = actor.abilityTo(UseMobileApp.class);
        // Métodos disponibles de AppiumDriver
        //driver.launchApp();           // Lanzar desde background
        // driver.resetApp();         // Reiniciar completamente
        // driver.closeApp();         // Cerrar la app
        // driver.activateApp("com.package.name"); // Activar app específica
        try {
            driver.launchApp();
        } catch (Exception e) {

            System.out.println("OpenTheApp: launchApp fallback - " + e.getMessage());
        }
    }

}