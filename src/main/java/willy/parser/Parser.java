package willy.parser;

import java.util.Arrays;
import willy.task.TaskList;
import willy.ui.Ui;

/**
 * Represents a parser
 */
public class Parser {

    private TaskList tList;
    private Ui ui;
    private boolean isExit;

    /**
     * Creates a parser with a specified tasklist
     * 
     * @param tList taskList
     */
    public Parser(TaskList tList) {
        this.tList = tList;
        this.isExit = false;
    }

    public Parser(TaskList tList, Ui ui) {
        this.tList = tList;
        this.ui = ui;
        this.isExit = false;
    }

    /**
     * Displays the number of items in your task list
     * 
     * @param tList taskList
     * @return String
     */
    public String listCommand(TaskList tList) {
        int taskCount = tList.getTaskCount();
        if (taskCount == 0) {
            return ui.emptyTaskListMessage();
        } else {
            return ui.nonEmptyTaskListMessage(taskCount, tList.toString());
        }
    }

    /**
     * get index based on the string helper function
     * 
     * @param input String input
     * @return the index of the task
     */
    public int getIndex(String input) {
        return Integer.parseInt(input) - 1;
    }

    /**
     * return the boolean the exit status
     * 
     * @return the Exit status of the program
     */
    public boolean getExitStatus() {
        return isExit;
    }

    /**
     * Runs the exit command which prints the bye msg and stops the program
     *
     * @return String for the parser
     */
    public String exitCommand() {
        isExit = true;
        return ui.exitMessage();
    }

    /**
     * Handler for todo commands
     *
     * @param command String
     * @return String for the parser
     */
    private String handleTodo(String command) {
        if (command.length() > 4) {
            return tList.addTodo(command);
        } else {
            return ui.emptyTodoMessage();
        }
    }

    /**
     * Handle for deadline commands
     * @param tempBySlash the string[]
     * @return String for the parser
     */
    private String handleDeadline(String[] tempBySlash) {
        if (tempBySlash.length > 2) {
            String combinedString = String.join(" ",
                    Arrays.asList(tempBySlash).subList(1, tempBySlash.length));
            String dateString = combinedString.substring(3);
            String[] dateArray = dateString.split(" ");
            return tList.addDeadlineWithDate(tempBySlash[0], dateArray);
        } else {
            return tList.addDeadline(tempBySlash[0], tempBySlash[1]);
        }
    }

    /**
     * handler for the event command
     * @param tempBySlash the string[]
     * @return string for the parser
     */
    private String handleEvent(String[] tempBySlash) {
        return tList.addEvent(tempBySlash[0], tempBySlash[1], tempBySlash[2]);
    }

    /**
     * Main parser function that takes in a command and executes the command
     * 
     * @param command string command
     * @return String for the dialog
     */

    public String parseCommand(String command) {
        assert command.length() != 0 : "The command cannot be empty";

        String[] tempBySpace = command.split(" ");
        String[] tempBySlash = command.split("/");

        if (tempBySpace[0].equals("mark")) {
            int index = getIndex(tempBySpace[1]);
            return tList.markTask(index);
        } else if (tempBySpace[0].equals("unmark")) {
            int index = getIndex(tempBySpace[1]);
            return tList.unmarkTask(index);
        } else if (tempBySpace[0].equals("find")) {
            return tList.findTasks(tempBySpace[1]);
        } else if (command.contains("delete")) {
            int index = getIndex(tempBySpace[1]);
            return tList.deleteTask(index);
        } else if (command.equals("list")) {
            return listCommand(tList);
        } else if (command.equals("bye")) {
            return exitCommand();
        } else if (command.equals("blah")) {
            return ui.oopsMessage();
        } else if (command.equals("help")) {
            return ui.helpMessage();
        } else {
            if (command.contains("todo")) {
                return handleTodo(command);
            }
            if (command.contains("deadline")) {
                return handleDeadline(tempBySlash);
            }
            if (command.contains("event")) {
                return handleEvent(tempBySlash);
            }
        }
        return ui.defaultReturnMessage();
    }

}
