package com.p3.code;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class CommandManager {

    private List<Command> undoStack = new java.util.ArrayList<>();
    private List<Command> redoStack = new java.util.ArrayList<>();

    public void executeCommand(Command command) {
        command.execute();
        undoStack.add(command);
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            log.info("Undoing command...");
            Command command;
            command = undoStack.remove(undoStack.size() - 1);
            command.undo();
            redoStack.add(command);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            log.info("Redoing command...");
            Command command = redoStack.remove(redoStack.size() - 1);
            command.execute();
            undoStack.add(command);
        }
    }
}
