package main;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class PomodoroController implements Initializable {
    private final Image closeUnfocused = new Image(this.getClass().getResourceAsStream("resources/icons8-close-window-50.png"));
    private final Image closeFocused = new Image(this.getClass().getResourceAsStream("resources/icons8-close-window-50-hover.png"));

    @FXML
    Button close;
    @FXML
    ImageView closeButtonImageView;

    private void initWindowButtons() {
        close.setOnAction(actionEvent -> Platform.exit());
        close.setOnMouseEntered(actionEvent -> closeButtonImageView.setImage(closeFocused));
        close.setOnMouseExited(actionEvent -> closeButtonImageView.setImage(closeUnfocused));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initWindowButtons();
    }
}
