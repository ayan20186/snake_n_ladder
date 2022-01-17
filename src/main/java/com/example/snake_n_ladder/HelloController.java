package com.example.snake_n_ladder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button logoutButton, playButton;

    @FXML
    private Button startButton;

    @FXML
    private Button backButton;

    @FXML
    TextField player1, player2;




    @FXML
    private AnchorPane entryScene;

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void logout(ActionEvent event){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to Exit");
        alert.setContentText("Do you want to Exit?");

        if(alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage)entryScene.getScene().getWindow();
            System.out.println("logged out");
            stage.close();
        }

    }

    public void play(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    public void enterDetails(ActionEvent event) throws IOException{
        String Player1 = player1.getText();
        String Player2 = player2.getText();
        System.out.println(Player1);



        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        root = loader.load();

        gameController game = loader.getController();
        game.display(Player1, Player2);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void setBackButton(ActionEvent event) throws  IOException{
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}