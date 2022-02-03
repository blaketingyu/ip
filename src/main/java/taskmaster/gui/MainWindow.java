package taskmaster.gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import taskmaster.Taskmaster;

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

    private Taskmaster taskmaster;


    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/lord.png"));
    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/alphamale.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    public void setTaskmaster(Taskmaster t) {
        taskmaster = t;
    }

    @FXML
    public void greet() {
        dialogContainer.getChildren().addAll(
                DialogBox.getTaskmasterDialog(taskmaster.getOpeningMessage(), dukeImage)
        );
    }


    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = taskmaster.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getTaskmasterDialog(response, dukeImage)
        );
        userInput.clear();
        if (taskmaster.isExit()) {
            new Thread(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                Platform.exit();
                System.exit(0);
            }).start();
        }
    }
}
