package cst8334_group10.commands;

import java.util.Stack;

public class CommandInvoker {

    // Declare variables
    private final Stack<Command> undoStack;
    private static final CommandInvoker INSTANCE = new CommandInvoker();


    private CommandInvoker() {
        undoStack = new Stack<>();
    }

    /**
     * @return Instance of CommandInvoker
     */
    public static CommandInvoker getInstance() {
        return INSTANCE;
    }

    /**
     * Clears undoStack on game restart
     */
    public void restart() {
        undoStack.clear();
    }


    /**
     * Executes command and adds it to the stack
     *
     * @param command to be executed
     */
    public void executeOperation(Command command) {
        undoStack.push(command);
        command.execute();
        System.out.println("Command Executed");
    }

    /**
     * @return true if stack in not empty
     */
    public boolean isUndoAvailable() {
        return !undoStack.empty();
    }


    /**
     * Deletes the command from stack and undoes the game move
     */
    public boolean undoOperation() {
        if (isUndoAvailable()) {
            Command command = undoStack.pop();
            command.undo();
            return true;
        } else {
            System.out.println("Stack is empty");
            return false;
        }
    }

}
