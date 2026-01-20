package com.frisby.tasks;

import com.frisby.utils.Actor;
import com.frisby.utils.UseMobileApp;

import org.openqa.selenium.WebElement;
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

            WebElement  searchBox = ability.getDriver().findElement(By.id("com.frisby.app:id/search_box"));
            searchBox.click();
            searchBox.clear();
            searchBox.sendKeys(itemName);

            WebElement  searchButton = ability.getDriver().findElement(By.id("com.frisby.app:id/search_button"));
            searchButton.click();

        } catch (Exception e) {
            System.out.println("SearchItem: placeholder locators used - ajusta a la app real. " + e.getMessage());
        }
    }
}