package com.manish.anonchat.model;

import java.sql.Timestamp;

public class Users {
    private String user_id;
    private String username;
    private Timestamp dob;

    Users(String user_id, String username, Timestamp dob) {
        this.username = username;
        this.user_id = user_id;
        this.dob = dob;
    };

    public Timestamp getDOB() {
        return this.dob;
    }

    public void setDOB(Timestamp dob) {
        this.dob = dob;
    };

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    };

    public String getUserId() {
        return this.user_id;
    }

    public void setUserId(String user_id) {
        this.user_id = user_id;
    };
}
