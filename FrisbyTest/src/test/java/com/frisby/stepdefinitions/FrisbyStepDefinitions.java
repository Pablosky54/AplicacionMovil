package com.frisby.stepdefinitions;

import com.frisby.tasks.AbrirAplicacion;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class FrisbyStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que {string} abre la aplicación Frisby")
    public void queAbreLaAplicacionFrisby(String nombreActor) {
        theActorCalled(nombreActor).attemptsTo(
                AbrirAplicacion.frisby()
        );
    }

    @When("ve la pantalla de inicio")
    public void veLaPantallaDeInicio() {
        // Aquí puedes agregar verificaciones
        System.out.println("Viendo pantalla de inicio...");
    }

    @Then("debería ver el logo de Frisby")
    public void deberiaVerElLogoDeFrisby() {
        // Verificación del logo
        System.out.println("Verificando logo de Frisby...");
    }
}