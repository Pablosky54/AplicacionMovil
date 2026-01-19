package com.frisby,tasks;

import com.example.frisby.screenplay.Actor;
import com.example.frisby.screenplay.abilities.UseMobileApp;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class AddToCart implements Task {

    public static AddToCart now() {
        return new AddToCart();
    }

    @Override
    public <T> void performAs(Actor actor) {
        UseMobileApp ability = actor.abilityTo(UseMobileApp.class);
        try {

            MobileElement firstResult = ability.getDriver().findElement(By.xpath("//android.widget.ListView/android.view.ViewGroup[1]"));
            MobileElement addButton = firstResult.findElement(By.id("com.frisby.app:id/add_to_cart"));
            addButton.click();
        } catch (Exception e) {
            System.out.println("AddToCart: placeholder locators used - ajusta a la app real. " + e.getMessage());
        }
    }
}