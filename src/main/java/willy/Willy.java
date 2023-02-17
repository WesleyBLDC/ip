package willy;

import java.io.IOException;

import willy.exception.WillyException;
import willy.parser.Parser;
import willy.storage.Storage;
import willy.task.TaskList;
import willy.ui.Ui;

/**
 * Represents the Willy class
 */
public class Willy {

    public Storage storage;
    public TaskList tList;
    public Ui ui;

    public Willy() {
        this.ui = new Ui();
        this.storage = new Storage();
        this.tList = new TaskList(this.storage); // load data done in storage class
    }

    /**
     * Creates a Willy class with a specified storage location to init/read from
     * 
     * @param filePath Filepath for custom constructor
     */
    public Willy(String filePath) {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        this.tList = new TaskList(this.storage); // load data done in storage class
    }

    /**
     * Run command to init parser and scan for next command
     * 
     * @throws IOException Exception handling
     * @throws WillyException Exception handling
     */
    public void run() throws IOException, WillyException {
        ui.showStartupMessage();
        boolean isExit = false;

        while (!isExit) {
            String command = ui.getCommand();
            Parser p = new Parser(tList);
            p.parseCommand(command);
            isExit = p.getExitStatus();
        }
    }

    /**
     * Main function loop to start the application
     * 
     * @param args args
     * @throws IOException ioexception handling
     * @throws WillyException willyexception handling
     */
    public static void main(String[] args) throws IOException, WillyException {
        new Willy("data/Willy.txt").run();
    }
}
