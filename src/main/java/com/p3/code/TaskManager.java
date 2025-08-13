package com.p3.code;

import com.p3.code.model.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class TaskManager {

    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
        log.info("Task added: {}", task);

    }

    public void removeTask(Task task) {
        int index = tasks.indexOf(task);
        if (index != -1) {
            Task t = tasks.get(index);
            t.setDelete(true);
            tasks.set(index, t);
        }
        log.info("Task removed: {}", task);
    }

    public void editTask(Task task) {
        int index = tasks.indexOf(task);
        if (index != -1) {
            tasks.set(index, task);
        }
        log.info("Task edited: {}", task);
    }

    public void completeTask(Task task) {
        int index = tasks.indexOf(task);
        if (index != -1) {
            Task t = tasks.get(index);
            t.setCompleted(true);
            tasks.set(index, t);
        }
        log.info("Task completed: {}", task);
    }



    public Task getTask(int id) {
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .orElse(null);
    }



}
