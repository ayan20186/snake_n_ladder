package com.example.snake_n_ladder;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class gameController implements Initializable {
    private Game gameObj;

    @FXML
    ImageView congratsScreen;
    @FXML
    Label p1;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public Label getP1() {
        return p1;
    }

    public void setP1(Label p1) {
        this.p1 = p1;
    }

    public Label getP2() {
        return p2;
    }

    public void setP2(Label p2) {
        this.p2 = p2;
    }

    @FXML
    Label p2Congrats,p1Congrats;

    @FXML
    Label p2;

    @FXML
    private Button dice;

    @FXML
    private ImageView blue, green;

    @FXML
    private ImageView dicenum;

    @FXML
    private Button menuButton, replayButton;

    @FXML
    private Text status;

    @FXML
    private ImageView diceArrow;

    public gameController(int i){
        //psedo constructor
    }

    public void newGame(String p1Name, String p2Name) throws InterruptedException {
        gameObj = new Game();
        //System.out.println(p1Name);
        display(p1Name, p2Name);

    }


    public gameController() throws InterruptedException {
        gameObj = new Game();
    }

    @FXML
    public void getCoordinates(MouseEvent event){
        status.setText("");
    }



    @FXML
    public void display(String p_1, String p_2){
        //System.out.println(p_1);
        p1.setText(p_1);
        p2.setText(p_2);

    }

    static{
//        TranslateTransition translateArrow = new TranslateTransition();
//        translateArrow.setNode(diceArrow);
//        translateArrow.setByY(20);
//        translateArrow.setDuration(Duration.millis(400));
//        translateArrow.setAutoReverse(true);
//        translateArrow.play();
    }




    @FXML
    public void dice(ActionEvent event) throws InterruptedException {



        Random random = new Random();
        String diceSource[] = {"1.png","2.png","3.png","4.png","5.png","6.png"};
        Dice diceroll = new Dice();
        diceroll.diceroll();
        Thread thread = new Thread(){
            public void run(){
                try {
                    for(int i=0;i<15;i++){
                        int random1 = random.nextInt(6)+1;
                        File file = new File("src/main/resources/com/example/snake_n_ladder/"+random1+".png");
                        dicenum.setImage(new Image(file.toURI().toString()));
                        Thread.sleep(50);

                    }
                    Platform.runLater(() -> {
                        int num = diceroll.getNum();
                        //System.out.println(diceSource[num - 1]);
                        Image diceImg = new Image("C:\\Users\\lenovo\\IdeaProjects\\snake_n_ladder\\src\\main\\resources\\com\\example\\snake_n_ladder\\" + diceSource[num - 1]);

                        try {
                            gameObj.gameplay(2, num,blue,green);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                        dicenum.setImage(diceImg);
                        dicenum.setFitWidth(66);
                        dicenum.setFitHeight(55);
                        dicenum.setX(195);
                        dicenum.setY(509);
                        if(gameObj.getP1().getTokenvalue()==100){
                            //System.out.println(getP1().getText());
                            popupCongrats(getP1().getText(), getP2().getText());
                        }
                        else if(gameObj.getP2().getTokenvalue()==100){
                            //System.out.println(getP2().getText());
                            popupCongrats(getP2().getText(),getP1().getText());
                        }

                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

    }

    public void popupCongrats(String name1, String name2){
        Image img = new Image("C:\\Users\\lenovo\\IdeaProjects\\snake_n_ladder\\src\\main\\resources\\com\\example\\snake_n_ladder\\congrats.png");
        congratsScreen.setImage(img);
        congratsScreen.setX(0);
        congratsScreen.setY(0);
        congratsScreen.setFitWidth(318);
        congratsScreen.setFitHeight(294);
        p1Congrats.setText(name1);
        p2Congrats.setText(name2);

    }

    public void setMenuButton(ActionEvent event) throws IOException {
        setBackButton(event);
    }

    public void translate(int x, int y,ImageView Blue,ImageView Green,Player p) throws InterruptedException {
       TranslateTransition translate;
        if(p.getToken().equals("Blue")){
             translate = new TranslateTransition(Duration.seconds(0.5),Blue);
        }
        else{
             translate = new TranslateTransition(Duration.seconds(0.5),Green);

        }

        translate.setByX(40*x);
        translate.setByY(40*y);


        SequentialTransition trans = new SequentialTransition(translate);
        trans.play();

    }

    public void setBackButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setReplayButton(ActionEvent event) throws IOException, InterruptedException {
        Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        newGame(getP1().getText(),getP2().getText());
    }


    public void move(int c, int f,int number,ImageView Blue,ImageView Green,Player p){
        boolean direction = true;       // true->right | false->left
        TranslateTransition trans1;
        TranslateTransition trans2;
        TranslateTransition trans3;

        if((c/10 == f/10) && (c%10 == 0)){
            if((f/10)%2==0){
                direction = true;
            }
            else{
                direction = false;
            }
            if(p.getToken().equals("Blue")){
                trans1 = new TranslateTransition(Duration.seconds(0.5),Blue);
            }
            else{
                trans1 = new TranslateTransition(Duration.seconds(0.5),Green);

            }
            trans1.setByX(40*0);
            trans1.setByY(40*-1);

            if(p.getToken().equals("Blue")){
                trans2 = new TranslateTransition(Duration.seconds(0.5),Blue);
            }
            else{
                trans2 = new TranslateTransition(Duration.seconds(0.5),Green);

            }
            if(direction){
                trans2.setByX(40*(number-1));
            }
            else{
                trans2.setByX(40*-(number-1));
            }
            SequentialTransition trans = new SequentialTransition(trans1,trans2);
            trans.play();

        }
        else if((c/10 == f/10) && (c%10 != 0)){
            if((f/10)%2==0){
                direction = true;
            }
            else{
                direction = false;
            }
            if(p.getToken().equals("Blue")){
                trans1 = new TranslateTransition(Duration.seconds(0.5),Blue);
            }
            else{
                trans1 = new TranslateTransition(Duration.seconds(0.5),Green);

            }
            if(direction){
                trans1.setByX(40*number);
            }
            else{
                trans1.setByX(40*-(number));
            }
            trans1.play();
        }
        else if((c/10 != f/10) && (f%10 == 0)){

            if((c/10)%2==0){
                direction = true;
            }
            else{
                direction = false;
            }
            if(p.getToken().equals("Blue")){
                trans1 = new TranslateTransition(Duration.seconds(0.5),Blue);
            }
            else{
                trans1 = new TranslateTransition(Duration.seconds(0.5),Green);

            }
            if(direction){
                trans1.setByX(40*number);
            }
            else{
                trans1.setByX(40*-(number));
            }
            SequentialTransition trans = new SequentialTransition(trans1);
            trans.play();
        }
        else if((c/10 != f/10)){
            if((c/10)%2==0){
                direction = true;
            }
            else{
                direction = false;
            }
            int moves = 10-(c%10);
            if(p.getToken().equals("Blue")){
                trans1 = new TranslateTransition(Duration.seconds(0.5),Blue);
            }
            else{
                trans1 = new TranslateTransition(Duration.seconds(0.5),Green);

            }
            if(direction){
                trans1.setByX(40*moves);
            }
            else{
                trans1.setByX(40*-(moves));
            }
            if(p.getToken().equals("Blue")){
                trans2 = new TranslateTransition(Duration.seconds(0.5),Blue);
            }
            else{
                trans2 = new TranslateTransition(Duration.seconds(0.5),Green);

            }
            trans2.setByX(40*0);
            trans2.setByY(40*-1);

            if((f/10)%2==0){
                direction = true;
            }
            else{
                direction = false;
            }

            moves = (f%10)-1;
            if(p.getToken().equals("Blue")){
                trans3 = new TranslateTransition(Duration.seconds(0.5),Blue);
            }
            else{
                trans3 = new TranslateTransition(Duration.seconds(0.5),Green);

            }
            if(direction){
                trans3.setByX(40*moves);
            }
            else{
                trans3.setByX(40*-(moves));
            }
            SequentialTransition trans = new SequentialTransition(trans1,trans2,trans3);
            trans.play();

        }
    }

    public void snakefall(Snake s,Player p,ImageView Blue, ImageView Green,Board b){
        PauseTransition pause = new PauseTransition(Duration.seconds(1.6));
        pause.setOnFinished(event ->{
                    TranslateTransition translate_1;
                    TranslateTransition translate_2;
                    TranslateTransition translate_3;


                    if(p.getToken().equals("Blue")){
                        translate_1 = new TranslateTransition(Duration.seconds(0.5),Blue);
                        translate_2 = new TranslateTransition(Duration.seconds(0.5),Blue);
                        translate_3 = new TranslateTransition(Duration.seconds(0.5),Blue);

                    }
                    else{
                        translate_1 = new TranslateTransition(Duration.seconds(0.5),Green);
                        translate_2 = new TranslateTransition(Duration.seconds(0.5),Green);
                        translate_3 = new TranslateTransition(Duration.seconds(0.5),Green);


                    }
                    translate_1.setByX(s.getA());
                    translate_1.setByY(s.getB());
                    //System.out.println(s.getX());

                    translate_2.setByX(s.getC());
                    translate_2.setByY(s.getD());

                    translate_3.setByX(s.getX());
                    translate_3.setByY(s.getY());
                    //System.out.println(s.getY());


                    SequentialTransition trans = new SequentialTransition(translate_1,translate_2,translate_3);
                    trans.play();
                }
                //do thing
        );
        pause.play();
    }
    public void ladderclimb(Ladder l,Player p,ImageView Blue, ImageView Green,Board b) throws InterruptedException {

        PauseTransition pause = new PauseTransition(Duration.seconds(1.6));
        pause.setOnFinished(event ->{
                    TranslateTransition translate;

                    if(p.getToken().equals("Blue")){
                        translate = new TranslateTransition(Duration.seconds(0.5),Blue);
                    }
                    else{
                        translate = new TranslateTransition(Duration.seconds(0.5),Green);

                    }
                    translate.setByX(l.getX());
                    //System.out.println(l.getX());
                    translate.setByY(l.getY());
                    //System.out.println(l.getY());
                    translate.play();
                }
                //do thing
        );
        pause.play();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition translateArrow = new TranslateTransition();
        translateArrow.setNode(diceArrow);
        translateArrow.setByY(20);
        translateArrow.setDuration(Duration.millis(400));
        translateArrow.setCycleCount(TranslateTransition.INDEFINITE);
        translateArrow.setAutoReverse(true);
        translateArrow.play();
    }
}
