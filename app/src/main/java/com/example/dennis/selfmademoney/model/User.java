package com.example.dennis.selfmademoney.model;

public class User {

    private final long id;
    private final String username;
    private String password;
    private final String email;

    public User(final long id, final String username, final String email, String password){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
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

}
