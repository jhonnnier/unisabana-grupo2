package com.p3;

import com.p3.code.Command;
import com.p3.code.CommandManager;
import com.p3.code.model.Task;
import com.p3.code.TaskManager;
import com.p3.code.impl.CompleteTask;
import com.p3.code.impl.CreateTask;
import com.p3.code.impl.DeleteTask;
import com.p3.code.impl.EditTask;

public class Main {


    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();
        CommandManager commandManager = new CommandManager();

        Command creteTask = new CreateTask(taskManager, new Task(1, "Desarrollar api", "Mi primera tarea"));
        commandManager.executeCommand(creteTask);

        Command editTask = new EditTask(taskManager, new Task(1, "Desarrollar api", "tarea editada"));
        commandManager.executeCommand(editTask);

        Command completeTask = new CompleteTask(taskManager, new Task(1, "Desarrollar api", "tarea completada"));
        commandManager.executeCommand(completeTask);

        Command deleteTask = new DeleteTask(taskManager, new Task(1, "Desarrollar api", "tarea eliminada"));
        commandManager.executeCommand(deleteTask);

        commandManager.undo();
        commandManager.redo();


        //Command deleteTask = new DeleteTask(taskManager, new Task(1, "Desarrollar api", "Mi primera tarea"));


    }
}
