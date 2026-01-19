package com.example.frisby.screenplay;

public interface Task {
    <T> void performAs(Actor actor);
}