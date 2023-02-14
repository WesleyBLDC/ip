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

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String HELP_DATA_PATH = "data/help.txt";
    /**
     * To get and return the string collected by the BufferedReader
     * 
     * @return String
     * @throws IOException
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
     * @param e
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
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(HELP_DATA_PATH));
            return new String(bytes);
        } catch (IOException e) {
            return "Failed to read file: " + e.getMessage();
        }
    }
}
