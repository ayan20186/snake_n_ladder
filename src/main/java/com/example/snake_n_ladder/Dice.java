package com.example.snake_n_ladder;

import java.util.Random;

public class  Dice {
    private int num;
    public Dice(){}
    public void diceroll(){
        Random rand = new Random();
        num = rand.nextInt(6)+1;
    }
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}