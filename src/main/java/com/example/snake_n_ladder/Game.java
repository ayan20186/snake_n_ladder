package com.example.snake_n_ladder;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Game {

    private Board b1;
    private Board b2;
    private Board b3;
    private Board b4;
    private Player p1;
    private Player p2;
    private Dice dice;
    private boolean p1_turn;
    private boolean p2_turn;
    private gameController gamecontrol;
    private static ArrayList<Board> boards = new ArrayList<>();
    private static ArrayList<Player> players = new ArrayList<>();

    public Game() throws InterruptedException {
        addBoard();
        addPlayer();
        addDice();
        this.p1_turn = true;
        this.p2_turn = false;
        this.gamecontrol = new gameController(1);
    }




    public void gameplay(int option, int number,ImageView blue,ImageView green) throws InterruptedException {

        if(p1.getTokenvalue()!=100 && p2.getTokenvalue()!=100){
            if(this.p1_turn){
                //System.out.println("Player 1's turn");
                //System.out.println(number);
                if(number == 1){
                    if(p1.isOpenflag()){

                        if(p1.getTokenvalue()+1 > 100){
                            this.p1_turn = false;
                            this.p2_turn = true;
                        }
                        else{
                            gamecontrol.move(p1.getTokenvalue(),p1.getTokenvalue()+number,number,blue,green,p1);
                            p1.setTokenvalue(p1.getTokenvalue() + number);
                            if(option==1){
                                for(Snake s: b1.getSnakes()){
                                    if(s.getHead()==p1.getTokenvalue()){
                                        p1.setTokenvalue(s.getTail());
                                    }
                                }
                                for(Ladder l: b1.getLadders()){
                                    if(l.getTail()==p1.getTokenvalue()){
                                        p1.setTokenvalue(l.getHead());
                                    }
                                }
                            }
                            else if(option==2){
                                for(Snake s: b2.getSnakes()){
                                    if(s.getHead()==p1.getTokenvalue()){
                                        gamecontrol.snakefall(s,p1,blue,green,b2);
                                        p1.setTokenvalue(s.getTail());
                                    }
                                }

                                for(Ladder l: b2.getLadders()){
                                    if(l.getTail()==p1.getTokenvalue()){
                                        gamecontrol.ladderclimb(l,p1,blue,green,b2);
                                        p1.setTokenvalue(l.getHead());
                                    }
                                }
                            }
                            else if(option==3){
                                for(Snake s: b3.getSnakes()){
                                    if(s.getHead()==p1.getTokenvalue()){
                                        p1.setTokenvalue(s.getTail());
                                    }
                                }
                                for(Ladder l: b3.getLadders()){
                                    if(l.getTail()==p1.getTokenvalue()){
                                        p1.setTokenvalue(l.getHead());
                                    }
                                }

                            }
                            else if(option==4){
                                for(Snake s: b4.getSnakes()){
                                    if(s.getHead()==p1.getTokenvalue()){
                                        p1.setTokenvalue(s.getTail());
                                    }
                                }
                                for(Ladder l: b4.getLadders()){
                                    if(l.getTail()==p1.getTokenvalue()){
                                        p1.setTokenvalue(l.getHead());
                                    }
                                }

                            }
                            this.p1_turn = false;
                            this.p2_turn = true;
                        }
                    }
                    else{
                        p1.setOpenflag(true);

                        p1.setTokenvalue(p1.getTokenvalue()+1);

                        gamecontrol.translate(0,-1,blue,green,p1);
                        if(option==1){
                            for(Snake s: b1.getSnakes()){
                                if(s.getHead()==p1.getTokenvalue()){
                                    p1.setTokenvalue(s.getTail());
                                }
                            }
                            for(Ladder l: b1.getLadders()){
                                if(l.getTail()==p1.getTokenvalue()){
                                    p1.setTokenvalue(l.getHead());
                                }
                            }

                        }
                        else if(option==2){
                            for(Snake s: b2.getSnakes()){
                                if(s.getHead()==p1.getTokenvalue()){
                                    gamecontrol.snakefall(s,p1,blue,green,b2);
                                    p1.setTokenvalue(s.getTail());
                                }
                            }
                            for(Ladder l: b2.getLadders()){
                                if(l.getTail()==p1.getTokenvalue()){
                                    gamecontrol.ladderclimb(l,p1,blue,green,b2);
                                    p1.setTokenvalue(l.getHead());
                                }
                            }

                        }
                        else if(option==3){
                            for(Snake s: b3.getSnakes()){
                                if(s.getHead()==p1.getTokenvalue()){
                                    p1.setTokenvalue(s.getTail());
                                }
                            }
                            for(Ladder l: b3.getLadders()){
                                if(l.getTail()==p1.getTokenvalue()){
                                    p1.setTokenvalue(l.getHead());
                                }
                            }

                        }
                        else if(option==4){
                            for(Snake s: b4.getSnakes()){
                                if(s.getHead()==p1.getTokenvalue()){
                                    p1.setTokenvalue(s.getTail());
                                }
                            }
                            for(Ladder l: b4.getLadders()){
                                if(l.getTail()==p1.getTokenvalue()){
                                    p1.setTokenvalue(l.getHead());
                                }
                            }

                        }
                        this.p1_turn = false;
                        this.p2_turn = true;
                    }
                }
                else{
                    if(p1.isOpenflag()){
                        if(p1.getTokenvalue()+number<=100){

                            gamecontrol.move(p1.getTokenvalue(),p1.getTokenvalue()+number,number,blue,green,p1);
                            p1.setTokenvalue(p1.getTokenvalue() + number);


                            if(option==1){
                                for(Snake s: b1.getSnakes()){
                                    if(s.getHead()==p1.getTokenvalue()){
                                        p1.setTokenvalue(s.getTail());
                                    }
                                }
                                for(Ladder l: b1.getLadders()){
                                    if(l.getTail()==p1.getTokenvalue()){
                                        p1.setTokenvalue(l.getHead());
                                    }
                                }

                            }
                            else if(option==2){

                                for(Snake s: b2.getSnakes()){
                                    if(s.getHead()==p1.getTokenvalue()){
                                        gamecontrol.snakefall(s,p1,blue,green,b2);
                                        p1.setTokenvalue(s.getTail());

                                    }
                                }
                                for(Ladder l: b2.getLadders()){
                                    if(l.getTail()==p1.getTokenvalue()){
                                        gamecontrol.ladderclimb(l,p1,blue,green,b2);
                                        p1.setTokenvalue(l.getHead());
                                    }
                                }
                            }
                            else if(option==3){
                                for(Snake s: b3.getSnakes()){
                                    if(s.getHead()==p1.getTokenvalue()){
                                        p1.setTokenvalue(s.getTail());
                                    }
                                }
                                for(Ladder l: b3.getLadders()){
                                    if(l.getTail()==p1.getTokenvalue()){
                                        p1.setTokenvalue(l.getHead());
                                    }
                                }
                            }
                            else if(option==4){
                                for(Snake s: b4.getSnakes()){
                                    if(s.getHead()==p1.getTokenvalue()){
                                        p1.setTokenvalue(s.getTail());
                                    }
                                }
                                for(Ladder l: b4.getLadders()){
                                    if(l.getTail()==p1.getTokenvalue()){
                                        p1.setTokenvalue(l.getHead());
                                    }
                                }

                            }
                        }
                    }
                    this.p1_turn = false;
                    this.p2_turn = true;
                }
                //System.out.println("p1's number: "+p1.getTokenvalue());

            }
            else if(this.p2_turn){
                //System.out.println("Player 2's turn");
                //System.out.println(number);
                if(number == 1){
                    if(p2.isOpenflag()){
                        if(p2.getTokenvalue()+1 > 100){
                            this.p2_turn = false;
                            this.p1_turn = true;
                        }
                        else{
                            gamecontrol.move(p2.getTokenvalue(),p2.getTokenvalue()+number,number,blue,green,p2);
                            p2.setTokenvalue(p2.getTokenvalue()+1);
                            if(option==1){
                                for(Snake s: b1.getSnakes()){
                                    if(s.getHead()==p2.getTokenvalue()){

                                        p2.setTokenvalue(s.getTail());
                                    }
                                }
                                for(Ladder l: b1.getLadders()){
                                    if(l.getTail()==p2.getTokenvalue()){
                                        p2.setTokenvalue(l.getHead());
                                    }
                                }

                            }
                            else if(option==2){
                                for(Snake s: b2.getSnakes()){
                                    if(s.getHead()==p2.getTokenvalue()){
                                        gamecontrol.snakefall(s,p2,blue,green,b2);
                                        p2.setTokenvalue(s.getTail());
                                    }
                                }
                                for(Ladder l: b2.getLadders()){
                                    if(l.getTail()==p2.getTokenvalue()){
                                        gamecontrol.ladderclimb(l,p2,blue,green,b2);
                                        p2.setTokenvalue(l.getHead());
                                    }
                                }

                            }
                            else if(option==3){
                                for(Snake s: b3.getSnakes()){
                                    if(s.getHead()==p2.getTokenvalue()){
                                        p2.setTokenvalue(s.getTail());
                                    }
                                }
                                for(Ladder l: b3.getLadders()){
                                    if(l.getTail()==p2.getTokenvalue()){
                                        p2.setTokenvalue(l.getHead());
                                    }
                                }

                            }
                            else if(option==4){
                                for(Snake s: b4.getSnakes()){
                                    if(s.getHead()==p2.getTokenvalue()){
                                        p2.setTokenvalue(s.getTail());
                                    }
                                }
                                for(Ladder l: b4.getLadders()){
                                    if(l.getTail()==p2.getTokenvalue()){
                                        p2.setTokenvalue(l.getHead());
                                    }
                                }
                            }
                            this.p2_turn = false;
                            this.p1_turn = true;
                        }
                    }
                    else{
                        p2.setOpenflag(true);
                        p2.setTokenvalue(p2.getTokenvalue()+1);
                        gamecontrol.translate(0,-1,blue,green,p2);

                        if(option==1){
                            for(Snake s: b1.getSnakes()){
                                if(s.getHead()==p2.getTokenvalue()){
                                    p2.setTokenvalue(s.getTail());
                                }
                            }
                            for(Ladder l: b1.getLadders()){
                                if(l.getTail()==p2.getTokenvalue()){
                                    p2.setTokenvalue(l.getHead());
                                }
                            }

                        }
                        else if(option==2){
                            for(Snake s: b2.getSnakes()){
                                if(s.getHead()==p2.getTokenvalue()){
                                    gamecontrol.snakefall(s,p2,blue,green,b2);
                                    p2.setTokenvalue(s.getTail());
                                }
                            }
                            for(Ladder l: b2.getLadders()){
                                if(l.getTail()==p2.getTokenvalue()){
                                    gamecontrol.ladderclimb(l,p2,blue,green,b2);
                                    p2.setTokenvalue(l.getHead());
                                }
                            }
                        }
                        else if(option==3){
                            for(Snake s: b3.getSnakes()){
                                if(s.getHead()==p2.getTokenvalue()){
                                    p2.setTokenvalue(s.getTail());
                                }
                            }
                            for(Ladder l: b3.getLadders()){
                                if(l.getTail()==p2.getTokenvalue()){
                                    p2.setTokenvalue(l.getHead());
                                }
                            }
                        }
                        else if(option==4){
                            for(Snake s: b4.getSnakes()){
                                if(s.getHead()==p2.getTokenvalue()){
                                    p2.setTokenvalue(s.getTail());
                                }
                            }
                            for(Ladder l: b4.getLadders()){
                                if(l.getTail()==p2.getTokenvalue()){
                                    p2.setTokenvalue(l.getHead());
                                }
                            }
                        }
                        this.p2_turn = false;
                        this.p1_turn = true;
                    }
                }
                else{
                    if(p2.isOpenflag()){
                        if(p2.getTokenvalue()+number<=100){
                            gamecontrol.move(p2.getTokenvalue(),p2.getTokenvalue()+number,number,blue,green,p2);
                            p2.setTokenvalue(p2.getTokenvalue()+number);
                            if(option==1){
                                for(Snake s: b1.getSnakes()){
                                    if(s.getHead()==p2.getTokenvalue()){
                                        p2.setTokenvalue(s.getTail());
                                    }
                                }
                                for(Ladder l: b1.getLadders()){
                                    if(l.getTail()==p2.getTokenvalue()){
                                        p2.setTokenvalue(l.getHead());
                                    }
                                }

                            }
                            else if(option==2){

                                for(Snake s: b2.getSnakes()){
                                    if(s.getHead()==p2.getTokenvalue()){
                                        gamecontrol.snakefall(s,p2,blue,green,b2);
                                        p2.setTokenvalue(s.getTail());
                                    }
                                }
                                for(Ladder l: b2.getLadders()){
                                    if(l.getTail()==p2.getTokenvalue()){
                                        gamecontrol.ladderclimb(l,p2,blue,green,b2);
                                        p2.setTokenvalue(l.getHead());

                                    }
                                }
                            }
                            else if(option==3){
                                for(Snake s: b3.getSnakes()){
                                    if(s.getHead()==p2.getTokenvalue()){
                                        p2.setTokenvalue(s.getTail());
                                    }
                                }
                                for(Ladder l: b3.getLadders()){
                                    if(l.getTail()==p2.getTokenvalue()){
                                        p2.setTokenvalue(l.getHead());
                                    }
                                }
                            }
                            else if(option==4){
                                for(Snake s: b4.getSnakes()){
                                    if(s.getHead()==p2.getTokenvalue()){
                                        p2.setTokenvalue(s.getTail());
                                    }
                                }
                                for(Ladder l: b4.getLadders()){
                                    if(l.getTail()==p2.getTokenvalue()){
                                        p2.setTokenvalue(l.getHead());
                                    }
                                }
                            }
                        }
                    }
                    this.p2_turn = false;
                    this.p1_turn = true;


                }
                //System.out.println("p2's number: "+p2.getTokenvalue());
            }



        }

    }



    public void addDice(){
        dice = new Dice();
        dice.diceroll();
    }

    public void addPlayer(){
        p1 = new Player(1,"p1","Blue");
        p2 = new Player(2,"p2","Green");
        players.add(p1);
        players.add(p2);
    }

    public void addBoard(){
        b1 = new Board();
        b2 = new Board();
        b3 = new Board();
        b4 = new Board();

//        b1.addSnake(11,9);
//        b1.addSnake(36,14);
//        b1.addSnake(56,18);
//        b1.addSnake(43,22);
//        b1.addSnake(90,50);
//        b1.addSnake(94,53);
//        b1.addSnake(75,54);
//        b1.addSnake(81,63);
//        b1.addSnake(96,65);
//        b1.addSnake(99,78);
//        b1.addLadder(25,4);
//        b1.addLadder(31,8);
//        b1.addLadder(60,21);
//        b1.addLadder(46,28);
//        b1.addLadder(48,32);
//        b1.addLadder(80,42);
//        b1.addLadder(77,58);
//        b1.addLadder(68,52);
//        b1.addLadder(93,69);
//        b1.addLadder(98,84);

        b2.addSnake(28,14, -40, 0,-40,20,40,20);
        b2.addSnake(26,16, -40, 0,-40,20,40,20);
        b2.addSnake(24,18, -40, 0,-40,20,40,20);
        b2.addSnake(55,34, 40, 26,40,27,-40,27);
        b2.addSnake(57,36, 40, 26,40,27,-40,27);
        b2.addSnake(59,38, 40 , 26,40,27,-40,27);
        b2.addSnake(91,50, 15, 66,-25,67,10,67);
        b2.addSnake(95,74, 40, 26,40,27,-40,27);
        b2.addSnake(97,76, 40, 26,40,27,-40,27);
        b2.addSnake(99,78, 40, 26,40,27,-40,27);
        b2.addLadder(17,5, -40,-40);
        b2.addLadder(15,7, -40, -40);
        b2.addLadder(13,9, -40, -40);
        b2.addLadder(47,33, -40, -40);
        b2.addLadder(45,35, -40, -40);
        b2.addLadder(43,37, -40, -40);
        b2.addLadder(81,40, 0, -200);
        b2.addLadder(83,64, -40, -80);
        b2.addLadder(85,66, -40, -80);
        b2.addLadder(87,68, -40, -80);

//        b3.addSnake(22,2);
//        b3.addSnake(15,5);
//        b3.addSnake(33,8);
//        b3.addSnake(44,23);
//        b3.addSnake(68,50);
//        b3.addSnake(79,43);
//        b3.addSnake(94,47);
//        b3.addSnake(85,65);
//        b3.addSnake(92,71);
//        b3.addSnake(98,82);
//        b3.addLadder(24,3);
//        b3.addLadder(34,7);
//        b3.addLadder(31,12);
//        b3.addLadder(41,20);
//        b3.addLadder(46,36);
//        b3.addLadder(63,56);
//        b3.addLadder(81,60);
//        b3.addLadder(93,69);
//        b3.addLadder(95,75);
//        b3.addLadder(97,78);

//        b4.addSnake(43,3);
//        b4.addSnake(40,20);
//        b4.addSnake(99,19);
//        b4.addSnake(97,44);
//        b4.addSnake(56,16);
//        b4.addSnake(95,66);
//        b4.addSnake(67,34);
//        b4.addSnake(27,7);
//        b4.addSnake(93,73);
//        b4.addSnake(72,12);
//        b4.addLadder(81,61);
//        b4.addLadder(60,41);
//        b4.addLadder(98,58);
//        b4.addLadder(37,4);
//        b4.addLadder(96,65);
//        b4.addLadder(55,6);
//        b4.addLadder(94,74);
//        b4.addLadder(68,8);
//        b4.addLadder(92,89);
//        b4.addLadder(90,10);

        boards.add(b1);
        boards.add(b2);
        boards.add(b3);
        boards.add(b4);
//         System.out.println(b1.getLadders());
//         System.out.println(b1.getSnakes());
//         System.out.println(b2.getLadders());
//         System.out.println(b2.getSnakes());
//         System.out.println(b3.getLadders());
//         System.out.println(b3.getSnakes());
//         System.out.println(b4.getLadders());
//         System.out.println(b4.getSnakes());

    }

    public static ArrayList<Board> getBoards() {
        return boards;
    }

    public static void setBoards(ArrayList<Board> boards) {
        Game.boards = boards;
    }
    public Board getB1() {
        return b1;
    }

    public void setB1(Board b1) {
        this.b1 = b1;
    }

    public Board getB2() {
        return b2;
    }

    public void setB2(Board b2) {
        this.b2 = b2;
    }

    public Board getB3() {
        return b3;
    }

    public void setB3(Board b3) {
        this.b3 = b3;
    }

    public Board getB4() {
        return b4;
    }

    public void setB4(Board b4) {
        this.b4 = b4;
    }
    public Player getP1() {
        return p1;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public Player getP2() {
        return p2;
    }

    public void setP2(Player p2) {
        this.p2 = p2;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static void setPlayers(ArrayList<Player> players) {
        Game.players = players;
    }
    public boolean isP1_turn() {
        return this.p1_turn;
    }

    public void setP1_turn(boolean p1_turn) {
        this.p1_turn = p1_turn;
    }

    public boolean isP2_turn() {
        return p2_turn;
    }

    public void setP2_turn(boolean p2_turn) {
        this.p2_turn = p2_turn;
    }

    public gameController getGamecontrol() {
        return gamecontrol;
    }

    public void setGamecontrol(gameController gamecontrol) {
        this.gamecontrol = gamecontrol;
    }

}
