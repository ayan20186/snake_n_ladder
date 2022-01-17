package com.example.snake_n_ladder;

public class Player {
    private String token;
    private int tokenvalue;
    private boolean openflag;
    private int ID;
    private String Name;

    public Player(int id, String name,String token){
        this.setID(id);
        this.setName(name);
        this.setTokenvalue(0);
        this.setToken(token);
        this.setOpenflag(false);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getTokenvalue() {
        return tokenvalue;
    }

    public void setTokenvalue(int tokenvalue) {
        this.tokenvalue = tokenvalue;
    }
    public boolean isOpenflag() {
        return openflag;
    }

    public void setOpenflag(boolean openflag) {
        this.openflag = openflag;
    }
}