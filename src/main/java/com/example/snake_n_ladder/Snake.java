package com.example.snake_n_ladder;

public class Snake {
    private int head;
    private int tail;
    private int x;
    private int y;
    private int a;
    private int b;
    private int c;
    private int d;

    public Snake(int head,int tail,int x, int y,int a, int b , int c , int d){
        this.setHead(head);
        this.setTail(tail);
        this.setX(x);
        this.setY(y);
        this.setA(a);
        this.setB(b);
        this.setC(c);
        this.setD(d);

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
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }
}