package com.p3.code.impl;

import com.p3.code.Command;
import com.p3.code.model.Task;
import com.p3.code.TaskManager;

public class DeleteTask implements Command {

    private TaskManager taskManager;
    private Task task;
    private Task deletedTask;

    public DeleteTask(TaskManager taskManager, Task task) {
        this.taskManager = taskManager;
        this.task = task;
    }

    @Override
    public void execute() {

        if (taskManager != null && task != null) {
            // Guardar una copia de la tarea antes de eliminarla
            Task existingTask = taskManager.getTask(task.getId());
            if (existingTask != null) {
                deletedTask = new Task(
                    existingTask.getId(),
                    existingTask.getTitle(),
                    existingTask.getDescription()
                );
                deletedTask.setCompleted(existingTask.isCompleted());
                deletedTask.setDelete(existingTask.isDelete());

                // Realizar la eliminación
                taskManager.removeTask(task);
            }
        } else {
            throw new IllegalArgumentException("TaskManager or Task cannot be null");
        }

    }

    @Override
    public void undo() {
        if (taskManager != null && deletedTask != null) {
            // Restaurar la tarea eliminada
            deletedTask.setDelete(false);
            taskManager.addTask(deletedTask);
        }
    }

}
