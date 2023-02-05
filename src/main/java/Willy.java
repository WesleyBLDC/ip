import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exception.WillyException;
import task.Deadline;
import task.Event;
import task.Task;
import task.TaskList;
import task.ToDos;

public class Willy {
    public static void main(String[] args) {
        String logo = "Willy";
        System.out.println("Hello! I'm " + logo +
                "\nWhat can I do for you?");

        Scanner sc = new Scanner(System.in);

        List<Task> lst = new ArrayList<Task>();
        TaskList tList = new TaskList();

        while (true) {
            // Init scanner
            String command = sc.nextLine();

            // For marking
            String[] temp = command.split(" ");

            // For adding
            String[] tempAdd = command.split("/");
            // Task tempAddTask = lst.get(Integer.parseInt(temp[1]) - 1);

            try {
                if (command.contains("mark")) {
                    Task tempTask = lst.get(Integer.parseInt(temp[1]) - 1);
                    tempTask.mark();
                } else if (command.contains("unmark")) {
                    Task tempTask = lst.get(Integer.parseInt(temp[1]) - 1);
                    tempTask.unmark();
                } else if (command.contains("delete")) {
                    System.out.println(" Noted. I've removed this task:");
                    Task tempTask = lst.get(Integer.parseInt(temp[1]) - 1);
                    System.out.println(tempTask.toString());

                    lst.remove(Integer.parseInt(temp[1]) - 1);
                    System.out.format("Now you have %d things in your list%n", lst.size());
                } else if (command.equals("list")) {
                    // for (int index = 0; index < lst.size(); index++) {
                    //     Task curr = lst.get(index);
                    //     System.out.println((index + 1) + ") " + curr.toString());
                    // }
                    tList.getTaskCount();
                    System.out.println("test");
                } else if (command.equals("bye")) {
                    System.out.println("Bye. Hope to see you again soon!");
                    System.exit(0);
                    sc.close();
                } else if (command.equals("blah")) {
                    throw new WillyException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                } else {
                    if (command.contains("todo")) {
                        if (command.length() > 4) {
                            // ToDos newT = new ToDos(command);
                            // lst.add(newT);
                            // System.out.println(newT.toString());
                            // System.out.format("Now you have %d things in your list%n", lst.size());
                            tList.addTodo(command);
                        } else {
                            throw new WillyException("☹ OOPS!!! The description of a todo cannot be empty.");
                        }
                    }
                    if (command.contains("deadline")) {
                        Deadline newD = new Deadline(tempAdd[0], tempAdd[1]);
                        lst.add(newD);
                        System.out.println(newD.toString());
                        System.out.format("Now you have %d things in your list %n", lst.size());
                    }
                    if (command.contains("event")) {
                        Event newE = new Event(tempAdd[0], tempAdd[1], tempAdd[2]);
                        lst.add(newE);
                        System.out.println(newE.toString());
                        System.out.format("Now you have %d things in your list %n", lst.size());
                    }

                }
            } catch (WillyException e) {
                System.out.println(e.getMessage());
            }

        }

    }
}
