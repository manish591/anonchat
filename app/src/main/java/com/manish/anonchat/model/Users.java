package com.manish.anonchat.model;

public class Users {
    private String username;

    public Users(String username) {
        this.username = username;
    };

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    };
}
