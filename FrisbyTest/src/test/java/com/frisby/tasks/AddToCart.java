package com.frisby.tasks;

import com.frisby.utils.Actor;
import com.frisby.utils.UseMobileApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddToCart implements Task {

    public static AddToCart now() {
        return new AddToCart();
    }

    @Override
    public <T> void performAs(Actor actor) {
        UseMobileApp ability = actor.abilityTo(UseMobileApp.class);
        try {

            WebElement firstResult = ability.getDriver().findElement(By.xpath("//android.widget.ListView/android.view.ViewGroup[1]"));
            WebElement addButton = firstResult.findElement(By.id("com.frisby.app:id/add_to_cart"));
            addButton.click();
        } catch (Exception e) {
            System.out.println("AddToCart: placeholder locators used - ajusta a la app real. " + e.getMessage());
        }
    }
}