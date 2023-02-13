package willy;

import java.util.Objects;

import willy.DialogBox;
import willy.parser.Parser;
import willy.storage.Storage;
import willy.task.TaskList;
import willy.ui.Ui;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;

/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Willy willy;
    private TaskList taskList;
    private Storage storage;
    private Ui ui;

    private final Image userImage = new Image(Objects.requireNonNull(this.getClass()
            .getResourceAsStream("/images/daBatman.png")));
    private final Image willyImage = new Image(Objects.requireNonNull(this.getClass()
            .getResourceAsStream("/images/daWilly.png")));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    public void setWilly(Willy d) {
        willy = d;
        this.taskList = willy.tList;
        this.storage = willy.storage;
        this.ui = willy.ui;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing willy's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        Label userText = new Label(userInput.getText());
        Label willyText = new Label(getResponse(userInput.getText()));
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(userText, new ImageView(userImage)),
                DialogBox.getWillyDialog(willyText, new ImageView(willyImage)));
        userInput.clear();
    }
    // private void handleUserInput() {
    //     String input = userInput.getText();
    //     String response = willy.getResponse(input);
    //     dialogContainer.getChildren().addAll(
    //             DialogBox.getUserDialog(input, userImage),
    //             DialogBox.getwillyDialog(response, willyImage)
    //     );
    //     userInput.clear();
    // }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     * 
     */
    private String getResponse(String input) {
        Parser p = new Parser(this.taskList, this.ui);
        String response = p.parseCommand(input);
        return response;
    }
}
