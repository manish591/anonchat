package com.manish.anonchat.model;

import java.sql.Timestamp;

public class Users {
    private String user_id;
    private String username;

    Users(String user_id, String username, Timestamp dob) {
        this.username = username;
        this.user_id = user_id;
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
