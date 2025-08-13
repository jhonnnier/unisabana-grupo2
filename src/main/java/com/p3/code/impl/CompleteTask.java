package com.p3.code.impl;

import com.p3.code.Command;
import com.p3.code.model.Task;
import com.p3.code.TaskManager;

public class CompleteTask implements Command {

    private TaskManager taskManager;
    private Task task;
    private boolean previousCompletionState;

    public CompleteTask(TaskManager taskManager, Task task) {
        this.taskManager = taskManager;
        this.task = task;
    }

    @Override
    public void execute() {

        if (taskManager != null && task != null) {
            Task existingTask = taskManager.getTask(task.getId());
            if (existingTask != null) {
                previousCompletionState = existingTask.isCompleted();
                taskManager.completeTask(task);
            } else {
                throw new IllegalArgumentException("Task with ID " + task.getId() + " does not exist.");
            }
        } else {
            throw new IllegalArgumentException("TaskManager or Task cannot be null");
        }


    }

    @Override
    public void undo() {
        if (taskManager != null && task != null) {
            // Restaurar el estado previo de completado
            Task currentTask = taskManager.getTask(task.getId());
            if (currentTask != null) {
                currentTask.setCompleted(previousCompletionState);
                taskManager.editTask(currentTask);
            }
        }
    }
}
