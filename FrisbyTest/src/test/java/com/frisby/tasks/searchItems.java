package com.frisby,tasks;

import com.example.frisby.screenplay.Actor;
import com.example.frisby.screenplay.abilities.UseMobileApp;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class SearchItem implements Task {
    private final String itemName;

    public SearchItem(String itemName) {
        this.itemName = itemName;
    }

    public static SearchItem named(String itemName) {
        return new SearchItem(itemName);
    }

    @Override
    public <T> void performAs(Actor actor) {
        UseMobileApp ability = actor.abilityTo(UseMobileApp.class);

        try {

            MobileElement searchBox = ability.getDriver().findElement(By.id("com.frisby.app:id/search_box"));
            searchBox.click();
            searchBox.clear();
            searchBox.sendKeys(itemName);

            MobileElement searchButton = ability.getDriver().findElement(By.id("com.frisby.app:id/search_button"));
            searchButton.click();

        } catch (Exception e) {
            System.out.println("SearchItem: placeholder locators used - ajusta a la app real. " + e.getMessage());
        }
    }
}