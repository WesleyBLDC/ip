package willy.task;

import java.util.Arrays;

/**
 * Represents a Task
 */
public class Task {
    private String msg;
    private Boolean isStatus;

    /**
     * Creates a task with a msg
     * @param msg contains the main msg of the task
     */
    public Task(String msg) {
        this.msg = getSecondWordOnwards(msg);
        this.isStatus = false;
    }

    /**
     * Get status icon.
     * @return String
     */
    public String getStatusIcon() {
        return (isStatus ? "[X]" : "[ ]");
    }

    /**
     * get msg in String
     * @return string representation of the msg only
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Marks the status as done and prints a msg
     *
     * @return String
     */
    public String mark() {
        isStatus = true;
        String str = "Nice! I've marked this task as done:\n" + getStatusIcon() + msg;
        return str;
    }

    /**
     * Unmarks the status as undone and prints a msg
     *
     * @return String
     */
    public String unmark() {
        isStatus = false;
        String str = "OK, I've unmarked this task:\n" + getStatusIcon() + msg;
        return str;
    }

    public static String getSecondWordOnwards(String str) {
        String[] words = str.split("\\s+");
        if (words.length < 2) {
            return ""; // there are less than two words in the string
        } else {
            return String.join(" ", Arrays.copyOfRange(words, 1, words.length));
        }
    }

    /**
     * Returns the string representation of the task
     */
    @Override
    public String toString() {
//        return this.getStatusIcon() + getSecondWordOnwards(msg);
        return this.getStatusIcon() + msg;
//        return this.getStatusIcon();
    }
}
