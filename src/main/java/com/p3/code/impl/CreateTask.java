package com.p3.code.impl;

import com.p3.code.Command;
import com.p3.code.model.Task;
import com.p3.code.TaskManager;

public class CreateTask implements Command {

    private TaskManager taskManager;
    private Task task;

    public CreateTask(TaskManager taskManager, Task task) {
        this.taskManager = taskManager;
        this.task = task;
    }
    @Override
    public void execute() {
        if (taskManager != null && task != null) {
            taskManager.addTask(task);
        } else {
            throw new IllegalArgumentException("TaskManager or Task cannot be null");
        }
    }

    @Override
    public void undo() {
        if (taskManager != null && task != null) {
            taskManager.removeTask(task);
        }
    }
}
