package com.frisby,tasks;

import com.example.frisby.screenplay.Actor;
import com.example.frisby.screenplay.abilities.UseMobileApp;

public class OpenTheApp implements Task {

    public static OpenTheApp now() {
        return new OpenTheApp();
    }

    @Override
    public <T> void performAs(Actor actor) {
        UseMobileApp ability = actor.abilityTo(UseMobileApp.class);

        try {
            ability.getDriver().launchApp();
        } catch (Exception e) {

            System.out.println("OpenTheApp: launchApp fallback - " + e.getMessage());
        }
    }
}