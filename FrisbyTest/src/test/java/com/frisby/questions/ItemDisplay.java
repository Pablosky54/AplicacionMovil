package com.frisby.questions;

import com.frisby.utils.Actor;
import com.frisby.utils.UseMobileApp;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class ItemIsDisplayed {

    private final String itemName;

    public ItemIsDisplayed(String itemName) {
        this.itemName = itemName;
    }

    public static ItemIsDisplayed called(String itemName) {
        return new ItemIsDisplayed(itemName);
    }

    public boolean answeredBy(Actor actor) {
        UseMobileApp ability = actor.abilityTo(UseMobileApp.class);
        try {

            java.util.List<MobileElement> items = ability.getDriver()
                    .findElements(By.xpath("//*[contains(@text, '" + itemName + "')]"));
            return items != null && !items.isEmpty();
        } catch (Exception e) {
            System.out.println("ItemIsDisplayed: error al buscar item - " + e.getMessage());
            return false;
        }
    }
}