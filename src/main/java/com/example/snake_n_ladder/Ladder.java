package com.example.snake_n_ladder;

public class Ladder {
    private int head;
    private int tail;
    private int x;
    private int y;


    public Ladder(int head,int tail,int x,int y){
        this.setHead(head);
        this.setTail(tail);
        this.setX(x);
        this.setY(y);

    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }






}
