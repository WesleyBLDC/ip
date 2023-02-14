package willy.task;

/**
 * Represents a Task
 */
public class Task {
    private String msg;
    private Boolean isStatus;

    /**
     * Creates a task with a msg
     * @param msg
     */
    public Task(String msg) {
        this.msg = msg;
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
     */
    public String mark() {
        isStatus = true;
        String str = "Nice! I've marked this task as done:\n" + getStatusIcon() + msg;
        return str;
    }

    /**
     * Unmarks the status as undone and prints a msg
     */
    public String unmark() {
        isStatus = false;
        String str = "OK, I've unmarked this task:\n" + getStatusIcon() + msg;
        return str;
    }

    /**
     * Returns the string representation of the task
     */
    @Override
    public String toString() {
        return this.getStatusIcon() + msg;
    }
}
