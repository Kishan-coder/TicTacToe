package com.scaler.model.player;


public class HumanUser {
    private int id;
    private String userName;
    private byte[] photo;
    private int played;
    private int won;

    public HumanUser(String userName, byte[] photo, int id) {
        this.id = id;
        this.userName = userName;
        this.photo = photo;
        this.played = 0;
        this.won = 0;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }
}
