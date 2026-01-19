package com.frisby.stepdefinitions;

import com.frisby.drivers.AppiumDriverFactory;
import com.frisby.utils.Actor;
import com.frisby.utils.UseMobileApp;
import com.frisby.questions.ItemIsDisplayed;
import com.frisby.tasks.AddToCart;
import com.frisby.tasks.OpenTheApp;
import com.frisby.tasks.SearchItem;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import static org.junit.Assert.*;

public class FrisbyStepDefinitions {

    private Actor actor;
    private AppiumDriver<MobileElement> driver;

    @Before
    public void setup() {

        driver = AppiumDriverFactory.create();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception ignore) {}
        }
    }

    @Given("que el actor {string} abre la aplicación")
    public void que_el_actor_abre_la_aplicación(String actorName) {
        actor = Actor.named(actorName).can(UseMobileApp.with(driver));
        OpenTheApp.now().performAs(actor);
    }

    @When("busca el producto {string}")
    public void busca_el_producto(String producto) {
        SearchItem.named(producto).performAs(actor);
    }

    @When("agrega el producto al carrito")
    public void agrega_el_producto_al_carrito() {
        AddToCart.now().performAs(actor);
    }

    @Then("debería ver el resultado {string}")
    public void debería_ver_el_resultado(String producto) {
        boolean visible = ItemIsDisplayed.called(producto).answeredBy(actor);
        assertTrue("Se esperaba ver el producto: " + producto, visible);
    }

    @Then("el carrito debería contener {string}")
    public void el_carrito_debería_contener(String producto) {
        boolean visible = ItemIsDisplayed.called(producto).answeredBy(actor);
        assertTrue("Se esperaba que el carrito contenga: " + producto, visible);
    }
}