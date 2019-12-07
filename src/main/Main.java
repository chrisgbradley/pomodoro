package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.initStyle(StageStyle.UNDECORATED);

        BorderPane root = FXMLLoader.load(getClass().getResource("Pomodoro.fxml"));

        primaryStage.setTitle("Pomodoro Timer");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
