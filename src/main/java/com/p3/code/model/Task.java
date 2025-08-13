package com.p3.code.model;

import lombok.Data;

@Data
public class Task {

    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }


    private int id;
    private String title;
    private String description;
    private boolean completed = false;
    private boolean delete = false;


}
