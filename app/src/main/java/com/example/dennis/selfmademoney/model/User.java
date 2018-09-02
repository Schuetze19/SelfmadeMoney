package com.example.dennis.selfmademoney.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class User {

    private final long id;
    private final String username;
    private String password;
    private final String email;
    private final Calendar mitgliedSeit = Calendar.getInstance();

    public User(final long id, final String username, final String email, String password){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.mitgliedSeit.setTime(new Date());
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getMitgliedSeit(){
        return new SimpleDateFormat("dd.MM.yyyy").format(mitgliedSeit.getTime());
    }

}
