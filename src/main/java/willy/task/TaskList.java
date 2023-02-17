package willy.task;

import java.util.ArrayList;
import java.util.List;

import willy.storage.Storage;

/**
 * Represents a tasklist
 */
public class TaskList {
    private static Storage storage;
    protected List<Task> tasks = new ArrayList<Task>();

    /**
     * Creates a tasklist with a storage
     */
    public TaskList() {
        this.storage = new Storage();
        List<Task> tmp = storage.loadData();
        this.tasks = tmp;
    }

    /**
     * Create a tasklist with a specified storage to be used
     * 
     * @param storage for specific storage path
     */
    public TaskList(Storage storage) {
        this.storage = storage;
        List<Task> tmp = storage.loadData();
        this.tasks = tmp;
    }

    /**
     * Get task count
     * 
     * @return int
     */
    public int getTaskCount() {
        return tasks.size();
    }

    /**
     * Based on the task index, will return the task
     * 
     * @param index the index of the task
     * @return the task at the index
     */
    public Task getTask(int index) {
        return tasks.get(index);
    }

    /**
     * Marks the task at the index as done
     * 
     * @param index the index of the task
     *
     * @return string for the parser
     */
    public String markTask(int index) {
        Task task = tasks.get(index);
        String str = task.mark();
        storage.save(this);
        return str;
    }

    /**
     * Unmarks the task at the index as undone
     * 
     * @param index the index of the task
     * @return string for the parser
     */
    public String unmarkTask(int index) {
        Task task = tasks.get(index);
        String str = task.unmark();
        storage.save(this);
        return str;
    }

    /**
     * delete task
     * 
     * @param index the index of the task
     * @return string for the parser
     */
    public String deleteTask(int index) {
        tasks.remove(index);
        storage.save(this);
        return "Successfully deleted this task";
    }

    /**
     * Command to add a todo to the tasklist
     * 
     * @param details the details of the task
     * @return string for the parser
     */
    public String addTodo(String details) {
        Todo entry = new Todo(details);
        tasks.add(entry);
        storage.save(this);
        String str = entry.toString();
        return str;
    }

    /**
     * Command to add a deadline to the tasklist
     * 
     * @param details the details of the task
     * @param date the date of the task
     * @return string for the parser
     */
    public String addDeadline(String details, String date) {
        Deadline entry = new Deadline(details, date);
        tasks.add(entry);
        storage.save(this);
        String str = entry.toString();
        return str;
    }

    /**
     * Command to add a deadline with a date format to the tasklist
     * 
     * @param details the details of the task
     * @param dateArray the datearray of the task
     * @return string for the parser
     */
    public String addDeadlineWithDate(String details, String[] dateArray) {
        Deadline entry = new Deadline(details, dateArray);
        tasks.add(entry);
        storage.save(this);
        String str = entry.toString();
        return str;
    }

    /**
     * Command to add a event to the tasklist
     * 
     * @param details the details of the task
     * @param dateFrom contains the from part of the date
     * @param dateTo contains the to part of the date
     * @return string for the parser
     */
    public String addEvent(String details, String dateFrom, String dateTo) {
        Event entry = new Event(details, dateFrom, dateTo);
        tasks.add(entry);
        storage.save(this);
        String str = entry.toString();
        return str;
    }

    /**
     * print all tasks in a list of strings that contains the keyword
     * 
     * @param keyword Contains the string
     * @return string for the parser
     */
    public String findTasks(String keyword) {
        StringBuilder sb = new StringBuilder("Here are the matching tasks in your list\n");
        String msg = "";
        int counter = 1;
        for (int i = 0; i < getTaskCount(); i++) {
            if (this.getTask(i).toString().contains(keyword)) {
                msg = "#" + counter + ". " + this.getTask(i);

                if (i == getTaskCount() - 1) {
                    // Marks the end of the tList
                    sb.append(msg);
                    counter++;
                } else {
                    sb.append(msg).append("\n");
                    counter++;
                }
            }

        }
        return sb.toString();
    }

    /**
     * Converts the tasklist into a combined string representation (need to check)
     *
     * @return string for the parser
     */
    @Override
    public String toString() {
        String str = "";
        String msg = "";
        for (int i = 0; i < getTaskCount(); i++) {
            msg = "#" + (i + 1) + ". " + this.getTask(i);

            if (i == getTaskCount() - 1) {
                // Marks the end of the tList
                str += msg;
            } else {
                str += msg + "\n";
            }
        }
        return str;
    }

}
