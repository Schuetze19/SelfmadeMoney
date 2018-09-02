package com.example.dennis.selfmademoney.model;

import com.example.dennis.selfmademoney.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class User {

    private final long id;
    private final boolean male;
    private final String username, vorname, nachname, wohnort, email;
    private String password, beschreibung;
    private final Calendar mitgliedSeit = Calendar.getInstance();
    private final Calendar geborenAm = Calendar.getInstance();

    public User(final long id, final String vorname, final String nachname, final String username, final String email, String password, final Date geborenAm, final String wohnort, boolean male){
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.geborenAm.setTime(geborenAm);
        this.mitgliedSeit.setTime(new Date());
        this.wohnort = wohnort;
        this.male = male;
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

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getFullName(){
        return vorname+" "+nachname;
    }

    public String getGeborenAm() {
        return new SimpleDateFormat("dd.MM.yyyy").format(geborenAm.getTime());
    }

    public String getWohnort() {
        return wohnort;
    }

    public boolean isMale() {
        return male;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}
