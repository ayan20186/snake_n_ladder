package com.example.snake_n_ladder;

import java.util.ArrayList;

public class Board {
    private Snake snake;
    private Ladder ladder;
    private ArrayList<Snake> snakes = new ArrayList<>();
    private ArrayList<Ladder> ladders = new ArrayList<>();

    public Board(){

    }
    public void addSnake(int head , int tail, int x, int y,int a, int b, int c, int d){
        snake = new Snake(head,tail,x,y,a,b,c,d);
        snakes.add(snake);

    }
    public void addLadder(int head , int tail, int x, int y){
        ladder = new Ladder(head,tail,x,y);
        ladders.add(ladder);
    }
    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public void setLadder(Ladder ladder) {
        this.ladder = ladder;
    }

    public ArrayList<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(ArrayList<Snake> snakes) {
        this.snakes = snakes;
    }

    public ArrayList<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(ArrayList<Ladder> ladders) {
        this.ladders = ladders;
    }
}