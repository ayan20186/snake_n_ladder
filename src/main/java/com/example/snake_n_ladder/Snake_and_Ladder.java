package com.example.snake_n_ladder;

import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Snake_and_Ladder extends Application {
    @Override
    public void start(Stage stage) throws IOException, InterruptedException {

        FXMLLoader fxmlLoader1 = new FXMLLoader(Snake_and_Ladder.class.getResource("loading.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load(), 500, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene1);
        stage.show();

        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(event ->{
                    FXMLLoader fxmlLoader = new FXMLLoader(Snake_and_Ladder.class.getResource("hello-view.fxml"));
                    Scene scene = null;
                    try {
                        scene = new Scene(fxmlLoader.load(), 500, 600);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    stage.setTitle("Ludo Master");
                    stage.setScene(scene);
                    stage.show();;
                }
                //do thing
        );
        pause.play();

//        FXMLLoader fxmlLoader = new FXMLLoader(Snake_and_Ladder.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 500, 600);
//        stage.setTitle("Ludo Master");
//        stage.setScene(scene);
//        stage.show();

        stage.setOnCloseRequest(windowEvent -> {
            windowEvent.consume();
            logout(stage);
        });
    }

    public static void main(String[] args) {
        launch();
    }

    public void logout(Stage stage){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to Exit");
        alert.setContentText("Do you want to Exit?");

        if(alert.showAndWait().get() == ButtonType.OK){
            System.out.println("logged out");
            stage.close();
        }

    }
}