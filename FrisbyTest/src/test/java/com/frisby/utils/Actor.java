package com.frisby.utils;

import java.util.HashMap;
import java.util.Map;

public class Actor {
    private final String name;
    private final Map<Class<?>, Object> abilities = new HashMap<>();

    public Actor(String name) {
        this.name = name;
    }

    public static Actor named(String name) {
        return new Actor(name);
    }

    public <T> Actor can(T ability) {
        abilities.put(ability.getClass(), ability);
        return this;
    }

    public <T> T abilityTo(Class<T> abilityClass) {
        return abilityClass.cast(abilities.get(abilityClass));
    }

    public String getName() {
        return name;
    }
}