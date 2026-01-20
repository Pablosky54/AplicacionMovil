package com.frisby.tasks;

import io.appium.java_client.AppiumDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AbrirAplicacion implements Task {

    public static AbrirAplicacion frisby() {
        return instrumented(AbrirAplicacion.class);
    }

    @Step("{0} abre la aplicación Frisby")
    @Override
    public <T extends Actor> void performAs(T actor) {
        // El driver ya se inicializa automáticamente con Serenity
        // Solo verificamos que la app esté abierta
        AppiumDriver driver = (AppiumDriver) BrowseTheWeb.as(actor).getDriver();

        // Verificar que la app está corriendo
        String currentActivity = driver.currentActivity();
        System.out.println("Actividad actual: " + currentActivity);

        // Esperar un momento para que cargue
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}