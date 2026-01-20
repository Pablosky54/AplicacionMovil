package com.frisby.tasks;

import com.frisby.utils.Actor;

public interface Task {
    <T> void performAs(Actor actor);
}