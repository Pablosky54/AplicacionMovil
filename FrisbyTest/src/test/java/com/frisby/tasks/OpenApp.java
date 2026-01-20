package com.frisby.tasks;

import com.frisby.utils.Actor;
import com.frisby.utils.UseMobileApp;

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