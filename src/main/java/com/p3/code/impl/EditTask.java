package com.p3.code.impl;

import com.p3.code.Command;
import com.p3.code.model.Task;
import com.p3.code.TaskManager;

public class EditTask implements Command {

    private TaskManager taskManager;
    private Task task;
    private Task previousState;

    public EditTask(TaskManager taskManager, Task task) {
        this.taskManager = taskManager;
        this.task = task;
    }

    @Override
    public void execute() {
        final Task findTask = taskManager.getTask(task.getId());
        if (findTask != null) {
            previousState = new Task(
                taskManager.getTask(task.getId()).getId(),
                taskManager.getTask(task.getId()).getTitle(),
                taskManager.getTask(task.getId()).getDescription()
            );
            previousState.setCompleted(findTask.isCompleted());
            previousState.setDelete(findTask.isDelete());

            taskManager.editTask(task);
        } else {
            System.out.println("Task with ID " + task.getId() + " does not exist.");
        }
    }

    @Override
    public void undo() {
        if (taskManager != null && previousState != null) {
            taskManager.editTask(previousState);
        }
    }
}
