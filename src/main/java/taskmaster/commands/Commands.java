package taskmaster.commands;

import taskmaster.exception.DukeExceptions;
import taskmaster.util.TaskList;
import taskmaster.util.Storage;
import taskmaster.userinterface.UserInterface;

/*
 * This class encapsulates commands that executed
 * according to the user's input
 */

public abstract class Commands {
    protected String command;

    /**
     * Constructor for Command Objects.
     *
     * @param command - The command the user entered
     */

    public Commands(String command) {
        this.command = command;
    }


    /**
     *  Execute Command.
     */

    public abstract String execute(TaskList tasklist, UserInterface ui, Storage storage) throws DukeExceptions;


    public boolean isExit() {
        return this instanceof ByeCommands;
    }
}
