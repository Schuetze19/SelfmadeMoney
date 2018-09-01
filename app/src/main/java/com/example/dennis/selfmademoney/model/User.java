package com.example.dennis.selfmademoney.model;

public class User {

    private final long id;
    private final String username;
    private String password;
    private final String email;

    public User(final String username, final String email, String password){
        // Id wird durch die Datenbank selbst erstellt und fortgezählt, weshalb man es nicht setzen sollte.
        this.username = username;
        this.email = email;
        this.password = password;
        this.id = 0L;
    }

    // Wird nur für das generieren von Testdaten benötigt. Wenn eine richtige Datenbank dahinter ist, wird dieser Konstruktor entfernt.
    public User(final long id, final String username, final String email, String password){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id == 0L ? (long)(Math.random()*11) : id;
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
