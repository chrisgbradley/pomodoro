package main;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class PomodoroController implements Initializable {

    //IMAGES AND ICONS
    private final Image closeUnfocused = new Image(this.getClass().getResourceAsStream("resources/icons8-close-window-50.png"));
    private final Image closeFocused = new Image(this.getClass().getResourceAsStream("resources/icons8-close-window-50-hover.png"));

    //TOOLBAR
    @FXML
    Button close;
    @FXML
    ImageView closeButtonImageView;

    //UI
    @FXML
    Button add;
    @FXML
    Button less;
    @FXML
    Text timerText;
    @FXML
    Button start;
    @FXML
    Button stop;

    private PomodoroTimer pomodoroTimer;

    private void initWindowButtons() {
        close.setOnAction(actionEvent -> {
            pomodoroTimer.stop();
            Platform.exit();
        });
        close.setOnMouseEntered(actionEvent -> closeButtonImageView.setImage(closeFocused));
        close.setOnMouseExited(actionEvent -> closeButtonImageView.setImage(closeUnfocused));
    }

    private void initPomodoroTimer() {
        pomodoroTimer = new PomodoroTimer();
        timerText.setText(pomodoroTimer.getTime());

        pomodoroTimer.intervalInSecondsProperty()
                .addListener((observable, oldValue, newValue) -> {
                    timerText.setText(pomodoroTimer.getTime());
                    System.out.println(pomodoroTimer.getTime());
                });
    }

    private void initUIButtons() {
        add.setOnAction(actionEvent -> pomodoroTimer.add(1));
        less.setOnAction(actionEvent -> pomodoroTimer.less(1));
        start.setOnAction(actionEvent -> pomodoroTimer.start());
        stop.setOnAction(actionEvent -> pomodoroTimer.stop());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initWindowButtons();
        initPomodoroTimer();
        initUIButtons();
    }
}
