package io.github.mwosiek.todoapp.model.event;

import io.github.mwosiek.todoapp.model.Task;

import java.time.Clock;

public class TaskUndone extends TaskEvent {
    TaskUndone(final Task source) {
        super(source.getId(), Clock.systemDefaultZone());
    }
}
