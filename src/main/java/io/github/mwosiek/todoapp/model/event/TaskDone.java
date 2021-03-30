package io.github.mwosiek.todoapp.model.event;

import io.github.mwosiek.todoapp.model.Task;

import java.time.Clock;

    public class TaskDone extends TaskEvent{
        public TaskDone(final Task source) {
            super(source.getId(), Clock.systemDefaultZone());
        }
    }
