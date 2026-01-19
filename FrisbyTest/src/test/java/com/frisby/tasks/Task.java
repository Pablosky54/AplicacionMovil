package com.frisby,tasks;

public interface Task {
    <T> void performAs(Actor actor);
}