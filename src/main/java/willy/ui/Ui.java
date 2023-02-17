package willy.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Represents the Ui class
 */
public class Ui {

    private final String HELP_MESSAGE = "*Help Screen*\n\n" +
            "Please enter commands into the terminal in the following format.\n\n" +
            ">Main task creation commands\n" +
            "Task Type, Details in the following format\n\n" +
            "todo -> todo borrow book\n" +
            "Note: \"todo\" keyword must be infront.\n\n" +
            "deadline -> deadline return book /by Sunday\n" +
            "Note: \"deadline\" keyword must be infront and the date must come after the first instance of \"/\"\n\n" +
            "event -> event project meeting /from Mon 2pm /to 4pm\n" +
            "Note: \"event\" keyword must be infront. the from and to must be in said order and come after the first and second instance of \"/\" in order accordingly.\n\n" +
            ">Additional task commands\n\n" +
            "mark %d: It will mark the task in the index of the list as done\n" +
            "unmark %d: It will mark the task in the index of the list as undone\n" +
            "delete %d: It will delete the task in the said position in the list\n" +
            "find: to find keywords from the list of Tasks\n" +
            "list: to generate the list of Tasks\n" +
            "bye: to close the program\n" +
            "help: to call the help screen\n";

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    /**
     * To get and return the string collected by the BufferedReader
     * 
     * @return String
     * @throws IOException Exception handling
     */
    public String getCommand() throws IOException {
        String str = br.readLine();
        return str;
    }

    /**
     * Prints out the startup msg
     */
    public void showStartupMessage() {
        System.out.println("Hello! I'm Willy\nWhat can I do for you?");
    }

    /**
     * Prints out the error msg
     * 
     * @param e  Error handling
     */
    public void showError(String e) {
        System.out.println(e);
    }

    /**
     * Prints out a line divider
     */
    public void showLine() {
        System.out.println("\t____________________________________________________________");
    }

    /**
     * Prints out exit msg
     *
     * @return string for the parser
     */
    public String exitMessage() {
        return "Bye. Hope to see you again soon!";
    }

    /**
     * Prints out empty task list msg
     *
     * @return string for the parser
     */
    public String emptyTaskListMessage() {
        return "You have 0 tasks in your list";
    }

    /**
     * Prints out non empty task list msg
     *
     * @param taskCount number tasks
     * @param taskListMessage the tasklist message
     * @return string for the parser
     */
    public String nonEmptyTaskListMessage(int taskCount, String taskListMessage) {
        return String.format("You have %d tasks in your list \n%s", taskCount, taskListMessage);
    }

    /**
     * Prints out oopsMessage
     *
     * @return string for the parser
     */
    public String oopsMessage(){
        return "☹ OOPS!!! I'm sorry, but I don't know what that means :-(";
    }

    /**
     * Prints out exit msg
     *
     * @return string for the parser
     */
    public String emptyTodoMessage(){
        return "☹ OOPS!!! The description of a todo cannot be empty.";
    }

    /**
     * Prints out defaultReturnMessag
     *
     * @return string for the parser
     */
    public String defaultReturnMessage(){
        return "I didnt understand that";
    }

    /**
     * Prints out helpMessage
     *
     * @return string for the parser
     */
    public String helpMessage() {
        return HELP_MESSAGE;
    }
}
